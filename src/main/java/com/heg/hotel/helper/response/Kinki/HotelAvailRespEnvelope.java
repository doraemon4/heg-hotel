package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 19:51
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class HotelAvailRespEnvelope {
    @Element(name = "Body",required = false)
    private HotelAvailRespBody body;

    @Data
    public static class HotelAvailRespBody{
        @Element(name = "HotelAvailRS",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private HotelAvailResp hotelAvailResp;
    }

    @Data
    public static class HotelAvailResp{
        @Element(name = "Success")
        private String success;

        @Element(name = "Errors",required = false)
        private ErrorInfo errorInfo;

        @Element(name = "RoomStays")
        private RoomStaysInfo roomStaysInfo;
    }

    @Data
    public static class RoomStaysInfo{
        @ElementList(entry = "RoomStay",required = false,inline = true,type = RoomStayInfo.class)
        private List<RoomStayInfo> roomStayInfos;
    }

    @Data
    public static class RoomStayInfo{
        @Element(name = "RatePlans")
        private RatePlansInfo ratePlansInfo;
        @Element(name = "RoomRates")
        private RoomRatesInfo ratesInfo;
        @Element(name = "CancelRates")
        private CancelRateInfo cancelRateInfo;
    }

    @Data
    public static class RatePlansInfo{
        @Element(name = "RatePlan")
        private RatePlan ratePlan;
    }

    @Data
    public static class RatePlan{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;

        @Attribute(name = "RatePlanName")
        private String ratePlanName;
    }

    @Data
    public static class RoomRatesInfo{
        @Element(name = "RoomRate")
        private RoomRate roomRate;
    }

    @Data
    public static class RoomRate{
        @Element(name = "Rates")
        private RatesInfo ratesInfo;
    }

    @Data
    public static class RatesInfo{
        @ElementList(entry = "Rate",required = false,inline = true,type = RateInfo.class)
        private List<RateInfo> rateInfos;
    }
}
