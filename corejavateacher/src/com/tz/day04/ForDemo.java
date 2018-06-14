package com.tz.day04;

public class ForDemo
{
	public static void main(String[] args)
	{
		for(int i = 0;i < 5;i++)
		{
//			if(i == 3)
//			{
//				break;
//			}
			for(int j = 0;j < 5;j++)
			{
				if(j == 3){
//					break;//退出当前层次的循环
					continue;//结束此轮循环继续下一轮循环
				}
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
	}
}
