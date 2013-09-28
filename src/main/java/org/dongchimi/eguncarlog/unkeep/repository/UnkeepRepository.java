package org.dongchimi.eguncarlog.unkeep.repository;

import java.util.List;

import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;

public interface UnkeepRepository {
	// ��� ���
	void persistUnKeepItem(UnkeepItem item);
	// ��� ����
	void mergeUnKeepItem(UnkeepItem item);
	// ��� ����
	void deleteUnKeepItem(UnkeepItem item);
	// ��� ��ȸ
	List<UnkeepItem> findUnkeepItemByCarId(Long carObjectId);
}
