package com.heg.hotel.helper.response.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @Description: 查询酒店列表
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 17:39
 */
@Data
@XStreamAlias(value = "respuesta")
public class QueryHotelListResp extends BaseResp{
    @XStreamAlias("parametros")
    private HotelListResp hotelListResp;

    @Data
    public static class HotelListResp{
        @XStreamAlias("hoteles")
        private List<HotelInfo> hotelInfos;
        private String id;
    }

    @Data
    @XStreamAlias("hotel")
    public static class HotelInfo{
        /**酒店省份编码*/
        @XStreamAlias("codesthot")
        private String provinceCode;
        /**城市编码*/
        @XStreamAlias("codpobhot")
        private String cityCode;

        @XStreamAlias("hot_codigo")
        private String hotelInnerCode;

        @XStreamAlias("hot_codcobol")
        private String hotelCode;

        @XStreamAlias("hot_afiliacion")
        private String hotelAffiliation;
    }
}
