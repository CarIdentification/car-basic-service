package com.discern.car.dto;

/**
 * Created by Keben on 2018-05-04.
 */
public class ResultDto {
    public static final ResultDto NEED_LOGIN = new ResultDto("auth_fail","未登录或登陆失效,请重新登录");
    public static final ResultDto ERR_PARAM = new ResultDto("err_param","参数错误");
    public static final ResultDto OK = new ResultDto("ok","操作成功");
    public static final ResultDto FAIL = new ResultDto("fail","操作失败");

    private String stateInfo;
    private Object entity;

    public ResultDto(String stateInfo, Object entity) {
        this.stateInfo = stateInfo;
        this.entity = entity;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
