package org.dongchimi.eguncarlog.car.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;

public interface EgunCarService {
	// 자동차 등록
	long createCar(EgunCar car);
	// 자동차 수정
	void modifyCar(EgunCar car);
	// 자동차 삭제
	void removeCarById(long car);
	// 자동차 조회
	List<EgunCar> findCarsByUserEmail(String emailAddress);
	// 자동차 조회
	EgunCar getCar(long carOid);
}
