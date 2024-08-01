package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 19:05
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class CancelRespEnvelope {
    @Element(name = "Body",required = false)
    private CancelRespBody body;

    @Data
    public static class CancelRespBody{
        @Element(name = "CancelRS",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private CancelResp cancelResp;
    }

    @Data
    public static class CancelResp{
        @Element(name = "Success")
        private String success;

        @Element(name = "Errors")
        private ErrorInfo errorInfo;

        @Element(name = "Warnings")
        private WarningInfo warningInfo;

        @ElementList(entry = "UniqueID",required = false, inline = true,type = UniqueID.class)
        private List<UniqueID> uniqueIDs;
    }

    @Data
    public static class UniqueID{
        @Attribute(name= "Type",required = false)
        private String type = "10";
        @Attribute(name= "ID",required = false)
        private String id;     //供应商订单号
        @Element(name = "Commissions")
        private CommissionInfo commissionInfo;   //佣金信息
    }

    @Data
    public static class CommissionInfo{
        @Element(name = "Commission")
        private Commission commission;
    }

    @Data
    public static class Commission{
        @Attribute(name = "PriceType")
        private String priceType;
        @Element(name = "CommissionPayableAmount")
        private CommissionPayableAmount commissionPayableAmount;  //佣金金额信息
    }

    @Data
    public static class CommissionPayableAmount{
        @Attribute(name = "Amount")
        private String amount;
        @Attribute(name = "CurrencyCode")
        private String CurrencyCode;
    }
}
