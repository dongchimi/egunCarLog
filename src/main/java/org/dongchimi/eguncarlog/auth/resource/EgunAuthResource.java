package org.dongchimi.eguncarlog.auth.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dongchimi.eguncarlog.auth.controller.EgunAuthController;
import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.service.EgunUserService;
import org.dongchimi.eguncarlog.utility.DateU;
import org.dongchimi.eguncarlog.utility.JSonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private static final Logger logger = LoggerFactory.getLogger( EgunAuthController.class.getSimpleName() );
    
    @Autowired
    private EgunUserService egunUserService;
    
	/**
	 * ȸ������
	 * @param user ����� ��ƼƼ
	 * @return 
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	@ResponseBody
	public JSonResponse signup(@ModelAttribute EgunUser signinUser, BindingResult result, SessionStatus status) {
		// ���� ��¥ ����
		signinUser.setSignupDate(DateU.getCurrentDateString());
		
		logger.info(signinUser.toString());
		egunUserService.createEgunUser(signinUser);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", signinUser);
		List<Map<String,Object>> list =  new ArrayList<Map<String,Object>>();
		list.add(map);
		JSonResponse response = new JSonResponse();
		response.setStatus("success");
		response.setData(list);
		return response;
		// �α��� ó��
		
		// TODO �̵��� �α��� �� ȭ��
		//return "/index";
	}
}
