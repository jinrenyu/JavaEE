package com.tz.day05;

import java.util.Arrays;

import org.junit.Test;

public class ArrayDemo
{
	@Test
	public void test()
	{
		int[] arr = new int[5];
		/*
		 * 定义数组时注意两点:
		 * 	1.确定数组存储元素的数据类型
		 * 	2.确定数组存储元素的个数
		 * 
		 * 数组在定义时,元素的值为类型的默认值
		 */
		System.out.println(Arrays.toString(arr));
//		int arr[] = new int[5];
		
		//获取数组中的元素个数,数组名.length(属性)
		int length = arr.length;
		System.out.println(length);
		
		/*
		 * 数组赋值
		 */
		//1.定义时赋值
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(nums.length);
//		int[] n = {1,2,3,4,5,6,1};
		
		//2.通过下标修改数组元素的值
		arr[0] = 1;
		//数组下标不存在时,会抛出数组下标越界异常
		//ArrayIndexOutOfBoundsException
//		arr[arr.length] = 1;
		
		//3.循环赋值
		for(int i  = 0;i < arr.length;i++)
		{
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		
		/*
		 * 遍历数组
		 */
		//1.通过下标一一获取
		int num = arr[0];
		System.out.println(num);
		System.out.println("-----");
		//2.for循环获取元素的值
		for(int i = 0;i < arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		//3.增强for循环获取元素的值
		/*
		 * for(变量定义:容器){}
		 * 增强for循环式只读的
		 */
		for(int i : arr)
		{
			System.out.println(i);
		}
		
		//15062374125
		int phone[] = {1,5,0,6,2,3,7,4}; 
		int[] ints = {0,1,2,3,4,5,6,7,0,4,1};
		for(int i : ints)
		{
			System.out.print(phone[i]);
		}
		System.out.println();
		
		//4.Arrays.toString(数组)
		System.out.println(Arrays.toString(arr));
		
		//5.自定义输出方法
		show(arr);
		
	}
	
	public void show(int[] arr)
	{
		String str = "[";
		for(int i = 0;i < arr.length;i++)
		{
			str += arr[i];
			if(i != arr.length - 1)
			{
				str += ", ";
			}
		}
		str += "]";
		System.out.println(str);
	}
}
