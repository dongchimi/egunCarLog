package org.dongchimi.eguncarlog.car.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.service.EgunUserService;
import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.dongchimi.eguncarlog.car.service.EgunCarService;
import org.dongchimi.eguncarlog.utility.EgunCarlogException;
import org.dongchimi.eguncarlog.utility.JSonResponse;
import org.dongchimi.eguncarlog.utility.RequestResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api/car")
public class CarResource {
    private static final Logger logger = LoggerFactory.getLogger( CarResource.class.getSimpleName() );
    
    @Autowired
    private EgunUserService egunUserService;
    
    @Autowired
    private EgunCarService egunCarService;
    
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
    public JSonResponse list(HttpServletRequest request) {
		EgunUser signinUser = (EgunUser)request.getSession().getAttribute("signinUser");
    	logger.info("emailAddress : " + signinUser.getEmailAddress());
    	List<EgunCar> foundCars = egunCarService.findCarsByUserEmail(signinUser.getEmailAddress());
		return RequestResponseBuilder.getSuccessResponse("cars", foundCars);
    }
	
    @RequestMapping(value="/new", method=RequestMethod.POST)
    @ResponseBody
    public JSonResponse newCar(@ModelAttribute EgunCar egunCar, HttpServletRequest request) {
    	EgunUser signinUser = (EgunUser)request.getSession().getAttribute("signinUser");
    	logger.info("signinUser : " + signinUser);
    	egunCar.setUserEmailAddress( signinUser.getEmailAddress() );
    	logger.info("egunCar : " + egunCar);
    	
    	long createCarId = egunCarService.createCar(egunCar);
    	egunCar.setObjectId(createCarId);
    	return RequestResponseBuilder.getSuccessResponse("car", egunCar);
    }
    
    @RequestMapping(value="/modify", method=RequestMethod.POST)
    @ResponseBody
    public JSonResponse modifyCar(@ModelAttribute EgunCar egunCar) {
    	egunCarService.modifyCar(egunCar);
    	return RequestResponseBuilder.getSuccessResponse();
    }
    
    @RequestMapping(value="/selectcar/{carId}", method=RequestMethod.POST)
    @ResponseBody
    public JSonResponse selectCar(@PathVariable String carId, HttpServletRequest request) {
    	EgunUser egunUser = (EgunUser) request.getSession().getAttribute("signinUser");
    	if (egunUser == null) throw new EgunCarlogException("로그인이 필요합니다.");
    	
    	egunUser.setCurrentCarId( Long.valueOf(carId) );
    	egunUserService.modifyEgunUser(egunUser);
    	request.getSession().setAttribute("signinUser", egunUser);
    	return RequestResponseBuilder.getSuccessResponse();
    }
    
    @RequestMapping(value="/get/{carId}", method=RequestMethod.GET)
    @ResponseBody
    public JSonResponse getCar(@PathVariable String carId, HttpServletRequest request) {
    	EgunCar egunCar = egunCarService.getCar( Long.valueOf(carId) );
    	return RequestResponseBuilder.getSuccessResponse("car", egunCar);
    }
    
    @RequestMapping(value="/delete/{carOid}", method=RequestMethod.DELETE)
    @ResponseBody
    public JSonResponse removeCar(@PathVariable long carOid, HttpServletRequest request) {
    	egunCarService.removeCarById(carOid);
    	return RequestResponseBuilder.getSuccessResponse();
    }
    
	@ExceptionHandler(EgunCarlogException.class)
	@ResponseBody	
	public JSonResponse exceptionHandler(EgunCarlogException ex) {
		return RequestResponseBuilder.getFailResponse(ex);
	}
}
