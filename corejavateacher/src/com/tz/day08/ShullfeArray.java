package com.tz.day08;

import java.util.Arrays;

public class ShullfeArray
{
	public static void main(String[] args)
	{
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		//定义一个数组,保存随机的下标
		int[] indexs = new int[arr.length];
		while(true)
		{
			//给indexs赋值
			for (int i = 0; i < indexs.length; i++)
			{
				indexs[i] = (int)(Math.random() * arr.length);
				//验证随机数不重复
				for(int j = 0;j < i;j++)
				{
					if(indexs[i] == indexs[j])
					{
						i--;
						break;
					}
				}
			}
			//定义一个数组,保存打乱后的元素
			int num[] = new int[arr.length]; 
			for (int i = 0; i < indexs.length; i++)
			{
				num[i] = arr[indexs[i]];
			}
			//验证num和arr所有元素不是一一相等
			int count = 0;
			for (int i = 0; i < num.length; i++)
			{
				if(num[i] == arr[i])
				{
					count++;
				}
			}
			if(count != num.length)
			{
				System.out.println(Arrays.toString(num));
				break;
			}
		}
	}
}
