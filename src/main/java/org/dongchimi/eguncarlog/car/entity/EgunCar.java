package org.dongchimi.eguncarlog.car.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �ڵ���
 * 
 * @author dklee
 * @since 2010.09.23
 */
@Entity
@Table(name="EGUN_CAR")
public class EgunCar implements Serializable {
	
	/** UID */
	private static final long serialVersionUID = 1419611059328139603L;

	@Id
	@Column(name = "OBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long objectId;
	
	// ����� �̸��� �ּ�
	@Column(name="USER_EMAIL_ADDRESS", nullable=false)
	private String userEmailAddress;
	
	// ��Ī
	@Column(name="ALIAS", nullable=false)
	private String alias;
	
	// ��
	@Column(name="MODEL_NAME", nullable=false)
	private String modelName;
	
	// ������
	@Column(name="AUTOMAKER")
	private String automaker;
	
	// �����⵵
	@Column(name="MAKE_YEAR")
	private String makeYear;
	
	// ������
	@Column(name="BUY_DATE")
	private String buyDate;
	
	// �ڵ�����ȣ 
	@Column(name="CAR_NUMBER")
	private String carNumber;
	
	// �����ȣ
	@Column(name="VIN")
	private String vin;
	
	// �޸�
	@Column(name="MEMO")
	private String memo;
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAutomaker() {
		return automaker;
	}
	public void setAutomaker(String automaker) {
		this.automaker = automaker;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public String getUserEmailAddress() {
		return userEmailAddress;
	}
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}
}
