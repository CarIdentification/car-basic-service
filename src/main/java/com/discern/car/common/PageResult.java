package com.discern.car.common;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 6941956017537570294L;
    private Integer count;
    private Integer code;
    private List<T> data;
    private String msg;

    public PageResult() {
    }

    public static <T> PageResult<T> newSuccess() {
        PageResult pageResult = new PageResult();
        pageResult.setCode(SHErrorCode.SUCCESS.getErrorCode());
        pageResult.setMsg(SHErrorCode.SUCCESS.getErrorMessage());
        return pageResult;
    }

    public static <T> PageResult<T> newSuccess(Page page, List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCount(page.getCount());
        pageResult.setCode(SHErrorCode.SUCCESS.getErrorCode());
        pageResult.setMsg(SHErrorCode.SUCCESS.getErrorMessage());
        pageResult.setData(data);
        return pageResult;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
