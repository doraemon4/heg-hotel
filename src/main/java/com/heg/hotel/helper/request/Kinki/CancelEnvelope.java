package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description: 取消预定(支持批量取消)
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
public class CancelEnvelope {
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

        @ElementList(entry = "UniqueID",type = UniqueID.class,required = false,inline = true)
        private List<UniqueID> uniqueIDS;
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
