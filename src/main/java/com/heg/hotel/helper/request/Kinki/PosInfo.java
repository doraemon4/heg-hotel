package com.heg.hotel.helper.request.Kinki;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/26 15:26
 */
@Data
public class PosInfo {
    @Element(name = "Source")
    private SourceInfo sourceInfo;

    @Data
    public static class SourceInfo{
        @Element(name = "RequestorID")
        private RequestorID requestorID;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestorID{
        @Attribute(name = "Type")
        private String type;

        @Attribute(name = "ID")
        private String id = "5";

        @Attribute(name = "MessagePassword")
        private String password;
    }
}
