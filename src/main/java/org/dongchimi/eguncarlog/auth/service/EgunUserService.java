package org.dongchimi.eguncarlog.auth.service;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;

public interface EgunUserService {
	// ����� ���
	void createEgunUser(EgunUser user);
	// ����� ����
	void modifyEgunUser(EgunUser user);
	// ����� ����
	void removeEgunUser(EgunUser user);
	// ����� ��ȸ
	EgunUser getEgunUserByEmail(String emailAddress);
	// �α���
	EgunUser getValidUser(String emailOrName, String password) ;
}