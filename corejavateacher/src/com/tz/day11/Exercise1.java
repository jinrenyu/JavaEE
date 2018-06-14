package com.tz.day11;

import org.junit.Test;

public class Exercise1
{
	StringBuilder builder = new StringBuilder();
	
	@Test
	public void test()
	{
		builder.append("This is a log file,it was store at")
			   .append("\"d:\\Program File\\temp\" ")
			   .append("directory.the format of log file was:\n")
			   .append("20130509:Jack:M:1990-08-08");
	
		//获取两个字符串中的双引号的下标
		int first = builder.indexOf("\"");
		int second = builder.indexOf("\"", first + 1);
		
		//截取双引号只见到内容
		String path = builder.substring(first + 1, second);
		System.out.println(path);
		
		//截取第一个双引号之前的内容
		String str_1 = builder.substring(0, first);
		//将str_1的空格替换成#
		str_1 = str_1.replace(" ", "#");
		//截取第二个双引号之后的内容
		String str_2 = builder.substring(second + 1);
		//将str_2的空格替换成*
		str_2 = str_2.replace(" ", "*");
		
		System.out.println(str_1 + "\"" + path + "\"" + str_2);
	
		//找出\n的下标
		int index = builder.indexOf("\n");
		//截取index之后的内容
		String str = builder.substring(index + 1);
		System.out.println(str);	
		
		//以:切割str
		String[] strs = str.split(":");
		for(String s : strs)
		{
			System.out.println(s);
		}
	}
}
