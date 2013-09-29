package org.dongchimi.eguncarlog.auth.controller;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.service.EgunUserService;
import org.dongchimi.eguncarlog.utility.DateU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("signinUser")
@RequestMapping(value="/auth")
public class EgunAuthController {
    private static final Logger logger = LoggerFactory.getLogger( EgunAuthController.class.getSimpleName() );
    
    @Autowired
    private EgunUserService egunUserService;
    
    /**
     * 회원가입 폼 조회
     * @return
     */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signupForm() {
        return "/auth/signup";
    }
    
	/**
	 * 회원가입
	 * @param user 사용자 엔티티
	 * @return 
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute EgunUser signinUser, BindingResult result, SessionStatus status) {
		// 현재 날짜 셋팅
		signinUser.setSignupDate(DateU.getCurrentDateString());
		
		logger.info(signinUser.toString());
		egunUserService.createEgunUser(signinUser);
		
		// 로그인 처리
		
		
		// TODO 이동규 로그인 후 화면
		return "/index";
	}
	
    
    @RequestMapping(value="/signin", method=RequestMethod.POST)
    public String signin(@ModelAttribute EgunUser inputUser, Model model) {
    	
    	logger.info(inputUser.toString());
    	
    	// 로그인 체크
    	EgunUser validUser = egunUserService.getValidUser(inputUser);
    	if (validUser != null) {
    		logger.debug(validUser.toString());
    	}
    	else {
    		logger.debug("로그인 실패");
    	}
    	model.addAttribute("signinUser", validUser);
    	return "redirect:/unkeep/unkeeps/month";
    }
}
