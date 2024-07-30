package com.heg.hotel.helper.response.Kinki;

import lombok.Data;

/**
 * @Description: 图片信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/23 18:58
 */
@Data
public class HotelPicture {
    private String cultureName;
    private String hotelID;
    private String localPath1;
    private String pictureCaption1;

    private String localPath2;
    private String pictureCaption2;

    private String localPath3;
    private String pictureCaption3;

    private String localPath4;
    private String pictureCaption4;

    private String updateTime;
}
