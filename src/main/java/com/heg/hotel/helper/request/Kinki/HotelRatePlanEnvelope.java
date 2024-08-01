package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 16:04
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class HotelRatePlanEnvelope {
    @Element(name = "soap:Body")
    private HotelRatePlanBody body;

    @Data
    public static class HotelRatePlanBody{
        @Element(name = "HotelRatePlanRQ")
        @Namespace(reference = "http://gv.knt.co.jp/")
        private HotelRatePlanReq hotelRatePlanReq;
    }

    @Data
    public static class HotelRatePlanReq{
        @Element(name = "POS")
        private PosInfo posInfo;

        @Element(name = "RatePlans")
        private HotelRatePlanInfo hotelRatePlanInfo;
    }

    @Data
    public static class HotelRatePlanInfo{
        @ElementList(entry = "RatePlan", inline = true, required = false,type = RoomStayCondition.class)
        private List<RoomStayCondition> ratePlanConditions;
    }
}
