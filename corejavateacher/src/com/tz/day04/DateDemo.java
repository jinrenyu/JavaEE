package com.tz.day04;

import java.util.Date;

/****************
 * 本类用来演示java中的时间处理
 * 	java.util.Date
 * @author 吴老师
 *
 * 2017年3月4日下午3:18:38
 */
public class DateDemo
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		//当前系统时间距1970年1月1日 00:00:00已有多少毫秒
		long time = System.currentTimeMillis();
		System.out.println(time);
		//以当前系统时间创建Date对象
		Date date = new Date();
		System.out.println(date);
		
		date.setYear(2000 - 1900);
		int year = date.getYear() + 1900;
		System.out.println(year);
		
		Date d = new Date(time);
		System.out.println(date.before(d));
		System.out.println(d.after(date));
		
		Date d1 = new Date(time);
		
		//比较两个时间是否相等
		System.out.println(d1.equals(d));
	}
}
