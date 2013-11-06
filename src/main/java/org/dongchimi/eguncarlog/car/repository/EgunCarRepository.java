package org.dongchimi.eguncarlog.car.repository;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;

public interface EgunCarRepository {
	// 자동차 등록
	Long persistCar(EgunCar car);
	// 자동차 수정
	void mergeCar(EgunCar car);
	// 자동차 삭제
	void deleteCar(EgunCar car);
	// 자동차 조회
	List<EgunCar> findCarsByUserEmail(String emailAddress);
	// 자동차 조회 
	EgunCar getCar(long carOid);
}
