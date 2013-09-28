package org.dongchimi.eguncarlog.unkeep.service;

import java.util.List;

import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;
import org.dongchimi.eguncarlog.unkeep.repository.UnkeepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="unkeepService")
public class UnkeepServiceImpl implements UnkeepService {

	@Autowired
	private UnkeepRepository unkeepRepository;
	
	@Override
	public void createUnkeepItem(UnkeepItem item) {
		unkeepRepository.persistUnKeepItem(item);
	}

	@Override
	public void modifyUnkeepItem(UnkeepItem item) {
		unkeepRepository.mergeUnKeepItem(item);
	}

	@Override
	public void removeUnkeepItem(UnkeepItem item) {
		unkeepRepository.deleteUnKeepItem(item);
	}

	@Override
	public List<UnkeepItem> findUnkeepItemByCarId(Long carOid) {
		return unkeepRepository.findUnkeepItemByCarId(carOid);
	}
}
