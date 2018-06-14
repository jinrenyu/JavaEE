package com.tz.day06;

import java.util.Arrays;

public class Demo
{
	public static void main(String[] args)
	{
		Person p = new Person();
		Person p1 = new Person();
		System.out.println(p);
		System.out.println(p1);
		
		int m = 10;
		int n = 5;
		add(m,n);
		System.out.println(m);//10
		System.out.println(n);//5
		
		int[] arr1 = new int[10];
		Arrays.fill(arr1, 1);
		int[] arr2 = new int[10];
		Arrays.fill(arr2, 2);
		
//		test1(arr1,arr2);
		test2(arr1,arr2);
		System.out.println(Arrays.toString(arr1));//1
		System.out.println(Arrays.toString(arr2));//2
	}
	
	public static void test2(int[] arr1,int[] arr2)
	{
		for (int i = 0; i < arr2.length; i++)
		{
			int temp = arr1[i];
			arr1[i] = arr2[i];
			arr2[i] = temp;
		}
	}
	
	public static void test1(int[] arr1,int[] arr2)
	{
		int[] temp = arr1;
		arr1 = arr2;
		arr2 = temp;
	}

	public static void add(int m, int n)
	{
		int temp = m;
		m = n;
		n = temp;
	}
}
