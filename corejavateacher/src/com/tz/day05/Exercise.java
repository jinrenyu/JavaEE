package com.tz.day05;

import java.util.Arrays;

import org.junit.Test;

/*
 * 随机数[1,100]给数组[10]赋值,求数组中的元素的最值
 * 平均值,输出最值时同时输出最值的下标
 */
public class Exercise
{
	@Test
	public void test()
	{
		//定义一个数组
		int[] arr = new int[10];
		//给数组元素赋值
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 100 + 1);
		}
		System.out.println(Arrays.toString(arr));
		//定义变量
		int max = 0;
		int min = 100;
		int sum = 0;
		//遍历数组
		for (int i = 0; i < arr.length; i++)
		{
			//判断最值
			if(max < arr[i])
			{
				max = arr[i];
			}
			if(min > arr[i])
			{
				min = arr[i];
			}
			//元素求和
			sum += arr[i];
		}
		for (int i = 0; i < arr.length; i++)
		{
			//对最值做判断
			if(arr[i] == max)
			{
				System.out.println("最大值是" + max + ",对应的下标是" + i);
			}
			if(min == arr[i])
			{
				System.out.println("最小值是" + min + ",对应的下标是" + i);
			}
		}
		System.out.println("平均值是" + (sum / arr.length));
	}
}
