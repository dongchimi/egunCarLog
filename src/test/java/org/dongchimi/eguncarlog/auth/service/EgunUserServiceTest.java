package org.dongchimi.eguncarlog.auth.service;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class EgunUserServiceTest {
	
	@Autowired
	private EgunUserService egunUserService;
	
	@Before
	public void setUp() {
		//this.egunUserService = this.context.getBean("egunUserService", EgunUserService.class);
	}
	
	@Test
	public void registerEgunUser() {

		String userEmail =  "dongchimi@gmail.com";
		String name = "¿Ãµø±‘";
		String password = "1234";
		
		EgunUser user = new EgunUser(userEmail, name, password);
		egunUserService.createEgunUser(user);
//		user.setEmailAddress("aaaa");
		//Assert.assertEquals("Larry", user.getEmailAddress());
		
		EgunUser egunUser = egunUserService.getEgunUserByEmail("dklee@gmail.com");
	}
}

