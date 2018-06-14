package com.tz.day05;

import java.util.Arrays;

import org.junit.Test;

/*
 * 数组排序
 */
public class ArrayDemo2
{
	@Test
	public void test()
	{
		//定义一个数组
		int[] arr = new int[10];
		//给数组元素赋值
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		System.out.println(Arrays.toString(arr));
//		arr = sortMinToMax(arr);
		Arrays.sort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 将指定的数组按照由小到大排序,将排序后的结果返回
	 */
	public int[] sortMinToMax(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
