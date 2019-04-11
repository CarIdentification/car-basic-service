package com.discern.car.dto;

import java.util.List;

public class SaleShopDto {
  private float latitute,longitude;
  private String locationDetail,shopName,brand,type,tel,shopPic;

  private Integer brandId,id;

  private List<SalesmanDto> salesMan;

  public float getLatitute() {
    return latitute;
  }

  public void setLatitute(float latitute) {
    this.latitute = latitute;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public String getLocationDetail() {
    return locationDetail;
  }

  public void setLocationDetail(String locationDetail) {
    this.locationDetail = locationDetail;
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

  public String getShopPic() {
    return shopPic;
  }

  public void setShopPic(String shopPic) {
    this.shopPic = shopPic;
  }

  public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<SalesmanDto> getSalesMan() {
    return salesMan;
  }

  public void setSalesMan(List<SalesmanDto> salesMan) {
    this.salesMan = salesMan;
  }
}
