package com.heg.hotel.helper.response.Restel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 17:21
 */
@Data
public class BaseResp implements Serializable {
    /**接口类型*/
    @XStreamAlias("tipo")
    private String type;
    /**接口名称*/
    @XStreamAlias("nombre")
    private String name;
    /**组织机构*/
    @XStreamAlias("agencia")
    private String organization;
}
