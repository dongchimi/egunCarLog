package org.dongchimi.eguncarlog.car.service;

import java.util.List;

import org.dongchimi.eguncarlog.car.entity.EgunCar;

public interface EgunCarService {
	// �ڵ��� ���
	long createCar(EgunCar car);
	// �ڵ��� ����
	void modifyCar(EgunCar car);
	// �ڵ��� ����
	void removeCarById(long car);
	// �ڵ��� ��ȸ
	List<EgunCar> findCarsByUserEmail(String emailAddress);
	// �ڵ��� ��ȸ
	EgunCar getCar(long carOid);
}
