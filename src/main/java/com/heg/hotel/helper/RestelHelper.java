package com.heg.hotel.helper;

import com.heg.hotel.helper.request.Restel.QueryCountryReq;
import com.heg.hotel.helper.response.Restel.QueryCountryResp;
import com.heg.hotel.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/23 11:38
 */
@Slf4j
@Component
public class RestelHelper {
    public QueryCountryResp queryCountry(QueryCountryReq req){
        String text = XmlUtil.objectToXml(req,"utf-8");

        return null;
    }
}
