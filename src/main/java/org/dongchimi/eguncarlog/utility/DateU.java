package org.dongchimi.eguncarlog.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * DateUtil ��¥�� �ð��� ���õ� ��ƿ��Ƽ Ŭ����
 * 
 * @version 1.0
 * @modifier �̵���
 * @since 2011.01.13
 */
public class DateU {

	/** 1���� �и��ʷ� ȯ���� ��(86400000 = 24*60*60*1000) */
	public static final long MILLISECOND_OF_DAY = 24 * 60 * 60 * 1000;

	/** ��������Ͽ��� �׸���ġ���ؽÿ��� ���̸� �и�������� ȯ���� ��. */
	public static final long GMT_RAW_OFFSET = TimeZone.getDefault()
			.getRawOffset();

	/** �⺻����(yyyyMMddHHmmss) */
	public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";

	/** ��¥ �⺻����(yyyyMMdd) */
	public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

	/** �ð� �⺻����(HHmmss) */
	public static final String DEFAULT_TIME_FORMAT = "HHmmss";

	/** ������ �ð� �⺻����(HHmm) */
	public static final String DEFAULT_HHMM_FORMAT = "HHmm";

	/** �ʱ�����("0001-01-01") */
	public static final String MINIMUM_DATE = "00010101";

	/** ��������("9999-12-31") */
	public static final String MAXIMUM_DATE = "99991231";

	/** �ʱ�����("01-01") */
	public static final String MINIMUN_MMDD = "0101";

	/** ��������("12-31") */
	public static final String MAXIMUM_MMDD = "1231";

	/** �⵵ ���� */
	public static final String YEAR_FORMAT = "yyyy";

	/** �� ���� */
	public static final String MONTH_FORMAT = "MM";

	/** �� ���� */
	public static final String DATE_FORMAT = "dd";

	/** ����(�ѱ۸�) */
	private static final String[] DAY_OF_WEEKS_KOREAN = { "�Ͽ���", "������", "ȭ����",
			"������", "�����", "�ݿ���", "�����" };

	/** ����(��� �ѱ۸�) */
	private static final String[] DAY_OF_WEEKS_SHORT_KOREAN = { "��", "��", "ȭ",
			"��", "��", "��", "��" };

	/** ����(������) */
	private static final String[] DAY_OF_WEEKS_ENGLISH = { "Sun", "Mon", "Tue",
			"Wed", "Thu", "Fri", "Sat" };

	private DateU() {
	}

	public static String getThisMonthStartDayByBaseDate(String baseDate) {
		String currentYyyyMMdd = getCurrentDateString("yyyyMMdd");
		
		String currentYyyyMm = currentYyyyMMdd.substring(0, 6);
		String currentDd = currentYyyyMMdd.substring(6, 8);
		
		int baseDateI = NumberUtility.getInt(baseDate);
		int todayI = NumberUtility.getInt(currentDd);
		
		String startDay = currentYyyyMm + baseDate;
		if (baseDateI > todayI) {
			startDay = DateU.addMonth(startDay, -1);
		}

		return startDay;
	}

	public static String getThisMonthEndDayByBaseDate(String baseDate) {
		String currentYyyyMMdd = getCurrentDateString("yyyyMMdd");
		
		String currentYyyyMm = currentYyyyMMdd.substring(0, 6);
		String currentDd = currentYyyyMMdd.substring(6, 8);
		
		int baseDateI = NumberUtility.getInt(baseDate);
		int todayI = NumberUtility.getInt(currentDd);
		
		String endDay = currentYyyyMm + baseDate;
		if (baseDateI <= todayI) {
			endDay = DateU.addMonth(endDay, 1);
		}
		
		return endDay;
	}
	
	public static void main(String[] args) {
		//System.out.println(DateU.getThisMonthStartDayByBaseDate("25"));
		System.out.println(DateU.getThisMonthEndDayByBaseDate("25"));
	}

	/**
	 * �⺻ ����(yyyyMMdd)���� �� ���� ��¥�� <code>java.lang.String</code>���� ��ȸ�Ѵ�.
	 * <p>
	 * ������ : currentDateString(), getToday()
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		return getCurrentDateString(DEFAULT_DATE_FORMAT);
	}

	/**
	 * �Է� �������� �� ���� ��¥�� <code>java.lang.String</code>���� ��ȸ�Ѵ�.
	 * <p>
	 * ������ : currentDateStringWithFormat(String afterFormat)
	 * 
	 * @param dateFormat
	 *            ������ ����
	 * @return
	 */
	public static String getCurrentDateString(String dateFormat) {
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(new Date());
	}

	/**
	 * �⺻ �������� �� ���� ��¥�� <code>java.util.Date</code>���� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return getCurrentDate(DEFAULT_DATE_FORMAT);
	}

	/**
	 * �Է� �������� �� ���� ��¥�� <code>java.util.Date</code>���� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static Date getCurrentDate(String dateFormat) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		df.setCalendar(calendar);
		return calendar.getTime();
	}

	/**
	 * �⺻ �������� �� ���� ��¥�� <code>java.lang.String</code>���� ��ȸ�Ѵ�.
	 * <p>
	 * ������ : getCurrentDateTime()
	 * 
	 * @return
	 */
	public static String getCurrentStringDateTime() {
		return getCurrentStringDateTime(DEFAULT_FORMAT);
	}

	/**
	 * �Է� �������� �� ���� ��¥�� <code>java.lang.String</code>���� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static String getCurrentStringDateTime(String dateFormat) {
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(new Date());
	}

	/**
	 * �⺻ �������� �� ���� ��¥�ͽð��� <code>java.util.Date</code>���� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static Date getCurrentDateTime() {
		return getCurrentDateTime(DEFAULT_FORMAT);
	}

	/**
	 * �Է� �������� �� ���� ��¥�ͽð��� <code>java.util.Date</code>���� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static Date getCurrentDateTime(String dateFormat) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		df.setCalendar(calendar);
		return calendar.getTime();
	}

	/**
	 * �⺻ �������� �� ���� �ð��� java.lang.String���� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static String getCurrentTimeString() {
		Date toDate = getCurrentDateTime(DEFAULT_TIME_FORMAT);
		return convertDateToString(toDate, DEFAULT_TIME_FORMAT);
	}

	/**
	 * HH:mm ������ ���� �ð��� ��ȸ�Ѵ�.
	 * 
	 * @return
	 */
	public static String getCurrentHHmmString() {
		Date toDate = getCurrentDateTime(DEFAULT_HHMM_FORMAT);
		return convertDateToString(toDate, DEFAULT_HHMM_FORMAT);
	}

