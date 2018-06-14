package com.tz.day05.homework;

import java.util.Arrays;

import org.junit.Test;

import com.tz.day05.ArrayDemo1;

public class NoRepeat
{
	ArrayDemo1 demo = new ArrayDemo1();
	
	@Test
	public void test()
	{
		int[] arr = new int[10];
		//给数组元素赋值
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 10 + 1);
		}
//		arr = new int[]{1,1,1,2,2,2};
		System.out.println(Arrays.toString(arr));
//		arr = noReaptByIndex(arr);
		arr = noRepeatByEle(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 根据下标删除的方式排重
	 */
	public int[] noReaptByIndex(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] ==arr[j])
				{
					arr = demo.deleteElementByIndex(arr, j);
					j--;
				}
			}
		}
		return arr;
	}
	
	/*
	 * 根据元素删除的方式排重
	 */
	public int[] noRepeatByEle(int[] arr)
	{
		//定义一个数组,长度为arr.length
		int[] noRepeat = new int[arr.length];
		int index = 0;
		while(arr.length != 0)
		{
			noRepeat[index++] = arr[0];
			arr = demo.deleteElementByEle(arr, arr[0]);
		}
		noRepeat = Arrays.copyOf(noRepeat, index);
		
		return noRepeat;
	}
	
	
}
