package org.dongchimi.eguncarlog.unkeep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * �������
 * @author dongchimi
 * @since 2010.09.28
 */
@Embeddable
public class GasUnkeep implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = 3296118783563219169L;
	
	// ���ʹ� ���
	@Column(name="PRICE_OF_LITER")
	private String priceOfLiter;

	public String getPriceOfLiter() {
		return priceOfLiter;
	}

	public void setPriceOfLiter(String priceOfLiter) {
		this.priceOfLiter = priceOfLiter;
	}
}
