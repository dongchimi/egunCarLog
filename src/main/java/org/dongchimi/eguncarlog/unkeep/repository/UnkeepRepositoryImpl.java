package org.dongchimi.eguncarlog.unkeep.repository;

import java.util.List;

import org.dongchimi.eguncarlog.unkeep.entity.UnkeepItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="unkeepRepository")
public class UnkeepRepositoryImpl implements UnkeepRepository {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void persistUnKeepItem(UnkeepItem item) {
		getCurrentSession().persist(item);
	}

	@Override
	public void mergeUnKeepItem(UnkeepItem item) {
		getCurrentSession().merge(item);
	}

	@Override
	public void deleteUnKeepItem(UnkeepItem item) {
		getCurrentSession().delete(item);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UnkeepItem> findUnkeepItemByCarId(Long carObjectId) {
		List<UnkeepItem> foundUnkeepItems = getCurrentSession().createCriteria(UnkeepItem.class)
				.add( Restrictions.eq("carObjectId", carObjectId) )
				.list();
		return foundUnkeepItems;
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
