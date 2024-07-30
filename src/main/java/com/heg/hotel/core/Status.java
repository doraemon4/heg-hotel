package com.heg.hotel.core;

import java.io.Serializable;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 14:41
 */
public enum Status implements IR, Serializable {

    /**
     * ok
     */
    OK(200, "Success"),

    /**
     * error
     */
    ERROR(500, "Failed"),

    LOGICAL_ERROR(422, "Parameter error"),
    /**
     * 401
     */
    UNAUTHORIZED(401, "Unauthorized"),

    /**
     * 用户名或密码错误
     */
    LOGIN_FAIL(401, "Login failed, wrong user name or password"),

    /**
     * 用户名或密码为空
     */
    USERNAME_OR_PASSWORD_EMPTY(401, "User name or password is empty"),

    /**
     * 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(401, "User name or password is error"),


    ALGORITHM_UNDEFINED(422, "Algorithm undefined")
    ;

    private int code;
    private String message;

    public String of(int code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value.getMessage();
            }
        }
        return null;
    }

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

