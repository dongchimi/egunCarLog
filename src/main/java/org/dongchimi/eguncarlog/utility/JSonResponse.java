package org.dongchimi.eguncarlog.utility;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class JSonResponse implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = -8435866819074307491L;
	
	
	private String status;
	private List<Map<String,Object>> data;
	private String message;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
}
