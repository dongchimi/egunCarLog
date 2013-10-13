package org.dongchimi.eguncarlog.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class SigninIntercepter extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SigninIntercepter.class.getSimpleName());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		boolean result = false;
		String rootPath = request.getContextPath();
		try {
			logger.debug("enter intercepter");
			HttpSession session = request.getSession(false);

			// session non exist
			if (session == null) {
				logger.info("------------첫 방문--------------");
			}
			else {
				logger.info("requestURI :" + request.getRequestURI());
				// TODO 이동규 resource 파일들을 패스 할 수 있도록!.
				EgunUser user = (EgunUser) session.getAttribute("signinUser");
				if (user != null) {
					logger.info("--------------로그인했음----------------");
				} 
				else {
					logger.info("------------로그인했으나 실패.--------------");
					// TODO 이동규 로그인 한 사람의 url이 아닌 곳은 실패.
					return true;
				}
			}
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			return false;
		}

		return result;
	}
}
