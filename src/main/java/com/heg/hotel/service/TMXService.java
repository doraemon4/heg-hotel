package com.heg.hotel.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.heg.hotel.helper.response.tmx.TmsResult;
import com.heg.hotel.infrastructure.dao.HotelMapper;
import com.heg.hotel.infrastructure.entity.HotelPO;
import org.apache.ibatis.executor.BatchExecutorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 10:57
 */
@Service
public class TMXService {
    @Autowired
    private HotelMapper hotelMapper;

    public String pullHotel(String path) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(path)));
        TmsResult result = JSON.parseObject(data, TmsResult.class);
        List<HotelPO> hotelPOS = Lists.newArrayList();
        AtomicInteger count = new AtomicInteger();
        result.getHotelStaticListResult().getHotels().forEach(hotel -> {
            count.getAndIncrement();
            System.out.println(count);
            hotelPOS.add(convert(hotel));
        });

        List<List<HotelPO>> partition = Lists.partition(hotelPOS, 1000);
        for (List<HotelPO> dataList : partition) {
            try{
                hotelMapper.insertOrUpdate(dataList);
            }catch (BatchExecutorException e){

            }

        }

      return "success";
    }

    private HotelPO convert(TmsResult.HotelStaticListResultBean.HotelsBean hotelStaticInfo){
        String hotelCode = hotelStaticInfo.getHotelId();
        String hotelName = hotelStaticInfo.getName();
        String cityName = hotelStaticInfo.getCityName();
        String cityCode = hotelStaticInfo.getCityCode();
        String countryCode = hotelStaticInfo.getCountryCode();
        String latitude = hotelStaticInfo.getLatitude();
        String longitude = hotelStaticInfo.getLongitude();
        String phone = hotelStaticInfo.getPhone();
        String rating = hotelStaticInfo.getStarRating();


        HotelPO hotelPO = new HotelPO();
        hotelPO.setHotelCode(hotelCode);
        hotelPO.setHotelName(hotelName);
        hotelPO.setCityName(cityName);
        hotelPO.setCityCode(cityCode);
        hotelPO.setCountryCode(countryCode);
        hotelPO.setLatitude(latitude.toString());
        hotelPO.setLongitude(longitude.toString());
        hotelPO.setHotelAddress(hotelStaticInfo.getAddress());
        hotelPO.setPhone(phone);
        hotelPO.setRating(new BigDecimal(rating));
        hotelPO.setProviderName("tmx");
        return hotelPO;
    }
}
