package org.dongchimi.eguncarlog.car.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class CarServiceTest {
	
	@Autowired
	private EgunCarService carService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void registerCar() {
		
		String alias = "Å¥¿¡¹Ì";
		String userEmail = "dongchimi@gmail.com";
		String modelName = "QM5";
		EgunCar myCar = new EgunCar();
		myCar.setAlias(alias);
		myCar.setUserEmailAddress(userEmail);
		myCar.setModelName(modelName);
		carService.createCar(myCar);
		
		
		List<EgunCar> cars = carService.findCarsByUserEmail(userEmail);
		
		System.out.println();
	}
}
