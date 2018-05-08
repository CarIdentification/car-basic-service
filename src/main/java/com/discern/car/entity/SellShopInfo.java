package com.discern.car.entity;

public class SellShopInfo {
    private Integer id;

    /**
    * 经度
    */
    private Integer latitute;

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
    private Integer longitute;

    /**
    * 车店的图片
    */
    private String shopPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLatitute() {
        return latitute;
    }

    public void setLatitute(Integer latitute) {
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

    public Integer getLongitute() {
        return longitute;
    }

    public void setLongitute(Integer longitute) {
        this.longitute = longitute;
    }

    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic;
    }
}