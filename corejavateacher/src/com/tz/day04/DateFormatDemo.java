package com.tz.day04;

import java.text.SimpleDateFormat;
import java.util.Date;

/*******
 * 本类用来演示java中的时间格式化
 * 	java.text.SimpleDateFormat
 * @author 吴老师
 *
 * 2017年3月4日下午4:05:38
 */
public class DateFormatDemo
{
	public static void main(String[] args)
	{
		//创建格式化对象,给定一个格式
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		//创建当前系统的Date对象
		Date date = new Date();
		//将Date对象格式化
		String time = sdf.format(date);
		System.out.println(time);
	}
}
