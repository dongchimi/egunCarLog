package org.dongchimi.eguncarlog.car.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;
import org.dongchimi.eguncarlog.car.repository.EgunCarRepository;
import org.dongchimi.eguncarlog.utility.EgunCarlogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="egunCarService")
public class EgunCarServiceImpl implements EgunCarService {
	
	@Autowired
	EgunCarRepository egunCarRepository;
	
	@Override
	public long createCar(EgunCar car) {
		return egunCarRepository.persistCar(car);
	}

	@Override
	public void modifyCar(EgunCar car) {
		egunCarRepository.mergeCar(car);
	}

	@Override
	public void removeCarById(long carOid) {
		EgunCar foundCar = egunCarRepository.getCar(carOid);
		if (foundCar != null) {
			egunCarRepository.deleteCar(foundCar);
		}
		else {
			throw new EgunCarlogException("해당하는 Car가 존재하지 않습니다.:" + carOid);
		}
	}

	@Override
	public List<EgunCar> findCarsByUserEmail(String emailAddress) {
		return egunCarRepository.findCarsByUserEmail(emailAddress);
	}

	@Override
	public EgunCar getCar(long carOid) {
		return egunCarRepository.getCar(carOid);
	}
}
