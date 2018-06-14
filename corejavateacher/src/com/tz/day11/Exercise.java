package com.tz.day11;

import org.junit.Test;

/* 判断一个字符串是否是回文 */
public class Exercise
{
	@Test
	public void test()
	{
		String str = "123455654321";
		//定义一个标记位
		boolean flag = false;
		//遍历字符串
		for (int i = 0; i < str.length() / 2; i++)
		{
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
			{
				flag = true;
				break;
			}
		}
		//判断
		if(flag)
		{
			System.out.println(str + "不是回文");
		}else
		{
			System.out.println(str + "是回文");
		}
	}
}
