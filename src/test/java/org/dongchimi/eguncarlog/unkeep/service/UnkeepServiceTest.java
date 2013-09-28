package org.dongchimi.eguncarlog.unkeep.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.dongchimi.eguncarlog.car.service.EgunCarService;
import org.dongchimi.eguncarlog.unkeep.entity.GasUnkeep;
import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;
import org.dongchimi.eguncarlog.utility.DateU;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UnkeepServiceTest {
	
	@Autowired
	private EgunCarService carService;
	
	@Autowired
	private UnkeepService unkeepService;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void registerUnkeepItem() {
		
		// 瞒 积己
		String alias = "钮俊固";
		String userEmail = "dongchimi@gmail.com";
		String modelName = "QM5";
		EgunCar myCar = new EgunCar();
		myCar.setAlias(alias);
		myCar.setUserEmailAddress(userEmail);
		myCar.setModelName(modelName);
		carService.createCar(myCar);
		
		// 亲格 积己
		UnkeepItem unkeepItem = new UnkeepItem();
		unkeepItem.setCarObjectId(myCar.getObjectId());
		unkeepItem.setItemName("林蜡");
		unkeepItem.setUnkeepPrice("10000");
		unkeepItem.setUseDate(DateU.getCurrentDateString());
		
		GasUnkeep gasUnkeep = new GasUnkeep();
		gasUnkeep.setPriceOfLiter("1753");
		unkeepItem.setGas(gasUnkeep);
		unkeepService.createUnkeepItem(unkeepItem);
		
		List<UnkeepItem> findUnkeepItemByCarId = unkeepService.findUnkeepItemByCarId(myCar.getObjectId());
		
		System.out.println(findUnkeepItemByCarId);
	}
}
