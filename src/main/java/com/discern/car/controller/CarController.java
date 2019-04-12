package com.discern.car.controller;

import com.discern.car.dto.CarDto;
import com.discern.car.dto.ResultDto;
import com.discern.car.entity.Car;
import com.discern.car.service.CarService;
import com.discern.car.util.BeanUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 12/04/2019
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/add")
    public ResultDto add(Car car) {
        carService.insert(car);
        return ResultDto.OK;
    }

    @RequestMapping("/delete")
    public ResultDto delete(Integer id) {
        carService.deleteByPrimaryKey(id);
        return ResultDto.OK;
    }

    @RequestMapping("/get")
    public ResultDto get(Integer id) {
        Car car = BeanUtil.copy(carService.selectByPrimaryKey(id), Car.class);
        return new ResultDto(ResultDto.OK.getStateInfo(), car);
    }

    @RequestMapping("/update")
    public ResultDto update(Car car) {
        carService.updateByPrimaryKeySelective(car);
        return ResultDto.OK;
    }

    @RequestMapping("/selectByBrandId")
    public ResultDto selectByBrandId(Integer id, Integer num) {
        List<CarDto> car = carService.selectByBrandId(id, num);
        return new ResultDto(ResultDto.OK.getStateInfo(), car);
    }
}
