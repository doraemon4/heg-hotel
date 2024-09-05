package com.heg.hotel.service;

import com.expediagroup.sdk.core.model.paging.ResponsePaginator;
import com.expediagroup.sdk.rapid.models.PropertyContent;
import com.google.common.collect.Lists;
import com.heg.hotel.helper.ExpediaHelper;
import com.heg.hotel.infrastructure.dao.HotelMapper;
import com.heg.hotel.infrastructure.entity.HotelPO;
import org.redisson.api.BatchResult;
import org.redisson.api.RGeo;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/5 9:19
 */
@Service
public class ExpediaService {
    @Autowired
    private ExpediaHelper expediaHelper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RedissonClient redisson;
    @Resource(name = "pullExecutor")
    private TaskExecutor executor;

    public String pullHotel(String countryCode) {
        ResponsePaginator<Map<String,PropertyContent>> responsePaginator = expediaHelper.getPropertyContent(countryCode);
        responsePaginator.forEachRemaining(page -> {
            CompletableFuture.supplyAsync(() -> {
                Map<String, PropertyContent> result = page.getData();
                List<HotelPO> hotelPOS = Lists.newArrayList();
                result.entrySet().stream().forEach(entity->{
                    String hotelCode = entity.getKey();
                    PropertyContent propertyContent = entity.getValue();
                    HotelPO hotelPO = convert(propertyContent);
                    //坐标同步redis
                    RGeo<String> geo = redisson.getGeo("geo-expedia-US");
                    //geo.add(hotelPO.getLongitude().doubleValue(), hotelPO.getLatitude().doubleValue(), hotelPO.getHotelCode());
                    geo.add(Double.valueOf(hotelPO.getLongitude()), Double.valueOf(hotelPO.getLatitude()), hotelPO.getHotelCode());
                    hotelPOS.add(hotelPO);
                });
                return hotelMapper.insertOrUpdate(hotelPOS);
            }, executor);
        });
        return "SUCCESS";
    }

    private HotelPO convert(PropertyContent propertyContent) {
        String hotelCode = propertyContent.getPropertyId();
        String hotelName = propertyContent.getName();
        String cityName = propertyContent.getAddress().getCity();
        String countryCode = propertyContent.getAddress().getCountryCode();
        String provinceCode = propertyContent.getAddress().getStateProvinceCode();
        String provinceName = propertyContent.getAddress().getStateProvinceName();
        BigDecimal latitude = propertyContent.getLocation().getCoordinates().getLatitude();
        BigDecimal longitude = propertyContent.getLocation().getCoordinates().getLongitude();
        String postalCode = propertyContent.getAddress().getPostalCode();
        String addressLine1 = propertyContent.getAddress().getLine1();
        String addressLine2 = propertyContent.getAddress().getLine2();
        String phone = propertyContent.getPhone();
        String fax = propertyContent.getFax();
        String rating = propertyContent.getRatings().getProperty().getRating();

        HotelPO hotelPO = new HotelPO();
        hotelPO.setHotelCode(hotelCode);
        hotelPO.setHotelName(hotelName);
        hotelPO.setCityName(cityName);
        hotelPO.setProvinceCode(provinceCode);
        hotelPO.setProvinceName(provinceName);
        hotelPO.setCountryCode(countryCode);
        hotelPO.setLatitude(latitude.toString());
        hotelPO.setLongitude(longitude.toString());
        hotelPO.setPostalCode(postalCode);
        hotelPO.setHotelAddress(StringUtils.isEmpty(addressLine2)?addressLine1:String.join(",", addressLine1,addressLine1));
        hotelPO.setPhone(phone);
        hotelPO.setFax(fax);
        hotelPO.setRating(new BigDecimal(rating));
        hotelPO.setProviderName("expedia");
        return hotelPO;
    }
}
