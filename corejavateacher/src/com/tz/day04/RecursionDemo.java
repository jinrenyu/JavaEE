package com.tz.day04;

public class RecursionDemo
{
	public static void main(String[] args)
	{
		int m = 1;
		int n = 1;
		for(int i = 0;i < 10;i++)
		{
			if(i == 0 || i == 1)
			{
				System.out.println(m);
			}else
			{
				int temp = m + n;
				System.out.println(temp);
				n = m;
				m = temp;
			}
		}
		
		System.out.println(feiBo(5));
		
		//打印杨辉三角
		for(int i = 0;i < 5;i++){
			for(int j = 0;j < i + 1;j++){
				System.out.print(yang(i,j) + " ");
			}
			System.out.println();
		}
		
		//递归求阶乘
		System.out.println(jie(16));
	}
	
	public static int jie(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		return n * jie(n - 1);
	}

	public static int yang(int i, int j)
	{
		//递归的退出条件
		if(j == 0 || i == j){
			return 1;
		}
		return yang(i - 1,j) + yang(i - 1,j - 1);
	}

	public static int feiBo(int n)
	{
		//递归的退出条件
		if(n == 1 || n == 2)
		{
			return 1;
		}
		return feiBo(n - 2) + feiBo(n - 1);
	}
}
