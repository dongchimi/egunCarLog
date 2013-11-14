package org.dongchimi.eguncarlog.unkeep.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.car.resource.CarResource;
import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;
import org.dongchimi.eguncarlog.unkeep.service.UnkeepService;
import org.dongchimi.eguncarlog.utility.JSonResponse;
import org.dongchimi.eguncarlog.utility.RequestResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api/unkeep")
public class UnkeepResource {
    private static final Logger logger = LoggerFactory.getLogger( CarResource.class.getSimpleName() );
    
    @Autowired
    private UnkeepService unkeepService;
    
    
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
    public JSonResponse list(HttpServletRequest request) {
		EgunUser signinUser = (EgunUser)request.getSession().getAttribute("signinUser");
    	logger.info("currentCarId : " + signinUser.getCurrentCarId());
    	List<UnkeepItem> foundUnkeepItems = unkeepService.findUnkeepItemByCarId( signinUser.getCurrentCarId() );
		return RequestResponseBuilder.getSuccessResponse("unkeepItems", foundUnkeepItems);
    }
	
    @RequestMapping(value="/new", method=RequestMethod.POST)
    @ResponseBody
    public JSonResponse newCar(@ModelAttribute UnkeepItem unkeepItem, HttpServletRequest request) {
    	EgunUser signinUser = (EgunUser)request.getSession().getAttribute("signinUser");
    		
    	long currentCarId = signinUser.getCurrentCarId();
    	unkeepItem.setCarObjectId(currentCarId);
    	
    	unkeepService.createUnkeepItem(unkeepItem);
    	
    	return RequestResponseBuilder.getSuccessResponse();
    }
    
}
