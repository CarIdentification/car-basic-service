package com.discern.car.entity;

import java.math.BigDecimal;

public class SellShopInfo {
    private Integer id;

    /**
    * 经度
    */
    private BigDecimal latitute;

    /**
    * 地点详细名字
    */
    private String locationDetail;

    /**
    * 品牌id
    */
    private Integer brandId;

    /**
    * 纬度
    */
    private BigDecimal longitute;

    /**
    * 车店的图片
    */
    private String shopPic;

    /**
    * 车店的名字
    */
    private String shopName;

    private String brand;

    private String type;

    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLatitute() {
        return latitute;
    }

    public void setLatitute(BigDecimal latitute) {
        this.latitute = latitute;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getLongitute() {
        return longitute;
    }

    public void setLongitute(BigDecimal longitute) {
        this.longitute = longitute;
    }

    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}