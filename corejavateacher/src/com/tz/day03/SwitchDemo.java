package com.tz.day03;

import java.util.Scanner;

public class SwitchDemo
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//提示
		System.out.println("请输入星期数>");
		//接收
		int week = sc.nextInt();
		
		/*
		 * switch(key){
		 * case value1 :
		 * 		//代码1
		 * 		[break;]
		 * case value2 :
		 *		//代码2
		 *		[break;]
		 * ...
		 * [default :]
		 * }
		 */
		switch(week){
		default :
			System.out.println("输入的数据不存在");
			break;
		case 1 :
			System.out.println("星期天");
			break;
		case 2 :
			System.out.println("星期一");
			break;
		case 3 :
			System.out.println("星期二");
			break;
		case 4 :
			System.out.println("星期三");
//			break;
			System.exit(0);//系统退出
		case 5 :
			System.out.println("星期四");
			break;
		case 6 :
			System.out.println("星期五");
			break;//退出当前层次的switch语句
		case 7 :
			System.out.println("星期六");
			break;
		}
		
		System.out.println("switch退出了");
		
		
		
		//关闭
		sc.close();
	}
}
