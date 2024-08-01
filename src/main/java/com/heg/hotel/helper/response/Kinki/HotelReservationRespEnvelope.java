package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 11:24
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class HotelReservationRespEnvelope {
    @Element(name = "Body",required = false)
    private ReservationRespBody body;

    @Data
    public static class ReservationRespBody{
        @Element(name = "HotelResRS",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private ReservationResp reservationResp;
    }

    @Data
    public static class ReservationResp{
        @Element(name = "Success")
        private String success;
        @Element(name = "Errors",required = false)
        private ErrorInfo errorInfo;
        @Element(name = "HotelReservations")
        private HotelReservationInfo hotelReservationInfo;
    }

    @Data
    public static class HotelReservationInfo{
        @ElementList(entry = "HotelReservation",required = false,inline=true,type = HotelReservation.class)
        private List<HotelReservation> hotelReservations;
    }
}
