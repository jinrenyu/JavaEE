package com.tz.day04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise2
{
	public static void main(String[] args)
	{
		Calendar cal = Calendar.getInstance();
		//设置年月日
		cal.set(1991, 1 - 1, 2);
		//将Calendar对象转换成Date对象
		Date birth = cal.getTime();
		//创建格式化对象,给定一个格式
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		//将Date对象格式化
		String birthday = sdf.format(birth);
		System.out.println(birthday);
	}
}
