package com.heg.hotel.helper.response.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @Description: 查询城市信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 17:59
 */
@Data
@XStreamAlias(value = "respuesta")
public class QueryCityResp extends BaseResp{
    @XStreamAlias("parametros")
    private CityResp cityResp;

    @Data
    public static class CityResp{
        @XStreamAlias("poblaciones")
        private List<CityInfo> cityInfos;
        private String id;
    }

    @Data
    @XStreamAlias("poblacion")
    public static class CityInfo{
        @XStreamAlias("deppob")
        private String provinceCode;
        @XStreamAlias("codpob")
        private String cityCode;
        @XStreamAlias("poblidinom1")
        private String description1;
        @XStreamAlias("poblidinom2")
        private String description2;
        @XStreamAlias("poblidinom3")
        private String description3;
        @XStreamAlias("poblidinom4")
        private String description4;
        @XStreamAlias("poblidinom5")
        private String description5;
        @XStreamAlias("poblidinom6")
        private String description6;
    }
}
