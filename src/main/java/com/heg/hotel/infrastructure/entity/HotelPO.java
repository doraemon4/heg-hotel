package com.heg.hotel.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/4 19:17
 */
@Data
@TableName("t_supplier_hotel")
public class HotelPO {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String hotelCode;
    private String hotelName;
    private String hotelAddress;
    private String cityCode;
    private String cityName;
    private String provinceCode;
    private String provinceName;
    private String countryCode;
    private String countryName;
    private String latitude;
    private String longitude;
    private String postalCode;
    private String phone;
    private String fax;
    private String remark;
    private Integer status;
    /**酒店评分*/
    private BigDecimal rating;
    /**酒店星级*/
    private Integer star;
    private Date createTime;
    private Date updateTime;
    /**渠道名称*/
    private String providerName;
}
