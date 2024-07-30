package com.heg.hotel.helper.response.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @Description: 查询省份信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 18:36
 */
@Data
@XStreamAlias(value = "respuesta")
public class QueryProvinceResp extends BaseResp{
    @XStreamAlias("parametros")
    private ProvinceResp provinceResp;

    @Data
    public static class ProvinceResp{
        @XStreamAlias("provincias")
        private List<ProvinceInfo> provinceInfos;
        private String id;
    }

    @Data
    @XStreamAlias("provincia")
    public static class ProvinceInfo{
        @XStreamAlias("codigo_pais")
        private String parentCode;
        @XStreamAlias("codigo_provincia")
        private String provinceCode;
        @XStreamAlias("nombre_provincia")
        private String description;
    }
}
