package org.dongchimi.eguncarlog.unkeep.service;

import java.util.List;

import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;

public interface UnkeepService {
	// ������ ���
	void createUnkeepItem(UnkeepItem item);
	// ������ ����
	void modifyUnkeepItem(UnkeepItem item);
	// ������ ����
	void removeUnkeepItem(UnkeepItem item);
	// ������ ��ȸ
	List<UnkeepItem> findUnkeepItemByCarId(Long carOid);
}
