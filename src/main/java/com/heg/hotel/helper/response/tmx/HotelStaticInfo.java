package com.heg.hotel.helper.response.tmx;

import lombok.Data;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 10:58
 */
@Data
public class HotelStaticInfo {
    private String HotelId;
    private String Name;
    private String Name_CN;
    private String StarRating;
    private String Address;
    private String Address_CN;
    private String CountryCode;
    private String CityCode;
    private String CityName;
    private String Latitude;
    private String Longitude;
    private String Phone;
}
