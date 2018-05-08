package com.discern.car.entity;

public class ServiceShopInfo {
    private Integer id;

    /**
    * 服务点名称
    */
    private String serviceShopName;

    /**
    * 经度
    */
    private Double latitute;

    private Double logitute;

    /**
    * 地点详情
    */
    private String locationDetail;

    /**
    * 联系方式
    */
    private String contract;

    /**
    * 服务点的图片
    */
    private String serviceShopPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceShopName() {
        return serviceShopName;
    }

    public void setServiceShopName(String serviceShopName) {
        this.serviceShopName = serviceShopName;
    }

    public Double getLatitute() {
        return latitute;
    }

    public void setLatitute(Double latitute) {
        this.latitute = latitute;
    }

    public Double getLogitute() {
        return logitute;
    }

    public void setLogitute(Double logitute) {
        this.logitute = logitute;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getServiceShopPic() {
        return serviceShopPic;
    }

    public void setServiceShopPic(String serviceShopPic) {
        this.serviceShopPic = serviceShopPic;
    }
}