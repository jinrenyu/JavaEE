package com.tz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
	/*
	 * 根据指定的年月日获取Date对象
	 */
	public static Date setDate(int year, int month, int date)
	{
		//创建Calendar对象
		Calendar ca = Calendar.getInstance();
		//将年月日设置到Calendar对象中
		ca.set(year, month - 1, date);
		//将Calendar对象转换成Date对象并返回
		return ca.getTime();
	}
	
	/*
	 * 将指定的Date对象按照指定的格式格式化
	 */
	public static String formatDate(Date date, String pattern)
	{
		//创建SimpleDateFormat对象
		SimpleDateFormat sdf = 
				new SimpleDateFormat(pattern);
		//将Date对象转换成String并返回
		return sdf.format(date);
	}
	
	/*
	 * 将指定的字符串按照指定的格式转换成Date对象
	 */
	public static Date parseDate(String source, String pattern)
	{
		//创建SimpleDateFormat对象
		SimpleDateFormat sdf = 
				new SimpleDateFormat(pattern);
		//将字符串转换成Date对象并返回
		try
		{
			return sdf.parse(source);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
