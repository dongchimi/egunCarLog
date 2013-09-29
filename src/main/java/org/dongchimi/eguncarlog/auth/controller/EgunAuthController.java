package org.dongchimi.eguncarlog.auth.controller;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.service.EgunUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
