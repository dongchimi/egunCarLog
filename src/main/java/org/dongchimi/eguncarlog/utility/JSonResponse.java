package org.dongchimi.eguncarlog.utility;

import java.io.Serializable;
import java.util.Map;

public class JSonResponse implements Serializable{
	
	/** UID */
	private static final long serialVersionUID = -8435866819074307491L;
	
	
	private String status;
	private Map<String,Object> data;
	private String message;
	private String failStackMessage;
	
	public JSonResponse(String status) {
		this.status = status;
	}
	
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
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String getFailStackMessage() {
		return failStackMessage;
	}
	public void setFailStackMessage(String failStackMessage) {
		this.failStackMessage = failStackMessage;
	}
	public void addFailStackMessage(String message) {
		failStackMessage = failStackMessage + "\n" + message;
	}

}
