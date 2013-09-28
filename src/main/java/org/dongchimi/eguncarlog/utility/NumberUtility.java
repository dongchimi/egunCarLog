package org.dongchimi.eguncarlog.utility;

/**
 * Number 유틸리티
 * 
 * @author 이동규
 * @since 2010.11.27
 */
public class NumberUtility {
	
	/**
	 * 문자열을 Integer 형으로
	 * @param str
	 * @return
	 */
	public static int getInt(String str) {
		int i = -1;
		try {
			i = Integer.valueOf(str);
		} catch (NumberFormatException e) {
		}

		return i;
	}
	/**
	 * Long 형을 Integer 형으로 
	 * @param l
	 * @return
	 */
	public static int getInt(Long l) {
		if (l == null)
			return 0;

		return l.intValue();
	}
	
	/**
	 * 문자열을 Long 형으로
	 * @param str
	 * @return
	 */
	public static Long getLong(String str) {
		long l = 0;
		try {
			l = Long.valueOf(str);
		} catch (NumberFormatException e) {
		}
		return l;
	}
}
