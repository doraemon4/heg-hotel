package com.heg.hotel.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heg.hotel.infrastructure.entity.HotelPO;

import java.util.List;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/5 9:05
 */
public interface HotelMapper extends BaseMapper<HotelPO> {
    List<HotelPO> selectByCoordinate(HotelPO hotelPO);
}
