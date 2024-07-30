package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

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
public class CancelRespEnvelop {

}
