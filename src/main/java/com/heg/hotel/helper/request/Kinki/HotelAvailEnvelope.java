package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description: 查询每日房价
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 19:20
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class HotelAvailEnvelope {
    @Element(name = "soap:Body")
    private HotelAvailBody body;

    @Data
    public static class HotelAvailBody{
        @Element(name = "HotelAvailRQ")
        @Namespace(reference = "http://gv.knt.co.jp/")
        private HotelAvailReq hotelAvailReq;
    }

    @Data
    public static class HotelAvailReq{
        @Element(name = "POS")
        private PosInfo posInfo;

        @Element(name = "AvailRequestSegments")
        private AvailRequestSegmentInfo availRequestSegmentInfo;
    }

    @Data
    public static class AvailRequestSegmentInfo{
        @ElementList(entry = "AvailRequestSegment", inline = true, required = false,type = RoomStayCondition.class)
        private List<RoomStayCondition> availRequestSegments;
    }
}
