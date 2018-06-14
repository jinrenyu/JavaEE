																package com.tz.day11;

import org.junit.Test;

import com.tz.util.StringUtil;

public class TestStringUtil
{
	@Test
	public void test()
	{
		System.out.println(StringUtil.reverse("12345"));
		System.out.println(StringUtil.isWord("abc_123"));
		System.out.println(StringUtil.isDigit("123456"));
		System.out.println(StringUtil.isBlank(" \t"));
		System.out.println(StringUtil.repeat("abc", 5));
		System.out.println(StringUtil.countMatches(StringUtil.repeat("abc", 5), "bca"));
	}
}
