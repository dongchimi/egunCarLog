package org.dongchimi.eguncarlog.unkeep.repository;

import java.util.List;

import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;

public interface UnkeepRepository {
	// 경비 등록
	void persistUnKeepItem(UnkeepItem item);
	// 경비 수정
	void mergeUnKeepItem(UnkeepItem item);
	// 경비 삭제
	void deleteUnKeepItem(UnkeepItem item);
	// 경비 조회
	List<UnkeepItem> findUnkeepItemByCarId(Long carObjectId);
}
