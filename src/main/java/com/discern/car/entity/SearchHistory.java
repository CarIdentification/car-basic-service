package com.discern.car.entity;

import java.util.Date;

public class SearchHistory {
    private Integer id;

    /**
    * 搜索用户id
    */
    private Integer userId;

    /**
    * 搜索的文字内容
    */
    private String content;

    /**
    * 搜索的时间
    */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}