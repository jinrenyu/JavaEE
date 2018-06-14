package com.tz.day05;

import java.util.Date;

import org.junit.Test;

import com.tz.util.DateUtil;

public class TestDateUtil
{
	@Test//注解
	public void testSetDate()
	{
		Date date = DateUtil.setDate(2008, 8, 8);
		System.out.println(date);
	}
	
	@Test
	public void testFormatDate()
	{
		String time = 
				DateUtil.formatDate(new Date(), "yyyy-MM-dd");
		System.out.println(time);
	}
	
	@Test
	public void testParseDate()
	{
		Date date = 
				DateUtil.parseDate("2017-3-6", "yyyy-MM-dd");
		System.out.println(date);
	}
}
