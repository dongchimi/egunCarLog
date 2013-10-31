package org.dongchimi.eguncarlog.unkeep.controller;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.unkeep.service.UnkeepService;
import org.dongchimi.eguncarlog.utility.EgunCarlogException;
import org.dongchimi.eguncarlog.utility.UnkeepsViewType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("signinUser")
@RequestMapping(value="/{signinUserName}/car/{carIndex}/unkeeps")
public class UnkeepController {
	
    private static final Logger logger = LoggerFactory.getLogger( UnkeepController.class.getSimpleName() );
    
    @Autowired
    private UnkeepService unkeepService;
 
    @RequestMapping(value="/{viewName}", method=RequestMethod.GET)
    public String findUnkeepsByMonth(@ModelAttribute EgunUser signinUser, @PathVariable String viewName) {
    	
    	UnkeepsViewType viewType = UnkeepsViewType.getType(viewName);
    	if (viewType == null) throw new EgunCarlogException("잘못된 URL로 접근하였습니다. unkeeps의 타입 오류입니다. ");
    	
    	String nextView = "";
    	switch(viewType) {
	    	case YEAR :
	    		break;
	    	case MONTH :
	    		nextView = "/unkeep/unkeepsByMonth";
	    		break;
	    	case DAY :
	    		break;
    		default :
    			break;
    	}
    	return nextView;
    }
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newForm() {
    	return "/unkeep/newUnkeep";
    }
}
