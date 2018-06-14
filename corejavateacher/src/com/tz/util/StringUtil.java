package com.tz.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
	// 反转
	public static String reverse(String src)
	{
		//创建一个StringBuilder对象
		StringBuilder builder = 
				new StringBuilder(src);
		//翻转后将结果返回
		return builder.reverse().toString();
	}
	
	//判断字符串是否是完整的单词
	public static boolean isWord(String src) 
	{
		//定义一个单词的正则
		String regex = "\\w+";
//		if(Pattern.matches(regex, src))
//		{
//			return true;
//		}
//		return false;
		return Pattern.matches(regex, src);
	}
	
	//判断是否是数字
	public static boolean isDigit(String src) 
	{
		return Pattern.matches("\\d+", src);
	}
	
	//判断是否是空白字符
	public static boolean isBlank(String src) 
	{
		return Pattern.matches("\\s+", src);
	}
	
	//返回重复的字符串
	public static String repeat(String src,int count) 
	{
		//创建一个StringBuilder对象
		StringBuilder builder = new StringBuilder();
		//循环count次
		for(int i = 0;i < count;i++)
		{
			builder.append(src);
		}
		return builder.toString();
	}
	
	//统计target在src中出现的次数.
	public static int countMatches(String src, String target) 
	{
		int count = 0;
		Pattern p = Pattern.compile(target);
		Matcher m = p.matcher(src);
		while(m.find())
		{
			count++;
		}
		return count;
	}
}
