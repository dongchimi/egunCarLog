package org.dongchimi.eguncarlog.utility;

public enum UnkeepsViewType {
	
	MONTH,
	YEAR,
	DAY;
	
	public static UnkeepsViewType getType(String viewName) {
		if ("month".equals(viewName)) {
			return UnkeepsViewType.MONTH;
		}
		else if ("year".equals(viewName)) {
			return UnkeepsViewType.YEAR;
		}
		else if ("day".equals(viewName)) {
			return UnkeepsViewType.DAY;
		}
		
		return null;
	}
}
