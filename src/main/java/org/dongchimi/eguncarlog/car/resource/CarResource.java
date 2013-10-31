package org.dongchimi.eguncarlog.car.resource;

import java.util.List;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.dongchimi.eguncarlog.car.service.EgunCarService;
import org.dongchimi.eguncarlog.utility.JSonResponse;
import org.dongchimi.eguncarlog.utility.RequestResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("signinUser")
@RequestMapping(value="/api/car")
public class CarResource {
    private static final Logger logger = LoggerFactory.getLogger( CarResource.class.getSimpleName() );
    
    @Autowired
    private EgunCarService egunCarService;
    
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
    public JSonResponse list(@ModelAttribute EgunUser signinUser, Model model) {
    	logger.info("emailAddress : " + signinUser.getEmailAddress());
    	List<EgunCar> foundCars = egunCarService.findCarsByUserEmail(signinUser.getEmailAddress());
		return RequestResponseBuilder.getSuccessResponse("cars", foundCars);
    }
	
    @RequestMapping(value="/new", method=RequestMethod.POST)
    @ResponseBody
    public JSonResponse newCar(@ModelAttribute EgunCar egunCar) {
    	logger.info("egunCar : " + egunCar);
    	long createCarId = egunCarService.createCar(egunCar);
    	egunCar.setObjectId(createCarId);
    	return RequestResponseBuilder.getSuccessResponse("cars", egunCar);
    }
}
