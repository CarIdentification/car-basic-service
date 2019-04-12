package com.discern.car.entity;

import java.util.Date;

public class Tag {
    private Integer tagId;

    private String brandName;

    /**
    * 创建tag的时间
    */
    private Date createTime;

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", brandName='" + brandName + '\'' +
                ", createTime=" + createTime +
                ", hot=" + hot +
                '}';
    }

    /**
    * 该tag的热度
    */
    private Integer hot;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}