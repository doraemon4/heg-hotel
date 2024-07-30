package com.heg.hotel.helper.response.Kinki;

import lombok.Data;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/23 13:34
 */
@Data
public class HotelInfo {
    //language version
    private String cultureName;
    private String hotelID;
    private String hotelName;
    private String hotelType;
    private String areaCode;
    private String prefectureName;
    private String openDate;
    private String postalCode;
    private String address;
    private String telephone;
    private String faxNumber;
    private String description;
    //The way to the hotel by walk.
    private String accessInfo1;
    //The way to the hotel by public transpotations such as train and bus.
    private String accessInfo2;
    //The way to the hotel by car.
    private String accessInfo3;
    //The way to the hotel by other method.
    private String accessInfo4;
    private String descriptionParking;
    private String descriptionPickup;
    //纬度
    private String latitude;
    //经度
    private String longitude;
    private String attributes;
    private String updateTime;
}
