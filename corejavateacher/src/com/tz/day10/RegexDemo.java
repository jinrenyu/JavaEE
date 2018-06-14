package com.tz.day10;

import org.junit.Test;

public class RegexDemo
{
	@Test
	public void test()
	{
		String regex = "[1-9]\\d{13}([\\dXx]|[\\d]{3}[\\dXx])";
		String str = "123456789123451235";
		System.out.println(str.matches(regex));
		
		String reg = "^\\d{4}:.{2,4}:\\w+:\\d{11}:\\w+([-+._]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String s = "1234:1a$*:abc_123:15062374125:abc_123+abc_123@abc_123-abc_123.abc_123.abc_123";
		System.out.println(s.matches(reg));
	}
}