	/**
	 * �����Ͽ��� ����� �����Ѵ�. �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param date
	 *            ��������
	 * @param nYears
	 *            ����(+ or -) ���
	 * @return
	 */
	public static Date addYear(Date date, int nYears) {
		return addYear(date, nYears, true);
	}

	/**
	 * �����Ͽ��� ����� �����Ѵ�. �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param date
	 *            ��������
	 * @param dateFormat
	 *            ��¥����
	 * @param nYears
	 *            ����(+ or -) ���
	 * @return
	 */
	public static String addYear(String currentDate, String dateFormat,
			int nYears) {
		Date date = convertStringToDate(currentDate, dateFormat);
		Date toDate = addYear(date, nYears, true);
		return convertDateToString(toDate, dateFormat);
	}

	/**
	 * �����Ͽ��� ����� �����Ѵ�. �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param currentDate
	 *            ��������
	 * @param nYears
	 *            ����(+ or -) ���
	 * @return
	 */
	public static String addYear(String currentDate, int nYears) {
		return addYear(currentDate, DEFAULT_DATE_FORMAT, nYears);
	}

	/**
	 * �����Ͽ��� ����� �����Ѵ�. �����ڰ˻翩�ΰ� true�̰� �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param date
	 *            ��������
	 * @param nYears
	 *            ����(+ or -) ���
	 * @param lastDayCheckupYn
	 *            �����ڰ˻翩��
	 * @return
	 */
	public static Date addYear(Date date, int nYears, boolean lastDayCheckupYn) {
		// ���س⵵�̸� �Էµ� �������ڸ� ��ȯ�Ѵ�.
		if (0 == nYears)
			return (Date) date.clone();

		// �����ڰ˻翩�ΰ� true�̰� �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (lastDayCheckupYn && isLastDay(calendar)) {
			calendar.add(Calendar.YEAR, nYears);
			calendar.set(Calendar.DATE,
					calendar.getActualMaximum(Calendar.DATE));
		} else {
			calendar.add(Calendar.YEAR, nYears);
		}

		// ����Ÿ���� ������ ������ �ð��� 0���� ����
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * �����Ͽ��� ������ �����Ѵ�.
	 * 
	 * @param date
	 *            ��������
	 * @param nMonths
	 *            ����(+ or -) ����
	 * @return
	 */
	public static Date addMonth(Date date, int nMonths) {
		return addMonth(date, nMonths, false);
	}

	/**
	 * �����Ͽ��� ����� �����Ѵ�. �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param currentDate
	 *            ��������
	 * @param dateFormat
	 *            ��¥����
	 * @param nYears
	 *            ����(+ or -) ���
	 * @return
	 */
	public static String addMonth(String currentDate, String dateFormat,
			int nYears) {
		Date date = convertStringToDate(currentDate, dateFormat);
		Date toDate = addMonth(date, nYears, true);
		return convertDateToString(toDate, dateFormat);
	}

	/**
	 * �����Ͽ��� ����� �����Ѵ�. �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param currentDate
	 *            ��������
	 * @param nMonths
	 *            ����(+ or -) ���
	 * @return
	 */
	public static String addMonth(String currentDate, int nMonths) {
		return addMonth(currentDate, DEFAULT_DATE_FORMAT, nMonths);
	}

