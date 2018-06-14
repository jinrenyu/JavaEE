package com.tz.day09;

import org.junit.Test;

public class TestUsb
{
	@Test
	public void test()
	{
		Usb mouse = new Mouse();
		mouse.connect();
	}
}
