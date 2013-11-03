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
		EgunUser foundUser = egunUserRepository.getEgunUserByEmail(user.getEmailAddress());
		if (foundUser != null) {
			throw new EgunCarlogException("이미 등록된 이메일입니다.");			
		}
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
	public EgunUser getValidUser(String emailOrName, String password) {
		// 1. 아이디 체크
		EgunUser foundUser = egunUserRepository.getEgunUserByEmail(emailOrName);
		if (foundUser == null) {
			foundUser = egunUserRepository.getEgunUserByName(emailOrName);
			if (foundUser == null) {
				throw new EgunCarlogException("입력하신 이메일 또는 이름이 없습니다.");
			}
		}
		
		// 2. 비번체크
		if ( !foundUser.samePassword(password) ) throw new EgunCarlogException("입력하신 비밀번호가 다릅니다.");
		
		return foundUser;
	}
}
