package org.dongchimi.eguncarlog.car.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.dongchimi.eguncarlog.car.repository.EgunCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="egunCarService")
public class EgunCarServiceImpl implements EgunCarService {
	
	@Autowired
	EgunCarRepository egunCarRepository;
	
	@Override
	public void createCar(EgunCar car) {
		egunCarRepository.persistCar(car);
	}

	@Override
	public void modifyCar(EgunCar car) {
		egunCarRepository.mergeCar(car);
	}

	@Override
	public void removeCar(EgunCar car) {
		egunCarRepository.deleteCar(car);
	}

	@Override
	public List<EgunCar> findCarsByUserEmail(String emailAddress) {
		return egunCarRepository.findCarsByUserEmail(emailAddress);
	}
}
