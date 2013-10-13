package org.dongchimi.eguncarlog.auth.controller;

import org.dongchimi.eguncarlog.auth.service.EgunUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
