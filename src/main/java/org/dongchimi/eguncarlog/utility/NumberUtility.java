package org.dongchimi.eguncarlog.utility;

/**
 * Number ��ƿ��Ƽ
 * 
 * @author �̵���
 * @since 2010.11.27
 */
public class NumberUtility {
	
	/**
	 * ���ڿ��� Integer ������
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
	 * Long ���� Integer ������ 
	 * @param l
	 * @return
	 */
	public static int getInt(Long l) {
		if (l == null)
			return 0;

		return l.intValue();
	}
	
	/**
	 * ���ڿ��� Long ������
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
