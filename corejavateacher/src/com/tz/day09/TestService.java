package com.tz.day09;

import java.util.Date;

import org.junit.Test;

public class TestService
{
	@Test
	public void test()
	{
		Service s = new Service();
		TimePrint time = new SimpleDatePrint();
		s.service(time,new Date());
	}
}
