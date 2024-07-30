package com.heg.hotel.helper.response.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/25 15:27
 */
@Data
@XStreamAlias(value = "respuesta")
public class QueryCountryResp extends BaseResp{
    @XStreamAlias("parametros")
    private CountryResp countryResp;

    @Data
    public static class CountryResp{
        @XStreamAlias("paises")
        private List<CountryInfo> countryInfos;

        private String id;
    }

    @Data
    @XStreamAlias("pais")
    public static class CountryInfo{
        @XStreamAlias("codigo_pais")
        private String countryCode;
        @XStreamAlias("nombre_pais")
        private String countryName;
    }
}
