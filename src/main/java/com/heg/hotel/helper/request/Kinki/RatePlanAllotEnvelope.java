package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/26 14:18
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class RatePlanAllotEnvelope{
    @Element(name = "soap:Body",required = false)
    private RatePlanAllotBody body;

    @Data
    public static class RatePlanAllotBody {
        @Element(name = "RatePlanAllotRQ",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private RatePlanAllotReq ratePlanAllotReq;
    }

    @Data
    public static class RatePlanAllotReq{
        @Element(name = "POS")
        private PosInfo posInfo;

        @Element(name = "AllotRequestSegments")
        private AllotRequestSegmentInfo allotRequestSegmentInfo;
    }

    @Data
    public static class AllotRequestSegmentInfo{
        @ElementList(entry = "AllotRequestSegment",type = AllotRequestSegment.class, inline = true, required = false)
        private List<AllotRequestSegment> allotRequestSegments;
    }

    @Data
    public static class AllotRequestSegment{
        @Attribute(name = "Number")
        private String number;

        @Element(name = "SearchDateRange")
        private SearchDateRange searchDateRange;

        @Element(name = "HotelRef")
        private HotelRef hotelRef;
    }

    @Data
    public static class SearchDateRange{
        @Attribute(name = "Start")
        private String start;
        @Attribute(name = "End")
        private String end;
    }

    @Data
    public static class HotelRef{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;

        @Attribute(name = "HotelCode")
        private String hotelCode;
    }
}


