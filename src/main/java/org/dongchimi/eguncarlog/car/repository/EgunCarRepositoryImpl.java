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
	public Long persistCar(EgunCar car) {
		getCurrentSession().persist(car);
		return car.getObjectId();
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
											"FROM EgunCar as CAR WHERE CAR.userEmailAddress = :emailAddress ")
											.setString("emailAddress", emailAddress)
											.list();
		return foundCars;
	}
	
	@Override
	public EgunCar getCar(long carOid) {
		return (EgunCar) getCurrentSession().get(EgunCar.class, carOid);
	}
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
