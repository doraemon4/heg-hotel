package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 10:30
 */
@Data
@Root(name = "Errors", strict = false)
public class ErrorInfo {
    @ElementList(entry = "Error",type = ErrorMessage.class, inline = true, required = false)
    private List<ErrorMessage> errorMessages;

    /**接口请求错误提示异常信息*/
    @Data
    public static class ErrorMessage{
        @Attribute(name = "Message")
        private String message;

        @Attribute(name = "Code")
        private String code;
    }
}
