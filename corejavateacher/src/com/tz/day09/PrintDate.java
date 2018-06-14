package com.tz.day09;

import java.util.Date;

public class PrintDate implements TimePrint
{

	@Override
	public void print(Date date)
	{
		System.out.println(date);
	}

}
