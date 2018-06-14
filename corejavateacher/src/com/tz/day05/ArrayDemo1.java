package com.tz.day05;

import java.util.Arrays;

import org.junit.Test;

/****
 * 本类用来演示java中数组对数据的增删
 * @author 吴老师
 *
 * 2017年3月6日下午1:56:30
 */
public class ArrayDemo1
{
	@Test
	public void test()
	{
		//定义一个数组
		int[] arr = new int[10];
		//给数组元素赋值
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		System.out.println(Arrays.toString(arr));
		arr = addElementToArray(arr, 888, 5);
		System.out.println(Arrays.toString(arr));
		arr = deleteElementByIndex(arr, 5);
		System.out.println(Arrays.toString(arr));
//		arr = deleteElementByEle(arr, 5);
//		System.out.println(Arrays.toString(arr));
		arr = dltEleByEle(arr, 5);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 将指定元素添加到数组中的指定位置处,并将添加后的数组返回
	 */
	public int[] addElementToArray(int[] arr, int ele, int index)
	{
		//定义一个数组,长度是arr.length + 1
		int[] nArr = new int[arr.length + 1];
		//分段法
		for (int i = 0; i < arr.length; i++)
		{
			if(i < index)
			{
				nArr[i] = arr[i];
			}else
			{
				nArr[i + 1] = arr[i];
			}
		}
		nArr[index] = ele;
		/*for (int i = 0; i < nArr.length; i++)
		{
			if(i < index)
			{
				nArr[i] = arr[i];
			}else if(i > index)
			{
				nArr[i] = arr[i - 1];
			}else 
			{
				nArr[i] = ele;
			}
		} */
		return nArr;
	}
	
	/*
	 * 删除数组中指定位置处的元素,将删除后的数组返回
	 */
	public int[] deleteElementByIndex(int[] arr, int index)
	{
		//定义一个数组,长度是arr.length - 1
		int[] nArr = new int[arr.length - 1];
		for (int i = 0; i < nArr.length; i++)
		{
			if(i < index)
			{
				nArr[i] = arr[i];
			}else
			{
				nArr[i] = arr[i + 1];
			}
		}
		return nArr;
	}
	
	/*
	 * 删除数组中的所有指定元素,将删除后的数组返回
	 */
	public int[] deleteElementByEle(int[] arr, int ele)
	{
		//统计出数组包含ele的个数
		int count = 0;
		for (int i = 0; i < arr.length; i++)
		{
			//判断当前i对应的元素是否与ele相等
			if(arr[i] == ele)
			{
				count++;
			}
		}
		//定义一个数组,长度arr.length - count
		int[] newArr = new int[arr.length - count];
		//给新数组定义一个下标
		int index = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] != ele)
			{
				newArr[index] = arr[i];
				index++;
			}
		}
		return newArr;
	}
	
	public int[] dltEleByEle(int[] arr, int ele)
	{
		for (int i = arr.length - 1; i >= 0; i--)
		{
			if(arr[i] == ele)
			{
				arr = deleteElementByIndex(arr, i);
			}
		}
		return arr;
	}
	
}
