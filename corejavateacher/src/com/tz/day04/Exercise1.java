package com.tz.day04;

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
		System.out.println("-------------");
		test2(n);
		test3();
		test4();
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
		for(int i = 0;i < n;i++)
		{
//			for(int j = 0;j < n - i - 1;j++)
//			{
//				System.out.print("  ");
//			}
			for(int j = n - i - 1;j > 0;j--)
			{
				System.out.print("  ");
			}
			for(int j = 0;j < i + 1;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	/*
	 * 	1 * 8 + 1 = 9
	 * 	12 * 8 + 2 = 98
	 * 	123 * 8 + 3 = 987
	 * 	1234 * 8 + 4 = 9876
	 * 	..
	 * 	123456789 * 8 + 9 = 987654321
	 */
	public static void test3()
	{
		int n = 1;
		int m = 8;
		for(int i = 1;i <= 9;i++)
		{
			System.out.println(n + "*" + m + "+" + i + 
					"=" + (n * m + i));
			n = n * 10 + i + 1;
		}
	}
	
	/*
	 * 1 * 9 + 2 = 11
	 * 12 * 9 + 3 = 111
	 * 123 * 9 + 4 = 1111
	 * ....
	 * 12345678 * 9 + 9 = 111111111
	 */
	public static void test4()
	{
		int n = 1;
		int m = 9;
		for(int i = 2;i <= 9;i++)
		{
			System.out.println(n + "*" + m + "+" + i + 
					"=" + (n * m + i));
			n = n * 10 + i;
		}
	}
	
}
