package com.discern.car.entity;

import java.util.Date;

public class SearchHistoryPic {
    private Integer id;

    private String pic1;

    /**
    * 查询的时间
    */
    private Date createTime;

    /**
    * 用户查询id
    */
    private Integer userId;

    /**
    * 第二张识别照片的url
    */
    private String pic2;

    /**
    * 第三张识别照片的url
    */
    private String pic3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }
}