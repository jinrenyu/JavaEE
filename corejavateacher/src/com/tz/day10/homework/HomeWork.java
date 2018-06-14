package com.tz.day10.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HomeWork
{
	
	static String str;
	
	static 
	{
		str = "The Associated Press won "
			+ "an award for its series on "
			+ "the profiling of Muslims by "
			+ "the New York Police "
			+ "Department.But for the first "
			+ "time since 1977 there was no prize "
			+ "for fiction.The Pulitzer panel "
			+ "praised the Patriot-News.";
	}
	
//	public HomeWork()
//	{
//		str = "";
//	}
	
	@Test
	public void test()
	{
		getNum();
		System.out.println("---------");
		getWord();
	}
	
	public void getNum()
	{
		//将一个正则编译到模板中
		Pattern p = Pattern.compile("\\d+");
		//获取匹配器
		Matcher m = p.matcher(str);
		//查找字符串中匹配的字符串
		while(m.find())
		{
			//获取查找到的序列
			System.out.println(m.group());
		}
	}
	
	public void getWord()
	{
		//将一个正则编译到模板中
		Pattern p = Pattern.compile("[a-zA-Z-]+");
		//获取匹配器
		Matcher m = p.matcher(str);
		int count = 0;
		//查找字符串中匹配的字符串
		while(m.find())
		{
			//获取查找到的序列
			System.out.println(m.group());
			count++;
		}
		System.out.println("共有" + count + "个单词");
	}
}
