package com.tz.day03;

import java.util.Scanner;

/*
 * 输入一个数字n,打印
 * n层*
 * 			*
 * 			**
 * 			***
 * 			****
 */
public class Exercise1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入层数>");
		int n = sc.nextInt();
		sc.close();
		test1(n);
	}
	
	/*
	 * 		*
	 * 		**
	 * 		***
	 * 		****
	 * 		*****
	 */
	public static void test1(int n)
	{
		for(int i = 0;i < n;i++)
		{
			for(int j = 0;j < i + 1;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	/*
	 * 			*
	 * 		   **
	 * 		  ***
	 * 		 ****
	 */
	public static void test2(int n)
	{
		
	}
}
