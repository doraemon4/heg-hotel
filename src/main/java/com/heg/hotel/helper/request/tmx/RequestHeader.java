package com.heg.hotel.helper.request.tmx;

import lombok.Data;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 10:24
 */
@Data
public class RequestHeader {
    private String AgentCode;
    private String Password;
    private String RequestTime;
    private String TransactionID;
    private String UserName;
}
