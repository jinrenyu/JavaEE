package com.tz.day11.homework;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Test;

public class HomeWork
{
	@Test
	public void test()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字>");
		String str = sc.nextLine();
		sc.close();
		//处理字符串,以(,)切割
		String[] strs = str.split(",");
		String regex = "\\d+";
		//定义一个标记位
		boolean flag = false;
		//遍历数组,判断数组中的元素是否都为数字
		for(String s : strs)
		{
			if(!Pattern.matches(regex, s))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("输入内容中包含非数字字符");
			return;
		}
		//将String数组转换成int数组
		int[] nums = new int[strs.length];
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = Integer.parseInt(strs[i]);
		}
		//对int数组排序
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				if(nums[i] > nums[j])
				{
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
