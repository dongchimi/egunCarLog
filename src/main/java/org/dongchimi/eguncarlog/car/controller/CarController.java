package org.dongchimi.eguncarlog.car.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/{signinUserName}/cars")
public class CarController {
	
    private static final Logger logger = LoggerFactory.getLogger( CarController.class.getSimpleName() );
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list() {
    	return "/car/cars";
    }

    @RequestMapping(value="/{carIndex}", method=RequestMethod.GET)
    public String getCar() {
    	return "";
    }
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newForm() {
    	return "/car/newCar";
    }
}
