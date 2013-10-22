package org.dongchimi.eguncarlog.auth.service;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;

public interface EgunUserService {
	// 사용자 등록
	void createEgunUser(EgunUser user);
	// 사용자 수정
	void modifyEgunUser(EgunUser user);
	// 사용자 삭제
	void removeEgunUser(EgunUser user);
	// 사용자 조회
	EgunUser getEgunUserByEmail(String emailAddress);
	// 로그인
	EgunUser getValidUser(String emailOrName, String password) ;
}