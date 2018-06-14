package com.tz.day18;

import org.junit.Assert;
import org.junit.Test;

public class DemoConfigTest
{
	@Test
	public void testGet() {
		//
		String value = DemoConfig.get("key1");
		//做断言
//		Assert.assertEquals("今天天气不错", value);
		//
		System.out.println(value);
	}
}
