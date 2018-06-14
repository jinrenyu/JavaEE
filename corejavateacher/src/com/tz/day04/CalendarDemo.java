package com.tz.day04;

import java.util.Calendar;
import java.util.Date;

/********
 * 本类用来演示java中日历类
 * 	java.util.Calendar
 * @author 吴老师
 *
 * 2017年3月4日下午3:33:47
 */
public class CalendarDemo
{
	public static void main(String[] args)
	{
		//创建Calendar对象
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		//设置cal对象中的年
		cal.set(Calendar.YEAR, 2018);
		
		//设置cal对象的月
		cal.set(Calendar.MONTH, 12 - 1);
		
		//设置cal对象中的年月日
		cal.set(2000, 3 - 1, 5);
		
		//获取cal对象的年
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		//获取cal对象的月,月份从0开始
		int month = cal.get(Calendar.MONTH);
		System.out.println(month);
		
		//获取cal对象中的日
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		//获取cal对象的时
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
		
		//把cal对象转换成Date对象
		Date date = cal.getTime();
		System.out.println(date);
		
		//把Date对象转换成Calendar对象
		cal.setTime(date);
	}
}
