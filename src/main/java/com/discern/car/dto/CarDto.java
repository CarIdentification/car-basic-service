package com.discern.car.dto;

import com.discern.car.entity.CarPic;

import java.util.List;

/**
 * Created by Keben on 2018-06-10.
 */
public class CarDto {
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
    private Integer carBrand;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 汽车价格
     */
    private Float price;

    /**
     * 汽车级别
     */
    private Integer level;

    /**
     * 汽车国别
     */
    private Integer country;

    /**
     * 结构
     */
    private Integer structure;

    /**
     * 排量
     */
    private Float displacement;

    /**
     * 座位数
     */
    private Integer seat;

    /**
     * 进气形式
     */
    private Integer airIntake;

    /**
     * 能源
     */
    private Integer energy;

    /**
     * 驱动方式
     */
    private Integer drivingMethod;

    /**
     * 变速箱
     */
    private Integer transmission;

    /**
     * 生产方式
     */
    private Integer productionMethods;

    /**
     * 汽车详细信息
     */
    private String detail;

    private List<CarPic> carPic;

    public List<CarPic> getCarPic() {
        return carPic;
    }

    public void setCarPic(List<CarPic> carPic) {
        this.carPic = carPic;
    }

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

    public Integer getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(Integer carBrand) {
        this.carBrand = carBrand;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getStructure() {
        return structure;
    }

    public void setStructure(Integer structure) {
        this.structure = structure;
    }

    public Float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Float displacement) {
        this.displacement = displacement;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getAirIntake() {
        return airIntake;
    }

    public void setAirIntake(Integer airIntake) {
        this.airIntake = airIntake;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getDrivingMethod() {
        return drivingMethod;
    }

    public void setDrivingMethod(Integer drivingMethod) {
        this.drivingMethod = drivingMethod;
    }

    public Integer getTransmission() {
        return transmission;
    }

    public void setTransmission(Integer transmission) {
        this.transmission = transmission;
    }

    public Integer getProductionMethods() {
        return productionMethods;
    }

    public void setProductionMethods(Integer productionMethods) {
        this.productionMethods = productionMethods;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
