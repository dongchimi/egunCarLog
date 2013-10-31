package org.dongchimi.eguncarlog.car.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;

public interface EgunCarService {
	// �ڵ��� ���
	long createCar(EgunCar car);
	// �ڵ��� ����
	void modifyCar(EgunCar car);
	// �ڵ��� ����
	void removeCar(EgunCar car);
	// �ڵ��� ��ȸ
	List<EgunCar> findCarsByUserEmail(String emailAddress);
}
