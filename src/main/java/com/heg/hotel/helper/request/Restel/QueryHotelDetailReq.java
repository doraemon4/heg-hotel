package com.heg.hotel.helper.request.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @Description: 查询酒店详情-query hotel's detail information
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 18:42
 */
@Data
@XStreamAlias(value = "peticion")
public class QueryHotelDetailReq extends BaseReq{
    @XStreamAlias("parametros")
    private QueryHotelDetailParam queryHotelDetailParam;

    @Data
    public static class QueryHotelDetailParam{
        @XStreamAlias("codigo")
        private String hotelCode;

        @XStreamAlias("idioma")
        private String language;
    }

}
