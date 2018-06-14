package com.tz.day05.homework;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class YueSeFu
{
	@Test
	public void test()
	{
		Scanner sc = new Scanner(System.in);
		//提示
		System.out.println("请输入小孩的数量>");
		//接收
		int m = sc.nextInt();
		System.out.println("请输入小孩退出的数字>");
		int n = sc.nextInt();
		//关闭
		sc.close();
		
		int[] childs = getChildren(m);
		int[] result = start(childs,n);
		System.out.println(Arrays.toString(result));
	}
	
	/*
	 * 初始化小孩编号
	 */
	public int[] getChildren(int num)
	{
		//根据小孩的数量定义数组
		int[] childs = new int[num];
		//给数组元素赋值
		for (int i = 0; i < childs.length; i++)
		{
			childs[i] = i + 1;
		}
		return childs;
	}
	
	public int[] start(int[] childs, int n)
	{
		//定义一个小孩退出顺序似的数组
		int[] result = new int[childs.length];
		//定义一个变量保存还在报数的小孩数量
		int length = childs.length;
		//定义一个自增长的变量
		int count = 0;
		//定义退出小孩编号数组的下标
		int index = 0;
		//定义一个变量,标记小孩退出的值
		int out_childs = 0;
		while(length != 0)
		{
			//遍历数组
			for (int i = 0; i < childs.length; i++)
			{
				//获取当前小孩的编号
				int num = childs[i];
				//判断小孩的编号是否为0
				if(num != 0)
				{
					count++;
				}
				//判断count与n的值是否相等
				if(count == n)
				{
					//将当前小孩的编号存放result数组中
					result[index] = num;
					index++;
					//让当前小孩的编号退出childs数组
					childs[i] = out_childs;
					//正在报数的小孩数量-1
					length--;
					//报数从新开始
					count = 0;
				}
			}
		}
		return result;
	}
}
