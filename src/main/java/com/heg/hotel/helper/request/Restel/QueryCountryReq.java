package com.heg.hotel.helper.request.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/25 15:27
 */
@Data
@XStreamAlias(value = "peticion")
public class QueryCountryReq extends BaseReq{
    @XStreamAlias("idioma")
    private String language;
}
