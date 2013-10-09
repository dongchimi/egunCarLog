package org.dongchimi.eguncarlog.auth.repository;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;

public interface EgunUserRepository {
	// ����� ���
	void persistEgunUser(EgunUser user);
	// ����� ����
	void mergeEgunUser(EgunUser user);
	// ����� ����
	void deleteEgunUser(EgunUser user);
	// �̸��Ϸ� ����� ��ȸ
	EgunUser getEgunUserByEmail(String emailAddress);
	// �̸����� ����� ��ȸ
}
