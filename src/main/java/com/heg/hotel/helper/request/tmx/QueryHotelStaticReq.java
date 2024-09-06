package com.heg.hotel.helper.request.tmx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 10:29
 */
@Data
public class QueryHotelStaticReq {
    private String CountryCode;

    @JSONField(name = "Pagination")
    private Pagination pagination;

    @JSONField(name = "RequestHeader")
    private RequestHeader requestHeader;
}
