package org.dongchimi.eguncarlog.car.repository;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;

public interface EgunCarRepository {
	// �ڵ��� ���
	void persistCar(EgunCar car);
	// �ڵ��� ����
	void mergeCar(EgunCar car);
	// �ڵ��� ����
	void deleteCar(EgunCar car);
	// �ڵ��� ��ȸ
	List<EgunCar> findCarsByUserEmail(String emailAddress);
}