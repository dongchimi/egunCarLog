package org.dongchimi.eguncarlog.auth.repository;

import java.util.List;

import org.dongchimi.eguncarlog.auth.entity.EgunUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="egunUserRepository")
public class EgunUserRepositoryImpl implements EgunUserRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void persistEgunUser(EgunUser user) {
		getCurrentSession().persist(user);
	}

	@Override
	public void mergeEgunUser(EgunUser user) {
		getCurrentSession().merge(user);
	}

	@Override
	public void deleteEgunUser(EgunUser user) {
		getCurrentSession().delete(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public EgunUser getEgunUserByEmail(String emailAddress) {
		List<EgunUser> users = (List<EgunUser>) getCurrentSession().createQuery(
												"FROM EgunUser as USER WHERE USER.emailAddress = :emailAddress ")
												.setString("emailAddress", emailAddress)
												.list();
		EgunUser foundUser = null;
		if (users != null && users.size() == 1) {
			 foundUser = users.get(0);
		}
		return foundUser;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public EgunUser getEgunUserByName(String name) {
		List<EgunUser> users = (List<EgunUser>) getCurrentSession().createQuery(
												"FROM EgunUser as USER WHERE USER.name = :name ")
												.setString("name", name)
												.list();
		EgunUser foundUser = null;
		if (users != null && users.size() == 1) {
		foundUser = users.get(0);
		}
		return foundUser;
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
