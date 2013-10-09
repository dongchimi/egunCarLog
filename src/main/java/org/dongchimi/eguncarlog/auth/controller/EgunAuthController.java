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
     * ȸ������ �� ��ȸ
     * @return
     */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signupForm() {
        return "/auth/signup";
    }
    
	/**
	 * ȸ������
	 * @param user ����� ��ƼƼ
	 * @return 
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute EgunUser signinUser, BindingResult result, SessionStatus status) {
		// ���� ��¥ ����
		signinUser.setSignupDate(DateU.getCurrentDateString());
		
		logger.info(signinUser.toString());
		egunUserService.createEgunUser(signinUser);
		
		// �α��� ó��
		
		
		// TODO �̵��� �α��� �� ȭ��
		return "/index";
	}
	
    
    @RequestMapping(value="/signin", method=RequestMethod.POST)
    public String signin(@ModelAttribute EgunUser inputUser, Model model) {
    	
    	logger.info(inputUser.toString());
    	
    	// �α��� üũ
    	EgunUser validUser = egunUserService.getValidUser(inputUser);
    	if (validUser != null) {
    		logger.debug(validUser.toString());
    	}
    	else {
    		logger.debug("�α��� ����");
    	}
    	model.addAttribute("signinUser", validUser);
    	return "redirect:/unkeep/unkeeps/month";
    }
}
