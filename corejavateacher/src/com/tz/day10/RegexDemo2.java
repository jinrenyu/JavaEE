package com.tz.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexDemo2
{
	@Test
	public void test()
	{
		String str = "asklcsiv123456abnksjcsdg产生的接口vfe";
		String regex = "[a-zA-Z]+";
		
		//使用Pattern类的matches方法对字符串和正则做匹配
		//matches方法中的参数,第一个表示正则,第二个是要匹配的字符串
		System.out.println(Pattern.matches(regex, str));
		
		//将指定的正则表达式编译到模板中
		Pattern p = Pattern.compile(regex);
		
		//由Pattern对象创建Matcher对象
		//将要匹配的字符串传如到匹配器中
		Matcher m = p.matcher(str);
		
		//调用匹配器的精确匹配
//		System.out.println(m.matches());
		
		//模糊匹配会先找到字符串中匹配的一部分
		while(m.find())
		{
			System.out.println(m.start());
			System.out.println(m.group());
			System.out.println(m.end());
			System.out.println("------------");
		}
	}
}
