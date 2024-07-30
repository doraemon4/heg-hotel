package com.heg.hotel.helper.request.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @Description: 查询省份信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 18:35
 */
@Data
@XStreamAlias(value = "peticion")
public class QueryProvinceReq extends BaseReq{
    @XStreamAlias("idioma")
    private String language;
}
