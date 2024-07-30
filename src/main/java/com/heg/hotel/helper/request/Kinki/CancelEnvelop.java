package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 18:22
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class CancelEnvelop {
    @Element(name = "soap:Body",required = false)
    private CancelReservationBody body;

    @Data
    public static class CancelReservationBody{
        @Element(name = "CancelRQ",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private CancelReservationReq cancelReservationReq;
    }

    @Data
    public static class CancelReservationReq{
        @Element(name = "POS")
        private PosInfo posInfo;

        @Element(name = "UniqueID")
        private UniqueID uniqueID;
    }

    /**
     * 预定订单号
     */
    @Data
    public static class UniqueID{
        @Attribute(name= "Type",required = false)
        private String type = "10";
        @Attribute(name= "ID",required = false)
        private String id;
    }
}
