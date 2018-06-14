package com.tz.day05;

public class TwoArrayDemo
{
	public static void main(String[] args)
	{
		int[][] arr = new int[4][3];
		
		//给数组赋值
//		arr[0] = new int[]{1,2,3,4};
//		arr[1] = new int[]{1,2,3,4,5};
		
		//遍历赋值
		for (int i = 0; i < arr.length; i++)
		{
			//给不规则的二维数组中的数组赋值时,必须先确定数组的长度
//			arr[i] = new int[i + 1]; 
			for (int j = 0; j < arr[i].length; j++)
			{
				arr[i][j] = (int)(Math.random() * 10);
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
