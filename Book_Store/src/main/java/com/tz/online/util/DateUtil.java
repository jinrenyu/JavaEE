package com.tz.online.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**日期工具类**/
public class DateUtil {

	public static Date parse(String sdate,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = sdf.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	public static String format(Date d,String pattern){
		return new SimpleDateFormat(pattern).format(d);
	}

	public static String createStrDate(String sdate){
		return sdate+" 00:00 AM";
	}
}
