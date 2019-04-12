package com.discern.car.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String email;

    /**
    * 微信用户openid
    */
    private String openid;

    /**
    * 用户性别
    */
    private String sex;

    /**
    * 头像图片url
    */
    private String headimg;

    /**
    * 用户手机号
    */
    private String phone;

    /**
    * 用户注册小程序的时间
    */
    private Date createTime;

    /**
    * 用户搜索次数
    */
    private Integer searchCount;

    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", openid='" + openid + '\'' +
                ", sex='" + sex + '\'' +
                ", headimg='" + headimg + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", searchCount=" + searchCount +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}