package com.tz.day05.homework;

import org.junit.Test;

public class Yang
{
	@Test
	public void test()
	{
		//定义一个二维数组
		int[][] arr = new int[5][];
		//给数组赋值
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = new int[i + 1];
			for (int j = 0; j < arr[i].length; j++)
			{
				//判断
				if(j == 0 || i == j)
				{
					arr[i][j] = 1;
				}else
				{
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
		}
		//遍历数组
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
