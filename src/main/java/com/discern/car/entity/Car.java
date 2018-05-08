package com.discern.car.entity;

public class Car {
    private Integer id;

    /**
    * 汽车封面图
    */
    private String coverPic;

    /**
    * 汽车名字
    */
    private String carName;

    /**
    * 汽车品牌名字
    */
    private String carBrand;

    /**
    * 分类id
    */
    private Integer categoryId;

    /**
    * 汽车详细信息
    */
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}