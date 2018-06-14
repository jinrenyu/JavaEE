package com.tz.day05;

import java.util.Arrays;

/***
 * 本类用来演示java中的工具类
 * 	java.util.Arrays
 * 提供对数组的一系列操作,如排序,拷贝....
 * @author 吴老师
 *
 * 2017年3月6日下午3:48:01
 */
public class ArraysDemo
{
	public static void main(String[] args)
	{
		//定义一个数组
		int[] arr = new int[10];
		//给数组元素赋值
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		System.out.println(Arrays.toString(arr));
		
		//数组排序(默认值是由小到大排序)
//		Arrays.sort(arr);
		//对数组元素部分排序,从指定下标开始(包含)到指定下标结束(不包含)
		Arrays.sort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
		
		//数组copy
		int[] newArr = Arrays.copyOfRange(arr, 2, 7);
		System.out.println(Arrays.toString(newArr));
		
		int[] nArr = new int[10];
		/*
		 * src			表示原数组
		 * srcPos		表示从原数组中第几个下标开始拷贝
		 * dest			表示目标数组
		 * destPos		表示从目标数组第几个位置开始存放
		 * length		表示copy元素个数
		 * 注意:		srcPos + length < src.length
		 * 			destPos + length < dest.length
		 */
		System.arraycopy(arr, 1, nArr, 2, 5);
		System.out.println(Arrays.toString(nArr));
		
		//数组元素的填充
		Arrays.fill(nArr, 0, 2, 100);
		System.out.println(Arrays.toString(nArr));
	}
	
}
