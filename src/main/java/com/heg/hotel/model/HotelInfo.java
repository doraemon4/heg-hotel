package com.heg.hotel.model;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/17 15:51
 */
@Data
public class HotelInfo {
    private Integer id;
    private String hotelCode;  //酒店编码
    private String hotelName;  //酒店名称
    private String brandCode;  //品牌编码
    private String brandName;  //品牌名称
    private String openDate;   //开业时间
    private String channel;    //渠道来源
    private Integer roomQuantity;//房间数量
    private String bookable;   //是否可定，T可定，F不可订
    private HotelPolicy hotelPolicy;//酒店政策
    private Address address;   //地址信息
    private float rating;      //等级评分
    private String description;  //描述信息
    private String contactPhoneNumber;//联系方式
    private String contactFax;//传真
    private List<PictureInfo> images; //酒店图片信息
    private List<HotelFacility> facilities;//酒店设施
    private List<TransportationInfo> transportationInfos;//交通信息

    @Data
    public static class HotelPolicy{
        private TimeLimitInfo arrivalTimeLimitInfo; //入住时间信息
        private TimeLimitInfo departureTimeLimitInfo; //离店时间信息
        private String ifPet;//是否允许携带宠物 T:可以，F：不可以
        private String ifChild;//是否允许未成年 T:可以，F：不可以
        private String ifLimitCheckInOut;//是否限制入离时间  T:限制，F：不限制
    }

    @Data
    public static class TimeLimitInfo{
        private String earliestTime;  //最早时间
        private String latestTime;    //最晚时间
    }

    @Data
    public static class Address{
        private String countryCode; //国家编码
        private String countryName;//国家名称
        private String provinceCode; //省份编码
        private String provinceName; //省份名称
        private String cityCode; //城市编码
        private String cityName;//城市名称
        private String areaCode; //区域编码
        private String areaName;//区域名称
        private String postalCode;//邮政编码
        private GeoInfo geoInfo;   //地理位置信息
        private String addressDetail;//详细地址
    }

    @Data
    public static class GeoInfo{
        private double latitude;  //纬度
        private double longitude; //经度
    }

    @Data
    public static class PictureInfo{
        private String type;  //图片类型
        private Integer category; //分类
        private String url; //图片地址
    }

    @Data
    public static class TransportationInfo{
        private String name;     //地点名称
        private String type;     //地点类型
        private String distance;  //距离
        private String directions;//交通描述信息
        private String transportationType;//交通信息类型
        private String timeTaken;//花费时间
    }

    @Data
    public static class HotelFacility{
        private String name;//设施名称
        private String type;//设施编码
    }
}
