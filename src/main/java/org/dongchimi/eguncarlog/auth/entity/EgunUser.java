package org.dongchimi.eguncarlog.auth.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dongchimi.eguncarlog.utility.DateU;

/**
 * 이건 사용자
 * 
 * @author dklee
 * @since 2010.09.16
 */
@Entity
@Table(name="EGUN_USER")
public class EgunUser implements Serializable {
	
	/** UID */
	private static final long serialVersionUID = 3620291242378441952L;
	
	@Id
	@Column(name = "OBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long objectId;
	
	/** 사용자 Email */
	@Column(name="EMAIL_ADDRESS", nullable=false)
	private String emailAddress;
	
	/** 사용자 이름 */
	@Column(name="NAME")
	private String name;
	
	/** 비밀번호 */
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	/** 가입일자 */
	@Column(name="SIGNUP_DATE")
	private String signupDate;
	
	@Column(name="CURRENT_CAR_ID")
	private long currentCarId = -1;
	
	public EgunUser() {}
	
	public EgunUser(String userEmail, String name, String password) {
		this.emailAddress = userEmail;
		this.name = name;
		this.password = password;
		this.signupDate = DateU.convertDateToString(new Date(), DateU.DEFAULT_DATE_FORMAT);
	}
	
	@Override
	public String toString() {
		return "objectId : " + objectId + ", email:" + emailAddress + ", name:" + name + ", password:" + password + ", signupDate:" + signupDate;
	}
	
	public boolean samePassword(String otherPassword) {
		if (this.password == null) return false;
		
		if (this.password.equals( otherPassword )) 
			return true;
		else
			return false;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public long getCurrentCarId() {
		return currentCarId;
	}
	public void setCurrentCarId(long currentCarId) {
		this.currentCarId = currentCarId;
	}
}
