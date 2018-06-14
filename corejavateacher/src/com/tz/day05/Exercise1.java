package com.tz.day05;

/*
 * n = 3
 * 1 1 1 1 1
 * 1 2 2 2 1
 * 1 2 3 2 1
 * 1 2 2 2 1
 * 1 1 1 1 1
 * 
 * n = 4
 * 1 1 1 1 1 1 1
 * 1 2 2 2 2 2 1
 * 1 2 3 3 3 2 1
 * 1 2 3 4 3 2 1
 * 1 2 3 3 3 2 1 
 * 1 2 2 2 2 2 1
 * 1 1 1 1 1 1 1
 */
public class Exercise1
{
	public static void main(String[] args)
	{
		int n = 5;
		//创建二维数组
		int[][] arr = new int[2 * n - 1][2 * n - 1];
		
		for (int k = 0; k < n; k++)
		{
			for (int i = k; i < arr.length - k; i++)
			{
				for (int j = k; j < arr[i].length - k; j++)
				{
					arr[i][j] = k + 1;
				}
			}
		}
		
		/*for (int i = 1; i < arr.length - 1; i++)
		{
			for (int j = 1; j < arr[i].length - 1; j++)
			{
				arr[i][j] = 2;
			}
		}
		
		for (int i = 2; i < arr.length - 2; i++)
		{
			for (int j = 2; j < arr[i].length - 2; j++)
			{
				arr[i][j] = 3;
			}
		}
		
		for (int i = 3; i < arr.length - 3; i++)
		{
			for (int j = 3; j < arr[i].length - 3; j++)
			{
				arr[i][j] = 4;
			}
		}*/
		
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