	/**
	 * �����Ͽ��� ������ �����Ѵ�. �����ڰ˻翩�ΰ� true�̰� �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
	 * 
	 * @param date
	 *            ��������
	 * @param nMonths
	 *            ����(+ or -) ����
	 * @param lastDayCheckupYn
	 *            �����ڰ˻翩��
	 * @return
	 */
	public static Date addMonth(Date date, int nMonths, boolean lastDayCheckupYn) {
		// ����̸� �Էµ� �������ڸ� ��ȯ�Ѵ�.
		if (0 == nMonths)
			return (Date) date.clone();

		// �����ڰ˻翩�ΰ� true�̰� �Է����ڰ� �������̸� ���������ڵ� �����ڷ� �����Ѵ�.
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (lastDayCheckupYn && isLastDay(calendar)) {
			calendar.add(Calendar.MONTH, nMonths);
			calendar.set(Calendar.DATE,
					calendar.getActualMaximum(Calendar.DATE));
		} else {
			calendar.add(Calendar.MONTH, nMonths);
		}

		// ����Ÿ���� ������ ������ �ð��� 0���� ����
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * ��¥ �߰�
	 * 
	 * @param date
	 *            : �ٲܳ�¥
	 * @param nDays
	 *            : �߰�����
	 * @return Date
	 */
	public static Date addDate(Date date, int nDays) {
		// �����̸� �������ڸ� ��ȯ�Ѵ�.
		if (0 == nDays)
			return (Date) date.clone();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, nDays);

		// ����Ÿ���� ������ ������ �ð��� 0���� ����
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * ��¥ �߰�
	 * 
	 * @param date
	 *            : �ٲܳ�¥
	 * @param dateFormat
	 *            : �Է� ����
	 * @param nDays
	 *            : �߰�����
	 * @return Date
	 */
	public static Date addDate(Date date, String dateFormat, int nDays) {
		String toDate = convertFormatDateToString(date, dateFormat);

		return addDate(convertStringToDate(toDate, dateFormat), nDays);
	}

	/**
	 * ��¥ �߰�
	 * 
	 * @param date
	 *            : �ٲܳ�¥
	 * @param dateFormat
	 *            : �Է� ����
	 * @param nDays
	 *            : �߰�����
	 * @return String
	 */
	public static String addDate(String date, String dateFormat, int nDays) {
		Date toDate = addDate(convertStringToDate(date, dateFormat), nDays);
		return convertDateToString(toDate, dateFormat);
	}

	/**
	 * �⺻ ������ �̿��� ��¥ �߰�
	 * 
	 * @param date
	 * @param nDays
	 * @return
	 */
	public static String addDate(String date, int nDays) {
		return addDate(date, DEFAULT_DATE_FORMAT, nDays);
	}

	/**
	 * ��,���� �߰� �� ������ ���ΰ� true �̸� �߰������� �����ڸ� ����
	 * 
	 * @param date
	 *            : �ٲܳ�¥
	 * @param nMonth
	 *            : �߰�����
	 * @param nDate
	 *            : �߰�����
	 * @param isLastDay
	 *            : ������ ����
	 * @return Date
	 */
	public static Date addMonth(Date date, int nMonth, int nDate,
			boolean isLastDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (isLastDay && isLastDay(calendar)) {
			calendar.add(Calendar.MONTH, nMonth);
			calendar.set(Calendar.DATE,
					calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		} else {
			calendar.add(Calendar.MONTH, nMonth);
			calendar.add(Calendar.DATE, nDate);
		}

		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * ��,���� �߰� �� ������ ���ΰ� true �̸� �߰������� �����ڸ� ����
	 * 
	 * @param date
	 *            : �ٲܳ�¥
	 * @param basisDate
	 *            : ������¥
	 * @param nMonth
	 *            : �߰�����
	 * @param nDate
	 *            : �߰�����
	 * @param isLastDay
	 *            : ������ ����
	 * @return Date
	 */
	public static Date addMonth(Date date, Date basisDate, int nMonth, int nDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (isLastDay(basisDate)) {
			calendar.add(Calendar.MONTH, nMonth);
			calendar.set(Calendar.DATE,
					calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		} else {
			calendar.add(Calendar.MONTH, nMonth);
			calendar.add(Calendar.DATE, nDate);
		}

		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * �������ڰ� �ش���� ���������� ���θ� ��ȯ�Ѵ�.
	 * 
	 * @param basisDate
	 *            ��������
	 * @return �������ڰ� �ش���� ���������� ���θ� ��ȯ�Ѵ�.
	 */
	public static boolean isLastDay(Date basisDate) {
		Calendar basisCal = Calendar.getInstance();
		basisCal.setTime(basisDate);
		return isLastDay(basisCal);
	}

	/**
	 * �������ڰ� �ش���� ���������� ���θ� ��ȯ�Ѵ�.
	 * 
	 * @param basisCal
	 *            ���ش޷�
	 * @return �������ڰ� �ش���� ���������� ���θ� ��ȯ�Ѵ�.
	 */
	public static boolean isLastDay(Calendar basisCal) {
		return (basisCal.get(Calendar.DATE) == basisCal
				.getActualMaximum(Calendar.DATE));
	}

	/**
	 * �����ڷ� �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @return Date ������
	 */
	public static Date setLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * �����ڷ� �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @param format
	 *            �Է�����
	 * @return String ������
	 */
	public static String setLastDay(String date, String format) {
		Date toDate = convertStringToDate(date, format);
		Date lastDate = setLastDay(toDate);
		return convertDateToString(lastDate, format);
	}

	/**
	 * �����ڷ� �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @param format
	 *            �Է�����
	 * @return String ������
	 */
	public static String setLastDay(String date) {
		Date toDate = convertStringToDate(date, DEFAULT_DATE_FORMAT);
		Date lastDate = setLastDay(toDate);
		return convertDateToString(lastDate, DEFAULT_DATE_FORMAT);
	}

	/**
	 * �����ڷ� �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @return String ������
	 */
	public static String setLastDayByYearMonth(String date) {
		Date toDate = convertStringToDate(date, YEAR_FORMAT + MONTH_FORMAT);
		Date lastDate = setLastDay(toDate);
		return convertDateToString(lastDate, DEFAULT_DATE_FORMAT);
	}

	/**
	 * �����ڷ� �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @return Date ������
	 */
	public static Date setFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * ������ �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @param format
	 *            �Է�����
	 * @return String ������
	 */
	public static String setFirstDay(String date, String format) {
		Date toDate = convertStringToDate(date, format);
		Date lastDate = setFirstDay(toDate);
		return convertDateToString(lastDate, format);
	}

	/**
	 * �����ڷ� �����Ͽ� ��ȯ
	 * 
	 * @param date
	 * @return String ������
	 */
	public static String setFirstDayByYearMonth(String date) {
		Date toDate = convertStringToDate(date, YEAR_FORMAT + MONTH_FORMAT);
		Date lastDate = setFirstDay(toDate);
		return convertDateToString(lastDate, DEFAULT_DATE_FORMAT);
	}

	/**
	 * ������ �����Ͽ� �⺻�������� ��ȯ
	 * 
	 * @param date
	 * @return String ������
	 */
	public static String setFirstDay(String date) {
		Date toDate = convertStringToDate(date, DEFAULT_DATE_FORMAT);
		Date lastDate = setFirstDay(toDate);
		return convertDateToString(lastDate, DEFAULT_DATE_FORMAT);
	}

	/**
	 * �Էµ� ��¥�� '0001-01-01'�� ���� ��¥���� ���Ѵ�.
	 * 
	 * @param date
	 *            ���ҳ�¥
	 * @return
	 */
	public static boolean isFirstDate(String date) {
		return MINIMUM_DATE.equals(date);
	}

	/**
	 * �⺻�������� ��¥ ���� ����
	 * 
	 * @param date
	 * @return
	 */
	public static String convertFormat(Date date) {
		return convertFormat(date, DEFAULT_DATE_FORMAT);
	}

	/**
	 * �⺻�������� ��¥ ���� ����
	 * 
	 * @param date
	 * @return
	 */
	public static String convertFormat(String date, String beforeFormat) {
		Date toDate = convertStringToDate(date, beforeFormat);
		return convertFormat(toDate);
	}

	/**
	 * ��¥ ���� ���� ������ : converDateString(String date, beforeFormat, afterFormat)
	 * 
	 * @param date
	 * @param afterFormat
	 * @return String
	 */
	public static String convertFormat(String date, String beforeFormat,
			String afterFormat) {
		if (beforeFormat == null || beforeFormat.equals(afterFormat))
			return date;

		Date toDate = convertStringToDate(date, beforeFormat);
		SimpleDateFormat df = new SimpleDateFormat(afterFormat);
		return df.format(toDate);
	}

	/**
	 * ��¥ ���� ���� ������ : converDateString(String date, afterFormat)
	 * 
	 * @param date
	 * @param afterFormat
	 * @return String
	 */
	public static String convertFormat(Date date, String afterFormat) {
		SimpleDateFormat df = new SimpleDateFormat(afterFormat);
		return df.format(date);
	}

	/**
	 * <code>java.util.Date</code> ���� <code>java.lang.String</code>���� ��¥ ���� ����
	 * 
	 * @param date
	 * @param afterFormat
	 * @return String
	 */
	private static String convertFormatDateToString(Date date,
			String afterFormat) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat(afterFormat);

		return df.format(calendar.getTime());
	}

	/**
	 * ��¥ ���� ����
	 * 
	 * @param date
	 * @param beforeFormat
	 * @return java.util.Date
	 */
	public static Date convertFormatDate(Date date, String beforeFormat) {
		String toString = convertFormatDateToString(date, beforeFormat);
		return convertStringToDate(toString, beforeFormat);
	}

	/**
	 * <code>java.util.Date</code> ���� <code>java.lang.String</code>���� ��¥ ���� ����
	 * 
	 * @param date
	 * @param afterFormat
	 * @return String
	 */
	// public static String convertFormatString(String date, String afterFormat)
	// {
	// Date toDate = convertStringToDate(date, afterFormat);
	// SimpleDateFormat df = new SimpleDateFormat();
	// return df.format(toDate);
	// }

	/**
	 * format������ String����Ÿ�� java.util.Date�� ��ȯ
	 * 
	 * @param strDate
	 *            : �������� �Ǵ� date
	 * @param format
	 *            : String�� ����
	 * @return java.util.Date
	 */
	public static Date convertStringToDate(String strDate, String format) {
		if (strDate == null || strDate.length() == 0) {
			return null;
		}
		// if (strDate.length() != format.length()) {
		// return null;
		// }
		try {
			SimpleDateFormat fmt = new SimpleDateFormat(format);
			return fmt.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �⺻format������ String����Ÿ�� java.util.Date�� ��ȯ
	 * 
	 * @param strDate
	 *            : �������� �Ǵ� date
	 * @return java.util.Date
	 */
	public static Date convertStringToDate(String strDate) {
		if (strDate == null || strDate.isEmpty()) {
			return null;
		}
		try {
			SimpleDateFormat fmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			return fmt.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <code>java.util.Date</code>�� ����Ÿ�� format�� �°�
	 * <code>java.lang.String</code>���� ��ȯ
	 * 
	 * @param date
	 *            �������� �Ǵ� date
	 * @param format
	 *            String�� ����
	 * @return
	 */
	public static String convertDateToString(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * �Է��� ��¥�� ���ó�¥ ���� ������¥���� ���� (���ó�¥ ���� ����)
	 * 
	 * @param date
	 *            ��¥
	 * @return ����
	 */
	public static boolean isBeforeDate(Date date) {
		String currentDate = getCurrentDateString(DEFAULT_DATE_FORMAT);
		String compareDate = convertDateToString(date, DEFAULT_DATE_FORMAT);
		int compare = currentDate.compareTo(compareDate);
		if (compare > 0)
			return true;
		return false;
	}

	public static boolean isBeforeDate(String compareDate) {
		String currentDate = getCurrentDateString(DEFAULT_DATE_FORMAT);
		int compare = currentDate.compareTo(compareDate);
		if (compare > 0)
			return true;
		return false;
	}

	/**
	 * �������ڸ� �������� �񱳴�����ڰ� ���� �������� ���� (���ó�¥ ���� ����)
	 * 
	 * @param baseDate
	 *            ��������
	 * @param compareDate
	 *            �񱳴�� ����
	 * @return ���� ���� ����
	 */
	public static boolean isBeforeDate(Date baseDate, Date compareDate) {
		int compareResult = compareDate(baseDate, compareDate);
		return compareResult > 0 ? true : false;
	}

	/**
	 * �������ڸ� �������� �񱳴�����ڰ� ���� �������� ���� (���ó�¥ ���� ����)
	 * 
	 * @param baseDate
	 *            ��������
	 * @param compareDate
	 *            �񱳴�� ����
	 * @return ���� ���� ����
	 */
	public static boolean isBeforeDate(String baseDate, String compareDate) {
		int compareResult = compareDate(baseDate, compareDate);
		return compareResult > 0 ? true : false;
	}

	/**
	 * �Է��� ��¥�� ���ó�¥ ���� ���� ��¥���� ���� (���ó�¥ ���� ����)
	 * 
	 * @param date
	 *            ��¥
	 * @return ����
	 */
	public static boolean isAfterDate(Date date) {
		String currentDate = getCurrentDateString(DEFAULT_DATE_FORMAT);
		String compareDate = convertDateToString(date, DEFAULT_DATE_FORMAT);
		int compare = currentDate.compareTo(compareDate);
		if (compare < 0)
			return true;
		return false;
	}

	/**
	 * �Է��� ��¥�� ���ó�¥ ���� ���� ��¥���� ���� (���ó�¥ ���� ����)
	 * 
	 * @param date
	 *            ��¥
	 * @return ����
	 */
	public static boolean isAfterDate(String date) {
		String currentDate = getCurrentDateString(DEFAULT_DATE_FORMAT);
		int compare = currentDate.compareTo(date);
		if (compare < 0)
			return true;
		return false;
	}

	/**
	 * ���ó�¥���� Ȯ��
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		String inputDate = convertDateToString(date, DEFAULT_DATE_FORMAT);
		return isToday(inputDate);
	}

	/**
	 * ���ó�¥���� Ȯ��
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(String date) {
		String systemDate = getCurrentDateString();
		return date.equals(systemDate) ? true : false;
	}

	/**
	 * �������ڸ� �������� �񱳴�����ڰ� ���� �������� ���� (���ó�¥ ���� ����)
	 * 
	 * @param baseDate
	 *            ��������
	 * @param compareDate
	 *            �񱳴�� ����
	 * @return ���� ���� ����
	 */
	public static boolean isAfterDate(Date baseDate, Date compareDate) {
		int compareResult = compareDate(baseDate, compareDate);
		return compareResult < 0 ? true : false;
	}

	/**
	 * �������ڸ� �������� �񱳴�����ڰ� ���� �������� ���� (���ó�¥ ���� ����)
	 * 
	 * @param baseDate
	 *            ��������
	 * @param compareDate
	 *            �񱳴�� ����
	 * @return ���� ���� ����
	 */
	public static boolean isAfterDate(String baseDate, String compareDate) {
		int compareResult = compareDate(baseDate, compareDate);
		return compareResult < 0 ? true : false;
	}

	/**
	 * �� ���ڸ� ���Ѵ�.
	 * 
	 * @param baseDate
	 *            ��������
	 * @param compareDate
	 *            ������
	 * @return ���� : 0, ���� �����̸� &gt;0, ���� �����̸� &lt;0
	 */
	public static int compareDate(Date baseDate, Date compareDate) {
		String standard = convertDateToString(baseDate, DEFAULT_DATE_FORMAT);
		String compare = convertDateToString(compareDate, DEFAULT_DATE_FORMAT);
		return standard.compareTo(compare);
	}

	/**
	 * �� ���ڸ� ���Ѵ�.
	 * 
	 * @param baseDate
	 *            ��������
	 * @param compareDate
	 *            ������
	 * @return ���� : 0, ���� �����̸� &gt;0, ���� �����̸� &lt;0
	 */
	public static int compareDate(String baseDate, String compareDate) {
		return baseDate.compareTo(compareDate);
	}

	/**
	 * ���������� �������ϸ��� ��ȸ�Ѵ�.
	 * <p>
	 * ������ : getDayStringOfWeek(String date)
	 * 
	 * @param dateString
	 * @return
	 */
	public static String getDayOfWeekEnglish(String dateString) {
		int dayOfWeek = getDayOfWeek(dateString);
		return DAY_OF_WEEKS_ENGLISH[dayOfWeek - 1];
	}

	/**
	 * ���������� �ѱۿ��ϸ��� ��ȸ�Ѵ�.
	 * <p>
	 * ������ : getDayStringOfWeek(String date)
	 * 
	 * @param dateString
	 * @return
	 */
	public static String getDayOfWeekKorean(String dateString) {
		int dayOfWeek = getDayOfWeek(dateString);
		return DAY_OF_WEEKS_KOREAN[dayOfWeek - 1];
	}

	/**
	 * ���������� ����� �ѱۿ��ϸ��� ��ȸ�Ѵ�.
	 * <p>
	 * ������ : getDayStringOfWeek(String date)
	 * 
	 * @param dateString
	 * @return
	 */
	public static String getDayOfWeekShortKorean(String dateString) {
		int dayOfWeek = getDayOfWeek(dateString);
		return DAY_OF_WEEKS_SHORT_KOREAN[dayOfWeek - 1];
	}

	/**
	 * ��¥�� ������ �����Ѵ�. "20080203(�Ͽ���) ==> 1 "20080209(�����) ==> 7
	 * 
	 * @param dateString
	 * @return
	 */
	public static int getDayOfWeek(String dateString) {
		int result = 0;
		Date date = convertStringToDate(dateString, DEFAULT_DATE_FORMAT);
		Calendar calendar = Calendar.getInstance(Locale.KOREAN);
		calendar.setTime(date);
		result = calendar.get(Calendar.DAY_OF_WEEK);

		return result;
	}

	/**
	 * �����Ͽ��� �����ϱ��� ������� ��ȸ
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getDateStrings(String startDate, String endDate) {
		List<String> dayList = new ArrayList<String>();
		int days = getBetweenDays(startDate, endDate, DEFAULT_DATE_FORMAT);
		for (int i = 0; i < days; i++) {
			dayList.add(addDate(startDate, i));
		}
		return dayList;
	}

	/**
	 * �����Ͽ��� �����ϱ��� ������� ��ȸ
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getDateIncludeLastDayStrings(String startDate,
			String endDate) {
		List<String> dayList = new ArrayList<String>();
		int days = getBetweenDays(startDate, endDate, DEFAULT_DATE_FORMAT);
		days++; // ���������� ����
		for (int i = 0; i < days; i++) {
			dayList.add(addDate(startDate, i));
		}
		return dayList;
	}

	/**
	 * Ư���Ⱓ�� Ư�� ���Ͽ� �ش��ϴ� ��¥ ��� ��ȸ
	 * 
	 * @param startDate
	 * @param endDate
	 * @param weekDays
	 * @return
	 */
	public static List<String> getDateStringsInWeekDays(String startDate,
			String endDate, int[] weekDays) {
		List<String> weekDayStrs = new ArrayList<String>();

		int dayCount = getBetweenDays(startDate, endDate);
		int startWeek = getDayOfWeek(startDate);

		for (int i = 0; i < dayCount; i++) {
			int dayWeek = (startWeek + i) % 7;
			if (dayWeek == 0)
				dayWeek = 7;
			for (int j = 0; j < weekDays.length; j++) {
				if (dayWeek == weekDays[j]) {
					weekDayStrs.add(DateU.addDate(startDate, i));
				}
			}
		}

		return weekDayStrs;
	}

	/**
	 * ��� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getYearMonth(Date date) {
		String dateStr = convertDateToString(date, DEFAULT_DATE_FORMAT);
		return Integer.parseInt(dateStr.substring(0, 6));
	}

	/**
	 * ���� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getYear(Date date) {
		return getYear(convertDateToString(date, DEFAULT_DATE_FORMAT));
	}

	/**
	 * ���� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getYear(String date) {
		return Integer.parseInt(date.substring(0, 4));
	}

	/**
	 * �� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getMonth(Date date) {
		return getMonth(convertDateToString(date, DEFAULT_DATE_FORMAT));
	}

	/**
	 * �� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getMonth(String date) {
		return Integer.parseInt(date.substring(4, 6));
	}

	/**
	 * �ϼ� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getDay(Date date) {
		return getDay(convertDateToString(date, DEFAULT_DATE_FORMAT));
	}

	/**
	 * �� ����
	 * 
	 * @param date
	 * @return int
	 */
	public static int getDay(String date) {
		return Integer.parseInt(date.substring(6));
	}

	/**
	 * ������ ��¥ ��
	 * 
	 * @param oneDate
	 * @param twoDate
	 * @return
	 */
	public static boolean isSameDate(Date oneDate, Date twoDate) {
		return oneDate.getTime() == twoDate.getTime() ? true : false;
	}

	/**
	 * ������ ��¥ ��
	 * 
	 * @param oneDate
	 * @param twoDate
	 * @return
	 */
	public static boolean isSameDate(String oneDate, String twoDate) {
		return oneDate.equals(twoDate);
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� �ϼ��� ���
	 * 
	 * @return ������ - ������
	 */
	public static int getBetweenDays(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("��������, �������ڴ� null�� �ƴϾ���մϴ�.");
		}

		long startTime = startDate.getTime();
		long endTime = endDate.getTime();

		int days = (int) (endTime / MILLISECOND_OF_DAY)
				- (int) (startTime / MILLISECOND_OF_DAY);

		return days;
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� �ϼ��� ��� ��¥ ������ null�� ��� �⺻ ����(yyyyMMdd)�� ������
	 * 
	 * @param startDate
	 *            ���۳�¥
	 * @param endDate
	 *            ���ᳯ¥
	 * @param dateFormat
	 *            ��¥����
	 * @return ������ - ������
	 */
	public static int getBetweenDays(String startDate, String endDate,
			String dateFormat) {
		int betweenDays = 0;
		if (dateFormat == null) {
			betweenDays = getBetweenDays(
					convertStringToDate(startDate, dateFormat),
					convertStringToDate(endDate, dateFormat));
		} else {
			betweenDays = getBetweenDays(
					convertStringToDate(startDate, dateFormat),
					convertStringToDate(endDate, dateFormat));
		}

		return betweenDays;
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� �ϼ��� ��� ��¥ ������ null�� ��� �⺻ ����(yyyyMMdd)�� ������
	 * 
	 * @param startDate
	 *            ���۳�¥
	 * @param endDate
	 *            ���ᳯ¥
	 * @return ������ - ������
	 */
	public static int getBetweenDays(String startDate, String endDate) {
		return getBetweenDays(startDate, endDate, DEFAULT_DATE_FORMAT);
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� ������ ���
	 * 
	 * @param startDate
	 * @param endDate
	 * @return ������ - ������
	 */
	public static int getBetweenMonths(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("��������, �������ڴ� null�� �ƴϾ���մϴ�.");
		}

		String startDateStr = convertDateToString(startDate,
				DEFAULT_DATE_FORMAT);
		String endDateStr = convertDateToString(endDate, DEFAULT_DATE_FORMAT);

		return getBetweenMonths(startDateStr, endDateStr);
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� ������ ���
	 * 
	 * @param startDate
	 * @param endDate
	 * @return ������ - ������
	 */
	public static int getBetweenMonths(String startDate, String endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("��������, �������ڴ� null�� �ƴϾ���մϴ�.");
		}

		// ��� ���
		int years = getBetweenYears(startDate, endDate);

		int startMonth = getMonth(startDate);
		int endMonth = getMonth(endDate);

		return (years * 12) + (endMonth - startMonth);
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� ����� ���
	 * 
	 * @return ������ - ������
	 */
	public static int getBetweenYears(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("��������, �������ڴ� null�� �ƴϾ���մϴ�.");
		}

		String startDateStr = convertDateToString(startDate,
				DEFAULT_DATE_FORMAT);
		String endDateStr = convertDateToString(endDate, DEFAULT_DATE_FORMAT);

		return getBetweenYears(startDateStr, endDateStr);
	}

	/**
	 * �����Ͻÿ� �����Ͻ��� ��¥ ���̸� ����� ���
	 * 
	 * @return ������ - ������
	 */
	public static int getBetweenYears(String startDate, String endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("��������, �������ڴ� null�� �ƴϾ���մϴ�.");
		}

		int startYear = getYear(startDate);
		int endYear = getYear(endDate);

		return endYear - startYear;
	}

	/**
	 * �ش��ϰ� ���ó�¥���� ��
	 * 
	 * @param date
	 * @param format
	 * @return ���� �������̸� 0���� �۰�, �����̸� 0, ���� �������̸� 0���� ŭ. �ش��� ������ �������� Ȥ�� �߸��� ��¥��
	 *         ��� Integer.MIN_VALUE ���� ����
	 */
	public static long compareWithToday(String date, String format) {
		// TODO �̵��� �����丵 ���
		if (date == null || date.trim().length() <= 0)
			return Integer.MIN_VALUE;
		if (format == null || format.trim().length() <= 0)
			return Integer.MIN_VALUE;

		Date comparedDate = convertStringToDate(date, format);
		if (comparedDate == null)
			return Integer.MIN_VALUE;

		Calendar nowCal = Calendar.getInstance();
		Calendar comparedCal = Calendar.getInstance();
		comparedCal.setTime(comparedDate);

		int yearDiff = comparedCal.get(Calendar.YEAR)
				- nowCal.get(Calendar.YEAR);
		int monDiff = comparedCal.get(Calendar.MONTH)
				- nowCal.get(Calendar.MONTH);
		int dayDiff = comparedCal.get(Calendar.DAY_OF_MONTH)
				- nowCal.get(Calendar.DAY_OF_MONTH);

		if (yearDiff == 0 && monDiff == 0 && dayDiff == 0)
			return 0;

		final int MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
		double dayUnitDiff = (comparedCal.getTimeInMillis() - nowCal
				.getTimeInMillis()) / (double) (MILLISECONDS_PER_DAY);

		return (long) dayUnitDiff;
	}

	/**
	 * �ش��ϰ� Ư����¥���� ��
	 * 
	 * @param date
	 * @param format
	 * @return Ư���� �������̸� 0���� �۰�, Ư�����̸� 0, Ư���� �������̸� 0���� ŭ. �ش��� ������ �������� Ȥ�� �߸���
	 *         ��¥�� ��� Integer.MIN_VALUE ���� ����
	 */
	public static long compareWithAnotherDay(String date, String format,
			String anotherDay, String anotherFormat) {
		// TODO �̵��� �����丵 ���
		if (date == null || date.trim().length() <= 0)
			return Integer.MIN_VALUE;
		if (format == null || format.trim().length() <= 0)
			return Integer.MIN_VALUE;

		Date comparedDate = convertStringToDate(date, format);
		if (comparedDate == null)
			return Integer.MIN_VALUE;
		Date anotherDate = convertStringToDate(anotherDay, anotherFormat);

		Calendar anotherCal = Calendar.getInstance();
		anotherCal.setTime(anotherDate);
		Calendar comparedCal = Calendar.getInstance();
		comparedCal.setTime(comparedDate);

		int yearDiff = comparedCal.get(Calendar.YEAR)
				- anotherCal.get(Calendar.YEAR);
		int monDiff = comparedCal.get(Calendar.MONTH)
				- anotherCal.get(Calendar.MONTH);
		int dayDiff = comparedCal.get(Calendar.DAY_OF_MONTH)
				- anotherCal.get(Calendar.DAY_OF_MONTH);

		if (yearDiff == 0 && monDiff == 0 && dayDiff == 0)
			return 0;

		double dayUnitDiff = (comparedCal.getTimeInMillis() - anotherCal
				.getTimeInMillis()) / (double) (MILLISECOND_OF_DAY);

		return (long) dayUnitDiff;
	}

	/**
	 * ��¥ �߰�
	 * 
	 * @param date
	 * @param y
	 *            �߰��� ��
	 * @param m
	 *            �߰��� ��
	 * @param d
	 *            �߰��� ��
	 * @return
	 */
	public static String addDate(String date, int nYears, int nMonths, int nDays) {
		String toDate = new String();
		toDate = addDate(date, nDays);
		toDate = addMonth(toDate, nMonths);
		toDate = addYear(toDate, nYears);

		return toDate;
	}

	/**
	 * �ð� ��<br/>
	 * preTimeFmt ������ preTimeOperand �ð����� postTimeFmt ������ postTimeOperand �ð��� ��.
	 * 
	 * @param preTimeOperand
	 * @param preTimeFmt
	 * @param postTimeOperand
	 * @param postTimeFmt
	 * @return 0���� ũ�� preTimeOperand �ð��� ũ��, 0�� ������ �ð��� ����
	 */
	public static long compareStringTime(String preTimeOperand,
			String preTimeFmt, String postTimeOperand, String postTimeFmt) {
		// TODO �̵��� �����丵
		Date preTimeDate = null;
		Date postTimeDate = null;
		if (preTimeFmt.equals(postTimeFmt)) {
			SimpleDateFormat format = new SimpleDateFormat(preTimeFmt);
			try {
				preTimeDate = format.parse(preTimeOperand);
				postTimeDate = format.parse(postTimeOperand);
			} catch (ParseException e) {
			}
		} else {
			SimpleDateFormat preFormat = new SimpleDateFormat(preTimeFmt);
			SimpleDateFormat postFormat = new SimpleDateFormat(postTimeFmt);
			try {
				preTimeDate = preFormat.parse(preTimeOperand);
				postTimeDate = postFormat.parse(postTimeOperand);
			} catch (ParseException e) {
			}
		}

		return preTimeDate.getTime() - postTimeDate.getTime();
	}

	/**
	 * �ð��� ���� ���̸� translatedFmt ������ ���ڿ��� ��ȯ
	 * 
	 * @param preTimeOperand
	 * @param preTimeFmt
	 * @param postTimeOperand
	 * @param postTimeFmt
	 * @param translatedFmt
	 * @return
	 */
	public static String compareStringTime(String preTimeOperand,
			String preTimeFmt, String postTimeOperand, String postTimeFmt,
			String translatedFmt) {
		long timeDiff = compareStringTime(preTimeOperand, preTimeFmt,
				postTimeOperand, postTimeFmt);
		Calendar cal = Calendar.getInstance();
		cal.set(1, 1, 1, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, (int) timeDiff);

		SimpleDateFormat preFormat = new SimpleDateFormat(translatedFmt);
		return preFormat.format(cal.getTime());
	}

	/**
	 * Ư���Ͻÿ� ���ϴ� �� �� ���� data String�� �����Ѵ�. ex) 20040803123212�Ͽ��� 30�� ������ ������
	 * addTime("20040803123212","yyyyMMddHHmmss",-30), 30�� �ķ� ������
	 * addTime("20040803123212","yyyyMMddHHmmss",30)
	 * 
	 * @param date
	 *            �Ͻú���
	 * @param pattern
	 *            ����
	 * @param amount
	 *            ���ϰ��� �ϴ� ��
	 * @return
	 */
	public static String addMinute(String date, String pattern, int amount) {
		String strArithmeticDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date aDate = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(aDate);

			calendar.add(Calendar.MINUTE, amount);
			Date newDate = calendar.getTime();
			strArithmeticDate = sdf.format(newDate);

		} catch (Exception e) {

		}
		return strArithmeticDate;

	}

	/**
	 * �ش� �ð��� ���� �ð����� ��
	 * 
	 * @param time
	 * @param format
	 * @return �ð� ����(��), ����ð� �����̸� 0���� �۰�, ����ð� �����̸� 0���� ŭ.
	 */
	public static int compareWithTodayTime(String time, String format) {
		if (time == null || time.trim().length() <= 0)
			return Integer.MIN_VALUE;
		if (format == null || format.trim().length() <= 0)
			return Integer.MIN_VALUE;

		Date comparedTime = convertStringToDate(time, format);
		if (comparedTime == null)
			return Integer.MIN_VALUE;

		Calendar comparedCal = Calendar.getInstance();
		comparedCal.setTime(comparedTime);

		Calendar nowCal = Calendar.getInstance();

		int timeDiff = 0;

		int comparedHour = comparedCal.get(Calendar.HOUR_OF_DAY);
		int nowHour = nowCal.get(Calendar.HOUR_OF_DAY);
		timeDiff += (comparedHour - nowHour) * 60;

		int comparedMin = comparedCal.get(Calendar.MINUTE);
		int nowMin = nowCal.get(Calendar.MINUTE);
		timeDiff += (comparedMin - nowMin);

		return timeDiff;
	}

	/**
	 * �������ڿ��� �������ڱ����� �������� ��ȯ�Ѵ�.
	 * <p>
	 * ���ο��� {@link #getProgressMonths(Date, Date, boolean)
	 * getProgressMonths(startDate, endDate, true)}�� ȣ���Ͽ� �Ѱ�������� ���ѵ� 12�� ��������
	 * �������� �����Ͽ� ��ȯ�Ѵ�.
	 * 
	 * @param startDate
	 *            ��������
	 * @param endDate
	 *            ��������
	 * @return ������
	 * @author �Ӻ���
	 * @see #getProgressMonths(Date, Date, boolean)
	 */
	public static int getProgressYears(Date startDate, Date endDate) {
		int progressMonths = getProgressMonths(startDate, endDate, true);
		int progressYears = progressMonths / 12;
		return progressYears;
	}

	/**
	 * �������ڿ��� �������ڱ����� ��������� ��ȯ�Ѵ�.
	 * <p>
	 * ������� ����
	 * 
	 * <pre>
	 * startYear, startMonth, startDay // ���۳�,��,��
	 * endYear, endMonth, endDay //�����,��,��
	 * 
	 * ������� = (endYear - startYear) * 12 + (endMonth - startMonth)
	 * if((startDay > endDay ) && (�������� != ������)) {
	 *     ������� = ������� - 1;
	 * }
	 * 
	 * if((���Ѵ� ��� üũ���� != true) && (�������� <= ��������)) {
	 *     ������� = ������� + 1;
	 * }
	 * </pre>
	 * 
	 * ���� ��� �������ڰ� "1999-10-31"�̰� �������ڰ� "2000-03-30"�̸�
	 * 
	 * <pre>
	 * startYear = 1999, startMonth = 10, startDay  = 31
	 * endYear = 2000, endMonth = 3, endDay = 30
	 * 
	 * ������� = (2000 - 1999) * 12 + (3 - 10) = 1*12 - 7 = 5
	 * </pre>
	 * 
	 * �̰� �������� �����Ϻ��� �۰�(30 < 31) �������ڰ� �����ڰ� �ƴϹǷ�(2000-03-30 != 2000-03-31) ���������
	 * ���Ѵް�� üũ���ΰ� true�ΰ��� 4����, �ƴѰ��� 5������ �ȴ�.
	 * <p>
	 * ���Ѵް�� üũ���� = false�ΰ��
	 * 
	 * <pre>
	 *        ��������      ��������      �������  ���
	 *   =================================================
	 *   1.   2005-01-01   2005-07-02  7       �Ϲ�
	 *   2.   2005-01-31   2005-02-28  2       �����ڱ���
	 *   3.   2000-01-31   2000-02-28  1       ���޸����ڱ���
	 *   4.   2000-01-31   2000-02-29  2       ���޸����ڱ���
	 *   5.   2000-02-29   2000-03-28  1       ���޸����ڱ���
	 *   6.   2000-02-29   2000-03-29  2       ���޸����ڱ���
	 * </pre>
	 * 
	 * ���Ѵް�� üũ���� = true�ΰ��
	 * 
	 * <pre>
	 *        ��������      ��������      �������  ���
	 *   =================================================
	 *   1.   2005-01-01   2005-07-02  6       �Ϲ�
	 *   2.   2005-01-31   2005-02-28  1       �����ڱ���
	 *   3.   2000-01-31   2000-02-28  0       ���޸����ڱ���
	 *   4.   2000-01-31   2000-02-29  1       ���޸����ڱ���
	 *   5.   2000-02-29   2000-03-28  0       ���޸����ڱ���
	 *   6.   2000-02-29   2000-03-29  1       ���޸����ڱ���
	 * </pre>
	 * 
	 * @param startDate
	 *            ��������
	 * @param endDate
	 *            ��������
	 * @param isFull
	 *            ���Ѵ� ��� üũ����
	 * @return �������
	 */
	public static int getProgressMonths(Date startDate, Date endDate,
			boolean isFull) {
		int progressMonths = 0;

		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		if (startTime < endTime) {
			Calendar calendar = Calendar.getInstance();

			calendar.setTime(startDate);
			int startYear = calendar.get(Calendar.YEAR);
			int startMonth = calendar.get(Calendar.MONTH);
			int startDay = calendar.get(Calendar.DATE);
			boolean isLastDayOfStartDate = (startDay == calendar
					.getActualMaximum(Calendar.DATE));

			calendar.setTime(endDate);
			int endYear = calendar.get(Calendar.YEAR);
			int endMonth = calendar.get(Calendar.MONTH);
			int endDay = calendar.get(Calendar.DATE);
			boolean isLastDayOfEndDate = (endDay == calendar
					.getActualMaximum(Calendar.DATE));

			progressMonths = (endYear - startYear) * 12
					+ (endMonth - startMonth);

			// 2003-02-28 ~ 2004-02-28 ������ �������� ����. Modified by �Ӻ��� :
			// 2006.09.07
			// �������� �����Ϻ��� ũ�� �������ڰ� �����ڰ� �ƴϸ鼭 �������� �Ǵ� �������ڰ� �����ڰ� �ƴϸ� 1������ ����.
			if (((startDay > endDay) && !isLastDayOfEndDate)
					&& (!isLastDayOfStartDate || !isLastDayOfEndDate)) {
				progressMonths--;
			}
		}

		// ����������� ���ϴ°� �ƴϰ� �������ڰ� �������ں��� �۰ų� ���� ��� �Ѵ��� �߰��Ѵ�.
		if (!isFull && (startTime <= endTime)) {
			progressMonths++;
		}

		return progressMonths;
	}

	/**
	 * �������� ���Ѵ�. 20080104 (�ݿ���) ==> 1 20080107 (������) ==> 2
	 * 
	 * @param dateString
	 * @return
	 */
	public static int getWeekOfYear(String dateString) {
		int result = 0;
		Date date = convertStringToDate(dateString, DEFAULT_DATE_FORMAT);
		Calendar calendar = Calendar.getInstance(Locale.KOREAN);
		calendar.setTime(date);
		result = calendar.get(Calendar.WEEK_OF_YEAR);

		return result;
	}

	/**
	 * �ش�⵵�� ���ϴ� ���س�¥�� ���� ������/������ �����Ѵ�.
	 * 
	 * @param year
	 *            ���ϰ����ϴ� �ش�⵵
	 * @param baseDate
	 *            ���س�¥
	 * @return
	 */
	public static String getSameWeekDate(String year, String baseDate) {
		int degree = DateU.getWeekOfYear(baseDate);
		int dayOfWeek = DateU.getDayOfWeek(baseDate);
		String firstDate = year + "0101";
		int baseDateDayOfWeek = DateU.getDayOfWeek(firstDate);
		String firstSaturday = DateU.addDate(firstDate, Calendar.SATURDAY
				- baseDateDayOfWeek);
		// ������ ����
		String degreeSaturday = DateU.addDate(firstSaturday, (degree - 1) * 7);
		// �ش���ϳ�¥ ���ϱ�
		String result = DateU.addDate(degreeSaturday,
				-(Calendar.SATURDAY - dayOfWeek));
		return result;
	}

	/**
	 * �ش糯¥�� ���� ù���� �����Ѵ�. ex)20081229�� ������ 20080101�� �����Ѵ�.
	 * 
	 * @author �ֿ���
	 * @since 2008.12.29
	 * @param dateString
	 *            �ش糯¥
	 * @param dateFormat
	 *            �ش�����
	 * @return �ش糯¥�� ���� ù��
	 * @throws ParseException
	 *             date ��ȯ ����
	 */
	public static String getYearFirstDate(String dateString, String dateFormat)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = format.parse(dateString);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);

		Date resultDate = cal.getTime();
		return format.format(resultDate);
	}

	/**
	 * �ش糯¥�� �б� ù���� �����Ѵ�.<br>
	 * ex)<br>
	 * 20081229�� ������ 20081001�� �����Ѵ�.<br>
	 * 20080811�� ������ 20080701�� �����Ѵ�.
	 * 
	 * @author �ֿ���
	 * @since 2008.12.29
	 * @param dateString
	 *            �ش糯¥
	 * @param dateFormat
	 *            �ش�����
	 * @return �ش糯¥�� �б� ù��
	 * @throws ParseException
	 *             date ��ȯ ����
	 */
	public static String getQuarterYearDate(String dateString, String dateFormat)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = format.parse(dateString);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		int month = cal.get(Calendar.MONTH) / 3 * 3;

		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);

		Date resultDate = cal.getTime();
		return format.format(resultDate);
	}

	/**
	 * �ش糯¥�� ���� 1���� �����Ѵ�.<br>
	 * 20081229�� ������ 20081201�� �����Ѵ�.
	 * 
	 * @author �ֿ���
	 * @since 2008.12.29
	 * @param dateString
	 *            �ش糯¥
	 * @param dateFormat
	 *            �ش�����
	 * @return �ش糯¥�� ���� 1��
	 * @throws ParseException
	 *             date ��ȯ ����
	 */
	public static String getMonthFirstDate(String dateString, String dateFormat)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = format.parse(dateString);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		cal.set(Calendar.DATE, 1);

		Date resultDate = cal.getTime();
		return format.format(resultDate);
	}

	/**
	 * �ش糯¥(�⺻����yyyyMMdd)�� ���� ������ �����Ѵ�.<br>
	 * 
	 * @author �̵���
	 * @since 2009.01.17
	 * @param baseDate
	 *            ������(20080106)
	 * @return �ش糯¥�� ���� ���� (��:31)
	 */
	public static String getMonthLastDate(String baseDate) {
		String baseDateInLastDay = setLastDayByYearMonth(baseDate);
		return baseDateInLastDay.substring(6, 8);
	}
}