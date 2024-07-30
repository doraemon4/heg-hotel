package com.heg.hotel.helper.response.Kinki;

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
public class RatePlanAllotRespEnvelope {
    @Element(name = "Body",required = false)
    private RatePlanAllotBody body;

    @Data
    public static class RatePlanAllotBody {
        @Element(name = "RatePlanAllotRS",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private RatePlanAllotResp ratePlanAllotResp;
    }

    @Data
    public static class RatePlanAllotResp{
        @Element(name = "Errors",required = false)
        private ErrorInfo errorInfo;

        @Element(name = "Success",required = false)
        private String success;

        @Element(name = "AllotReposeSegments",required = false)
        private AllotReposeSegmentInfo allotReposeSegmentInfo;
    }

    @Data
    public static class ErrorInfo{
        @ElementList(entry = "Error",type = ErrorMessage.class, inline = true, required = false)
        private List<ErrorMessage> errorMessages;
    }

    /**接口请求错误提示异常信息*/
    @Data
    public static class ErrorMessage{
        @Attribute(name = "Message")
        private String message;

        @Attribute(name = "Code")
        private String code;
    }

    @Data
    public static class AllotReposeSegmentInfo{
        @ElementList(entry = "AllotReposeSegment",type = AllotReposeSegment.class, inline = true, required = false)
        private List<AllotReposeSegment> allotReposeSegments;
    }

    @Data
    public static class AllotReposeSegment{
        @Attribute(name = "Number")
        private String number;

        @Element(name = "RatePlan")
        private RatePlanResult ratePlanResult;
    }

    @Data
    public static class RatePlanResult{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;

        @Attribute(name = "HotelCode")
        private String hotelCode;

        @Element(name = "SearchDateRange")
        private SearchDateRange searchDateRange;

        @Element(name = "AllotmentRange")
        private AllotmentRange allotmentRange;
    }

    @Data
    public static class SearchDateRange{
        @Attribute(name = "Start")
        private String start;
        @Attribute(name = "End")
        private String end;
    }

    @Data
    public static class AllotmentRange{
        @Element(name = "Allotment")
        private Allotment allotment;
    }

    @Data
    public static class Allotment{
        @Element(name = "Text")
        private String text;
    }
}
