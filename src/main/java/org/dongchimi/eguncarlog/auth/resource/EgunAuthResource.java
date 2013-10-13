package org.dongchimi.eguncarlog.auth.resource;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.service.EgunUserService;
import org.dongchimi.eguncarlog.utility.DateU;
import org.dongchimi.eguncarlog.utility.JSonResponse;
import org.dongchimi.eguncarlog.utility.RequestResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("signinUser")
@RequestMapping(value="/api/auth")
public class EgunAuthResource {
    private static final Logger logger = LoggerFactory.getLogger( EgunAuthResource.class.getSimpleName() );
    
    @Autowired
    private EgunUserService egunUserService;
    
	/**
	 * 회원가입
	 * @param user 사용자 엔티티
	 * @return 
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	@ResponseBody
	public JSonResponse signup(@ModelAttribute EgunUser signinUser, Model model, BindingResult result, SessionStatus status) {
		// 현재 날짜 셋팅
		signinUser.setSignupDate(DateU.getCurrentDateString());
		
		egunUserService.createEgunUser(signinUser);
		
		model.addAttribute("signinUser", signinUser);
		
		return RequestResponseBuilder.getSuccessResponse("user", signinUser);
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	@ResponseBody
	public JSonResponse signin(@ModelAttribute("user") EgunUser inputUser, Model model) {
    	
    	logger.info(inputUser.toString());
    	
    	// 로그인 체크
    	EgunUser validUser = egunUserService.getValidUser(inputUser);
    	logger.info("validUser : " + validUser.toString());
    	model.addAttribute("signinUser", validUser);
    	
    	return RequestResponseBuilder.getSuccessResponse("user", validUser);
	}
}