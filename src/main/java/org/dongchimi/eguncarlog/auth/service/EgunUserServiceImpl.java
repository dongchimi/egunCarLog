package org.dongchimi.eguncarlog.auth.service;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.dongchimi.eguncarlog.auth.repository.EgunUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="egunUserService")
public class EgunUserServiceImpl implements EgunUserService {
	
	@Autowired
	EgunUserRepository egunUserRepository;
	
	public void createEgunUser(EgunUser user) {
		egunUserRepository.persistEgunUser(user);
	}

	public void modifyEgunUser(EgunUser user) {
		egunUserRepository.mergeEgunUser(user);
	}

	public void removeEgunUser(EgunUser user) {
		egunUserRepository.deleteEgunUser(user);
	}

	public EgunUser getEgunUserByEmail(String emailAddress) {
		return egunUserRepository.getEgunUserByEmail(emailAddress);
	}
}
