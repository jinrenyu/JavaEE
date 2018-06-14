package com.tz.day11;

import org.junit.Test;

@SuppressWarnings("unused")
public class IntegerDemo
{
	@Test
	public void test()
	{
		showInteger();
		CharacterDemo();
		BooleanDemo();
	}
	
	public void showInteger()
	{
		//将int类型转换成Integer类型
		Integer i = new Integer(123);
		//将数字字符串转换成Integer类型
		//传入的字符串不是数字时会抛出
		//NumberFormatException
		Integer i1 = new Integer("123");
		
		//把基本类型转换成包装类
		i = Integer.valueOf(123456);
		//把包装类型转换成基本类型
		int n = i.intValue();
		
		int m = i;//自动解箱
		Integer i2 = 10;//自动封箱
		
		//将数字类型的字符串转换成基本类型
		m = Integer.parseInt("123456");
	}
	
	public void CharacterDemo()
	{
		Character c = new Character('1');
		
		//判断字符是否是字母
		//  注:此处只要是一种语言的最基本组成单位都可以认为是字母
		System.out.println(Character.isLetter('丿'));
		
		//判断字符是否是数字
		System.out.println(Character.isDigit('1'));
		
		//判断字符是否是大写字母
		System.out.println(Character.isUpperCase('A'));
	
		//判断是否是空白
		System.out.println(Character.isWhitespace('\n'));
	}
	
	public void BooleanDemo()
	{
		Boolean b = new Boolean("1");
		System.out.println(b);
	}
}
