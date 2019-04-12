package com.discern.car.dto;

import com.discern.car.entity.Car;
import com.discern.car.entity.CarBrand;

import java.util.List;

/**
 * Created by Keben on 2018-06-06.
 */
public class BrandDto {
    private Integer id;
    private String name;
    private List<CarBrand> sonBrands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarBrand> getSonBrands() {
        return sonBrands;
    }

    public void setSonBrands(List<CarBrand> sonBrands) {
        this.sonBrands = sonBrands;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
