package com.heg.hotel.core;


import com.heg.hotel.exception.BaseException;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 14:34
 */
public class Response {
    private int code;
    private String message;
    private Object data;

    private Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private static Response of(Status status, Object data) {
        return new Response(status.getCode(), status.getMessage(), data);
    }

    private static Response of(int code, String message, Object data) {
        return new Response(code, message, data);
    }

    public static Response ok(String message) {
        return of(Status.OK.getCode(), message, null);
    }

    public static Response ok(Object data) {
        return of(Status.OK.getCode(), Status.OK.getMessage(), data);
    }

    public static Response ok() {
        return of(Status.OK.getCode(), Status.OK.getMessage(), null);
    }

    public static Response ok(Status status) {
        return of(status, null);
    }

    public static Response ok(Status status, Object data) {
        return of(status, data);
    }

    public static Response ok(Status status, String data) {
        return of(status, data);
    }

    public static Response error() {
        return of(Status.ERROR, null);
    }

    public static Response error(String message) {
        return of(Status.ERROR.getCode(), message, null);
    }

    public static Response logicalError(){
        return of(Status.LOGICAL_ERROR, null);
    }

    public static Response logicalError(String message) {
        return of(Status.LOGICAL_ERROR.getCode(), message, null);
    }

    public static Response ofStatus(Status status) {
        return of(status, null);
    }

    public static <T extends BaseException> Response ofException(T t) {
        return of(t.getCode(), t.getMessage(), null);
    }
}
