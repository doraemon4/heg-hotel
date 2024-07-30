package com.heg.hotel.exception;

import com.heg.hotel.core.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 14:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private int code;
    private String message;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}