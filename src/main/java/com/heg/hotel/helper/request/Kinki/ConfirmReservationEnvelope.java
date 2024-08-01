package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 18:37
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class ConfirmReservationEnvelope {
    @Element(name = "soap:Body",required = false)
    private ConfirmReservationBody body;

    @Data
    public static class ConfirmReservationBody{
        @Element(name = "HotelResConfirmReq")
        @Namespace(reference = "http://gv.knt.co.jp/")
        private HotelResConfirmReq hotelResConfirmReq;
    }

    @Data
    public static class HotelResConfirmReq{
        @Element(name = "POS")
        private PosInfo posInfo;

        @Element(name = "ReserveConfirms")
        private ReserveConfirmInfo reserveConfirmInfo;
    }

    @Data
    public static class ReserveConfirmInfo{
        @Element(name = "ReserveConfirm")
        private ReserveConfirm reserveConfirm;
    }

    @Data
    public static class ReserveConfirm{
        @ElementList(name = "ReserveConfirmInfo", inline = true, required = false)
        private List<ReserveConfirmNo> reserveConfirmNos;
    }

    @Data
    public static class ReserveConfirmNo{
        @Attribute(name = "ResID")
        private String resNo;   //供应商订单号

        @Attribute(name = "ReserveNo")
        private String reserveNo;   //分销商订单号
    }
}
