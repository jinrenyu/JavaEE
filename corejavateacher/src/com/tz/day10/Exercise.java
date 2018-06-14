package com.tz.day10;

import java.util.Scanner;

import org.junit.Test;

/*
 * 通过控制台输入字符串,判断输入的字符串是否是QQ号
 */
public class Exercise
{
	@Test
	public void test()
	{
		Scanner sc = new Scanner(System.in);
		//提示
		System.out.println("请输入一个数字");
		String line = sc.nextLine();
		sc.close();
		String regex = "[1-9][0-9]{4,10}";
		if(line.matches(regex))
		{
			System.out.println(line + "是QQ号");
		}
		
		/*//判断字符串的位数是否符合[5,11]
		if(line.length() < 5 || line.length() > 11)
		{
			System.out.println("字符串的位数不符合QQ要求");
			return;
		}
		//判断第一个字符是否为0
		if(line.charAt(0) == '0')
		{
			System.out.println("字符串的第一位不能为0");
			return;
		}
		
		boolean flag = false;
		//判断字符串中字符是否全部为数字字符
		for (int i = 0; i < line.length(); i++)
		{
			//判断
			if(!(line.charAt(i) >= '0' && line.charAt(i) <= '9'))
			{
				System.out.println("字符串中包含非数字字符");
				flag = true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println(line + "是QQ号");
		}*/
	}
}
