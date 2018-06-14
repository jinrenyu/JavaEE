package com.tz.day03;

import java.util.Scanner;

/*
 * 输入月份和年份
 * 判断年份定义在方法中
 * 输出月份有多少天
 */
public class Exercise
{
	public static void main(String[] args)
	{
		//创建Scanner对象
		Scanner sc = new Scanner(System.in);
		//提示
		System.out.println("请输入月份>");
		//接受月份
		int month = sc.nextInt();
		System.out.println("请输入年份>");
		int year = sc.nextInt();
		//关闭
		sc.close();
		//判断月份
		if(month == 1 || month == 3 || month == 5
			|| month == 7 || month == 8 || month == 10
			|| month == 12){
			System.out.println(month + "月有31天");
		}else if(month == 4 || month == 6 || 
				month == 9 || month == 11){
			System.out.println(month + "月有30天");
		}else if(month == 2){
			//判断平年闰年
			if(panDuanYear(year)){
				System.out.println(month + "月有29天");
			}else{
				System.out.println(month + "月有28天");
			}
		}
	}
	
	public static boolean panDuanYear(int year){
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			//return返回方法执行后的结果,结束方法
			return true;
		}
		return false;
	}
}
