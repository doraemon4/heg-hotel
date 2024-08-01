package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 16:57
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class HotelRatePlanRespEnvelope {
    @Element(name = "Body",required = false)
    private HotelRatePlanRespBody body;

    @Data
    public static class HotelRatePlanRespBody{
        @Element(name = "HotelRatePlanRS",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private HotelRatePlanResp hotelRatePlanResp;
    }

    @Data
    public static class HotelRatePlanResp{
        @Element(name = "Success")
        private String success;
        @Element(name = "Errors")
        private ErrorInfo errorInfo;
        @Element(name = "RatePlans")
        private RatePlansInfo ratePlansInfo;
    }

    @Data
    public static class RatePlansInfo{
        @ElementList(entry = "RatePlan",required = false, inline = true, type = RatePlan.class)
        private List<RatePlan> ratePlans;
    }

    @Data
    public static class RatePlan{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;
        @Attribute(name = "HotelCode")
        private String hotelCode;
        @Attribute(name = "RatePlanName")
        private String ratePlanName;
        @Element(name = "Rates")
        private RatesInfo ratesInfo;
    }

    @Data
    public static class RatesInfo{
        @ElementList(entry = "Rate",required = false, inline = true, type = RateInfo.class)
        private List<RateInfo> rateInfos;
    }

    @Data
    public static class RateInfo{
        @Attribute(name = "Start")
        private String start;
        @Attribute(name = "End")
        private String end;
        @Attribute(name = "InvCode")
        private String invCode;   //房型编码
        @Element(name = "BaseByGuestAmts")
        private BaseByGuestAmounts baseByGuestAmounts;
    }

    @Data
    public static class BaseByGuestAmounts{
        @Element(name = "BaseByGuestAmt")
        private BaseByGuestAmount baseByGuestAmount;
    }

    @Data
    public static class BaseByGuestAmount{
        @Attribute(name = "AmountAfterTax")
        private String amountAfterTax;
        @Attribute(name = "CurrencyCode")
        private String currencyCode;
    }
}
