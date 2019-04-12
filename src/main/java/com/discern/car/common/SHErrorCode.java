package com.discern.car.common;

public enum SHErrorCode {

    // 成功
    SUCCESS(0, "成功"),
    // 错误
    PARAMS_ERROR(-1, "参数错误"),
    SERVER_BUSY(-2, "系统繁忙"),
    SYSTEM_ERROR(-3, "系统错误"),
    OPERATE_DB_FAIL(-4, "数据库操作失败"),
    UNKNOWN(-5, "未知错误"),
    JSON_FAIL(-6, "JSON序列化失败"),
    NO_DATA(-7, "数据不存在");
    private int errorCode;
    private String errorMessage;

    SHErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static SHErrorCode getByCode(int code) {
        for (SHErrorCode shErrorCode : values()) {
            if (shErrorCode.getErrorCode() == code) {
                return shErrorCode;
            }
        }
        return null;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
