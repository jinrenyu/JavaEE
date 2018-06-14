package com.tz.day03;

public class ForDemo
{
	public static void main(String[] args)
	{
		/*
		 * for([表达式1];[条件判断];[表达式2]){}
		 * 表达式1:定义变量并赋初始值,只执行一次
		 * 条件判断:当结果为true时,执行循环体,否则就退出循环
		 * 表达式2:变量因子,本次循环与上一轮循环的变化
		 */
		for(int i = 0;i < 10;i++)
		{
			System.out.println("Hello Java!");
		}
		
		for(int i = 0;i < 5;i++){
			for(int j = 0;j < 5;j++){
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
	}
}
