package com.discern.car.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(SHErrorCode code) {
        this.code = code.getErrorCode();
        this.msg = code.getErrorMessage();
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(SHErrorCode code, T data) {
        this.code = code.getErrorCode();
        this.msg = code.getErrorMessage();
        this.data = data;
    }

    public static <E> Result<E> newSuccess() {
        return new Result<>(SHErrorCode.SUCCESS);
    }

    public static <E> Result<E> newSuccess(E data) {
        return new Result<>(SHErrorCode.SUCCESS, data);
    }

    public static <E> Result<E> newError(SHErrorCode code) {
        return new Result<>(code);
    }

    public static <E> Result<E> newError(int errCode, String errMsg) {
        return new Result<>(errCode, errMsg);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == 0;
    }
}
