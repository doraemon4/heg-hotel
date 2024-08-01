package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * @Description: 每日费率信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/8/1 10:14
 */
@Data
public class RateInfo {
    @Attribute(name = "Start", required = false)
    private String start;
    @Attribute(name = "End",required = false)
    private String end;

    @Element(name = "Base")
    private BaseRate baseRate;

    @Data
    public static class BaseRate{
        @Attribute(name = "AmountAfterTax")
        private String amountAfterTax;

        @Attribute(name = "CurrencyCode")
        private String currencyCode;
    }
}
