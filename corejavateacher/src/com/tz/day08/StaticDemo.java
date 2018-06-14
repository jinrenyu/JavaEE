package com.tz.day08;

import org.junit.Test;

public class StaticDemo
{
	
	private static int m;
	
	public static int num = 1000;

	private int n;
	
//	{
//		//代码块
//		n = 10;
//		System.out.println(n);
//	}
	
	/*
	 * 静态代码块只加载一次
	 */
	static 
	{
		//静态代码块
		m = 10;
		System.out.println(m);
	}
	
	public StaticDemo()
	{
		n = num++;
		System.out.println(n);
	}
	
	public int getN()
	{
		return n;
	}

	public void setN(int n)
	{
		this.n = n;
	}

	@Test
	public void test()
	{
//		System.out.println(num);
		show();
		StaticDemo s1 = new StaticDemo();//1001
		StaticDemo s2 = new StaticDemo();//1002
		
		System.out.println(s1.n);
		System.out.println(s2.n);
	}
	
	public static void show()
	{
		System.out.println(num);
	}
}
