package com.heg.hotel.helper.response.tmx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 10:35
 */
@Data
public class HotelStaticListResult {
    @JSONField(name = "ResponseHeader")
    private ResponseHeader responseHeader;

    private List<HotelStaticInfo> Hotels;

    @JSONField(name = "Pagination")
    private Pagination pagination;
}
