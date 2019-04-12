package com.discern.car.entity;

public class Salesman {
    private Integer id;

    private String tel;

    private String name;

    /**
    * 对应是哪个商店的营业员
    */
    private Integer shopId;

    /**
    * 性别
    */
    private String sex;

    /**
    * 电子邮箱
    */
    private String email;

    /**
    * 个人照片
    */
    private String personalPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalPic() {
        return personalPic;
    }

    public void setPersonalPic(String personalPic) {
        this.personalPic = personalPic;
    }
}