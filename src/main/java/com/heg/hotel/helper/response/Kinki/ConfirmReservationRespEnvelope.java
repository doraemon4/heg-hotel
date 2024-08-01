package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 10:59
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class ConfirmReservationRespEnvelope {
    @Element(name = "Body",required = false)
    private ConfirmResRespBody body;

    @Data
    public static class ConfirmResRespBody{
        @Element(name = "HotelResConfirmRS",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private ConfirmResResp confirmResResp;
    }

    @Data
    public static class ConfirmResResp{
        @Element(name = "Success")
        private String success;

        @Element(name = "Errors",required = false)
        private ErrorInfo errorInfo;

        @Element(name = "HotelReservationConfirms")
        private ReservationConfirmInfo reservationConfirmInfo;
    }

    @Data
    public static class ReservationConfirmInfo{
        @ElementList(entry = "HotelReservationConfirm",required = false, inline = true,type = HotelReservation.class)
        private List<HotelReservation> hotelReservations;
    }
}
