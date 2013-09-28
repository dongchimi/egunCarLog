package org.dongchimi.eguncarlog.car.repository;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="egunCarRepository")
public class EgunCarRepositoryImpl implements EgunCarRepository {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void persistCar(EgunCar car) {
		getCurrentSession().persist(car);
	}

	@Override
	public void mergeCar(EgunCar car) {
		getCurrentSession().merge(car);
	}

	@Override
	public void deleteCar(EgunCar car) {
		getCurrentSession().delete(car);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EgunCar> findCarsByUserEmail(String emailAddress) {
		List<EgunCar> foundCars = (List<EgunCar>) getCurrentSession().createQuery(
											"FROM Car as CAR WHERE CAR.userEmailAddress = :emailAddress ")
											.setString("emailAddress", emailAddress)
											.list();
		return foundCars;
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
