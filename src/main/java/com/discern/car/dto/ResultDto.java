package com.discern.car.dto;

/**
 * Created by Keben on 2018-05-04.
 */
public class ResultDto {
    private String stateInfo;
    private Object entity;

    public ResultDto(String stateInfo, Object entity) {
        this.stateInfo = stateInfo;
        this.entity = entity;
    }
}
