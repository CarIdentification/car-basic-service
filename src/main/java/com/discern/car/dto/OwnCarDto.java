package com.discern.car.dto;

/**
 * @author caijiatao
 * @date 2019-04-10 00:06
 */
public class OwnCarDto {
    private Integer id;

    /**
     * 汽车封面图
     */
    private String coverPic;

    /**
     * 汽车名字
     */
    private String carName;

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
}
