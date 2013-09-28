package org.dongchimi.eguncarlog.unkeep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 유지비
 * @author dongchimi
 * @since 2010.09.23
 */
@Entity
@Table(name="UNKEEP_ITEM")
public class UnkeepItem implements Serializable {
	
	/** UID */
	private static final long serialVersionUID = 7372774019329958148L;

	@Id
	@Column(name = "OBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long objectId;
	
	@Column(name = "CAR_OBJECT_ID", nullable=false)
	private Long carObjectId;
	
	// 항목명
	@Column(name="ITEM_NAME", nullable=false)
	private String itemName;
	
	// 사용날짜
	@Column(name="USE_DATE", nullable=false)
	private String useDate;
	
	// 비용
	@Column(name="UNKEEP_PRICE", nullable=false)
	private String unkeepPrice;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Embedded
	private GasUnkeep gas;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnkeepPrice() {
		return unkeepPrice;
	}

	public void setUnkeepPrice(String unkeepPrice) {
		this.unkeepPrice = unkeepPrice;
	}

	public GasUnkeep getGas() {
		return gas;
	}

	public void setGas(GasUnkeep gas) {
		this.gas = gas;
	}

	public Long getCarObjectId() {
		return carObjectId;
	}

	public void setCarObjectId(Long carObjectId) {
		this.carObjectId = carObjectId;
	}
}
