package com.tz.day04;

import java.util.Scanner;

/*
 * 猜数字
 * 随机数产生一个[1,100]之间的整数
 * 输入>请输入1~100之间的数字
 * 如果50猜大了,输出>猜大了,请输入1~50之间的数字
 * 如果25猜小了,输出>猜小了,请输入25~50之间的数字
 * 如果猜对了,输出>猜对了,一共猜了..次
 */
public class Exercise1_1
{
	public static void main(String[] args)
	{
		// 随机数产生一个整数
		int num = (int) (Math.random() * 100 + 1);
		// 创建Scanner对象
		Scanner sc = new Scanner(System.in);
		int max = 100;
		int min = 1;
		int count = 0;
		// 提示
		System.out.println("请输入" +min + "~" + max + "之间的整数");
		do
		{
			// 接收输入
			int n = sc.nextInt();
			count++;
			// 对n和num进行判断
			if (n > num)
			{
				max = n;
				System.out.println("猜大了,请输入" +min + "~" + max + "之间的整数");
			} else if (n < num)
			{
				min = n;
				System.out.println("猜小了,请输入" +min + "~" + max + "之间的整数");
			} else
			{
				System.out.println("猜对了,一共猜了的次数是" + count);
				break;
			}
		}while(true);
		//关闭
		sc.close();
	}
}
