package org.dongchimi.eguncarlog.auth.repository;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;

public interface EgunUserRepository {
	// 사용자 등록
	void persistEgunUser(EgunUser user);
	// 사용자 수정
	void mergeEgunUser(EgunUser user);
	// 사용자 삭제
	void deleteEgunUser(EgunUser user);
	// 이메일로 사용자 조회
	EgunUser getEgunUserByEmail(String emailAddress);
	// 이름으로 사용자 조회
}
