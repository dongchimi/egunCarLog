package org.dongchimi.eguncarlog.unkeep.service;

import java.util.List;

import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;

public interface UnkeepService {
	// 유지비 등록
	void createUnkeepItem(UnkeepItem item);
	// 유지비 수정
	void modifyUnkeepItem(UnkeepItem item);
	// 유지비 삭제
	void removeUnkeepItem(UnkeepItem item);
	// 유지비 조회
	List<UnkeepItem> findUnkeepItemByCarId(Long carOid);
}
