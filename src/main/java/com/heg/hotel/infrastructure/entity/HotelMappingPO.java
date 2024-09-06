package com.heg.hotel.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 16:42
 */
@Data
@TableName("t_hotel_mapping")
public class HotelMappingPO {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String hotelCode;

    private String supplierHotelCode;

    private String providerName;
}
