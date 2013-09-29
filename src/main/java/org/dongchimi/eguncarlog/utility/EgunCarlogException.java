package org.dongchimi.eguncarlog.utility;

public class EgunCarlogException extends RuntimeException {

	/** UID */
	private static final long serialVersionUID = -2739540700941607729L;

	private String errorMessage;

	public EgunCarlogException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}
}
