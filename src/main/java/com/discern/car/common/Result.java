package com.discern.car.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public class Result<T> implements Serializable {
    private int errCode;
    private String errMsg;
    private T data;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
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
        this.errCode = code.getErrorCode();
        this.errMsg = code.getErrorMessage();
    }

    public Result(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Result(int errCode, String errMsg, T data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public Result(SHErrorCode code, T data) {
        this.errCode = code.getErrorCode();
        this.errMsg = code.getErrorMessage();
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
        return errCode == 0;
    }
}
