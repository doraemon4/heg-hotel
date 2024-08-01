package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * @Description: 取消费率信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/8/1 9:47
 */
@Data
public class CancelRateInfo {
    @Element(name = "CancelRate")
    private CancelRate cancelRate;

    @Data
    public static class CancelRate{
        @Attribute(name = "StayDateFrom")
        private String stayDateFrom;

        @Attribute(name = "StayDateTo")
        private String stayDateTo;

        @ElementList(entry = "Policy", required = false, inline = true, type = CancelPolicy.class)
        private List<CancelPolicy> cancelPolicies;
    }

    @Data
    public static class CancelPolicy{
        @Attribute(name = "Days")
        private String days;
        @Attribute(name = "Rate")
        private String rate;
    }
}
