package com.tz.day03;

import java.util.Scanner;

/************
 * 本类用来演示java中的分支结构之if条件句
 * 
 * @author 吴老师
 *
 *         2017年3月3日下午2:18:47
 */
public class IfDemo
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入成绩>");
		int score = sc.nextInt();
		sc.close();
		// 1.if(条件)[{}]
		// if条件在没有写{}时候并且没有;,条件句后边的第一行就是if语句的内容
		if (score > 90)
		{
			System.out.println("优秀");
			System.out.println("小红花");
		}

		// 2.if(条件){...}else{....}
		if (score > 60)
		{
			System.out.println("及格");
		} else
		{
			System.out.println("不及格");
		}

		// 3.if(条件){...}else if(条件){...}...[else{...}]
		if (score > 90)
		{
			System.out.println("优秀");
		} else if (score > 80)
		{
			System.out.println("良好");
		} else if (score > 60)
		{
			System.out.println("及格");
		} else
		{
			System.out.println("不及格");
		}

		// 4.嵌套
		if (score > 100 || score < 0)
		{
			System.out.println("输入的成绩不合规则");
		} else
		{
			if (score > 90)
			{
				System.out.println("优秀");
			} else if (score > 80)
			{
				System.out.println("良好");
			} else if (score > 60)
			{
				System.out.println("及格");
			} else
			{
				System.out.println("不及格");
			}
		}

		if (test())
		{
			System.out.println("test()被调用了");
		}
	}

	public static boolean test()
	{
		return true;
	}

}
