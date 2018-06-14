package com.tz.day12;

import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

/*
 * 输入括号
 * 如果输入>	()	[]	{}	([]) {[()]}	()[]...
 * ([)] (]	)[	)(
 */
public class Exercise
{
	@Test
	public void test()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入括号>");
		String str = sc.nextLine();
		sc.close();
		//创建一个集合,模拟堆栈
		LinkedList<Character> stack = 
				new LinkedList<>();
		//遍历字符串
		for (int i = 0; i < str.length(); i++)
		{
			//获取当前的字符
			char c = str.charAt(i);
			//判断集合是否为空
			if(stack.isEmpty())
			{
				stack.push(c);
				continue;
			}
			//获取堆栈中的第一个元素
			char first = stack.peek();
			//判断集合中的第一个元素与当前元素是否匹配
			if((c == ')' && first == '(') || 
			   (c == ']' && first == '[') ||
			   (c == '}' && first == '{'))
			{
				//将堆栈中的第一个元素移除
				stack.pop();
			}else
			{
				stack.push(c);
			}
		}
		//判断堆栈是否为空
		if(stack.isEmpty())
		{
			System.out.println("匹配成功");
		}else
		{
			System.out.println("匹配失败");
		}
	}
}
