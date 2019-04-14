package com.discern.car;

import com.discern.car.dao.CarMapper;
import com.discern.car.dao.CarPicMapper;
import com.discern.car.dto.CarDto;
import com.discern.car.entity.Car;
import com.discern.car.entity.CarPic;
import com.discern.car.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.discern.car.dao.CarMapper;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarApplicationTests {


	@Resource
	CarMapper carMapper;
	@Resource
	CarPicMapper carPicMapper;
	@Test
	public void contextLoads() {

		List<Car> list = carMapper.selectList();
		int length = 0;
		for(Car car : list){
			CarPic carPic = new CarPic();
			carPic.setCarId(car.getId());
			carPic.setImgSrc(car.getCoverPic());
			carPicMapper.insert(carPic);
		}
	}

}
