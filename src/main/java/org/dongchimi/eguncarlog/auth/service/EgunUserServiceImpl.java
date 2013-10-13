package org.dongchimi.eguncarlog.auth.service;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.repository.EgunUserRepository;
import org.dongchimi.eguncarlog.utility.EgunCarlogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="egunUserService")
public class EgunUserServiceImpl implements EgunUserService {
	
	@Autowired
	EgunUserRepository egunUserRepository;

	@Override
	public void createEgunUser(EgunUser user) {
		egunUserRepository.persistEgunUser(user);
	}

	@Override
	public void modifyEgunUser(EgunUser user) {
		egunUserRepository.mergeEgunUser(user);
	}

	@Override
	public void removeEgunUser(EgunUser user) {
		egunUserRepository.deleteEgunUser(user);
	}

	@Override
	public EgunUser getEgunUserByEmail(String emailAddress) {
		return egunUserRepository.getEgunUserByEmail(emailAddress);
	}

	@Override
	public EgunUser getValidUser(EgunUser user) {
		// 1. ���̵� üũ
		EgunUser foundUser = egunUserRepository.getEgunUserByEmail(user.getEmailAddress());
		if (foundUser == null) throw new EgunCarlogException("�Է��Ͻ� �̸����� �����ϴ�.");
		
		// 2. ���üũ
		if (!foundUser.samePassword(user.getPassword())) throw new EgunCarlogException("�Է��Ͻ� ��й�ȣ�� �ٸ��ϴ�.");
		
		return foundUser;
	}
}
