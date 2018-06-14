package com.tz.day09;

import java.util.Date;

import com.tz.util.DateUtil;

public class SimpleDatePrint implements TimePrint
{

	@Override
	public void print(Date date)
	{
		System.out.println(DateUtil.formatDate(date, "yyyy-MM-dd"));
	}

}
