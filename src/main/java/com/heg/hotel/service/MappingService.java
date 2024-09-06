package com.heg.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.heg.hotel.infrastructure.dao.HotelMapper;
import com.heg.hotel.infrastructure.dao.HotelMappingMapper;
import com.heg.hotel.infrastructure.entity.HotelMappingPO;
import com.heg.hotel.infrastructure.entity.HotelPO;
import com.heg.hotel.util.CosineSimilarityUtil;
import com.heg.hotel.util.GenerateIDUtil;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 14:01
 */
@Service
public class MappingService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedissonClient redisson;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private HotelMappingMapper hotelMappingMapper;
    @Resource(name = "pullExecutor")
    private TaskExecutor executor;

    @Autowired
    private JedisPool jedisPool;


    public void match() {
        //double latitude = 32.668206, longitude = -97.248256;
        /*RGeo<String> geo = redisson.getGeo("geo-expedia-US");
        Map<String, Double> result = geo.radiusWithDistance(longitude,latitude,10, GeoUnit.METERS);

        Circle circle = new Circle(new Point(116.397128, 39.916527), new Distance(10, Metrics.MILES));
        GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = redisTemplate.opsForGeo().radius("geo-expedia-US",circle);
        System.out.println(geoResults);*/

        int pageNum = 1;
        int size = 100;
        for (int i = 0; i < 500; i++) {
            //分页查询tmx酒店数据
            QueryWrapper<HotelPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("provider_name","tmx");
            Page<HotelPO> page = new Page<>(pageNum,size);
            Page<HotelPO> result = hotelMapper.selectPage(page,queryWrapper);
            if (CollectionUtils.isEmpty(result.getRecords())) {
                return;
            }
            CompletableFuture.supplyAsync(() -> {
                for (HotelPO hotelPO : result.getRecords()) {
                   /* HotelPO entity = new HotelPO();
                    entity.setLatitude(hotelPO.getLatitude());
                    entity.setLongitude(hotelPO.getLongitude());
                    List<HotelPO> filter = hotelMapper.selectByCoordinate(entity);*/
                    try(Jedis jedis = jedisPool.getResource()) {
                        List<GeoRadiusResponse> list = jedis.georadius("geo-expedia-US", Double.valueOf(hotelPO.getLongitude()), Double.valueOf(hotelPO.getLatitude()), 10, GeoUnit.M);
                        //System.out.println(list);
                        //1.经纬度匹配
                        if (!CollectionUtils.isEmpty(list)) {
                            //2.通过手机号匹配
                            List<String> hotelCodes = list.stream().map(GeoRadiusResponse::getMemberByString).collect(Collectors.toList());
                            QueryWrapper<HotelPO> condition = new QueryWrapper<>();
                            condition.in("hotel_code",hotelCodes);
                            List<HotelPO> hotelPOS = hotelMapper.selectList(condition);
                            Optional<HotelPO> optional = hotelPOS.stream().filter(f -> f.getPhone().replaceAll("[ /-]","").
                                    contains(hotelPO.getPhone().replaceAll("[ /-]",""))).findFirst();
                            if (optional.isPresent()) {
                                //手机号存在包含的关系,
                                saveMapping(optional.get(),hotelPO);
                            }else{
                                //手机号不存在包含关系，匹配酒店名称和酒店地址相似度
                                hotelPOS.stream().filter(f-> {
                                    if(!StringUtils.isEmpty(f.getPhone())){
                                        if ((CosineSimilarityUtil.computeCosineSimilarity(f.getHotelName().replace(","," "),hotelPO.getHotelName().replace(","," ")) >= 0.8) &&
                                                (CosineSimilarityUtil.computeCosineSimilarity(f.getHotelAddress().replace(","," "), hotelPO.getHotelAddress().replace(","," "))) >= 0.8)
                                            return true;
                                    }
                                    return false;
                                }).findFirst().ifPresent(v->saveMapping(v,hotelPO));
                            }
                        }
                    }
                }
                return null;
            },executor);
            pageNum++;
        }
    }

    public Map<String,List<HotelMappingPO>> group(){
        QueryWrapper<HotelMappingPO> queryWrapper = new QueryWrapper();
        Map<String,List<HotelMappingPO>> result = hotelMappingMapper.selectList(queryWrapper).stream()
                .collect(Collectors.groupingBy(HotelMappingPO::getHotelCode));
        return result;
    }

    public void saveMapping(HotelPO match,HotelPO condition) {
        List<HotelMappingPO> hotelMappingPOS = Lists.newArrayList();
        HotelMappingPO hotelMappingPO = new HotelMappingPO();
        String hotelCode = GenerateIDUtil.generateShortUuid();
        hotelMappingPO.setHotelCode(hotelCode);
        hotelMappingPO.setSupplierHotelCode(match.getHotelCode());
        hotelMappingPO.setProviderName(match.getProviderName());
        hotelMappingPOS.add(hotelMappingPO);

        HotelMappingPO hotelMappingPO2 = new HotelMappingPO();
        hotelMappingPO2.setHotelCode(hotelCode);
        hotelMappingPO2.setSupplierHotelCode(condition.getHotelCode());
        hotelMappingPO2.setProviderName(condition.getProviderName());
        hotelMappingPOS.add(hotelMappingPO2);
        hotelMappingMapper.insert(hotelMappingPOS);
    }
}
