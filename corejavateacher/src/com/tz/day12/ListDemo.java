package com.tz.day12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ListDemo
{
	@Test
	public void test()
	{
		//创建集合
		List<String> list = new ArrayList<>();
		
		list.add("123");
		list.add("abc");
		list.add("456");
		list.add("efg");
		
		//判断集合中是否包含指定的元素
		System.out.println(list.contains("123"));
		
		//通过下标获取元素
		//输入的下标不存在时会抛出
		//IndexOutOfBoundsException
		String str = list.get(0);
		System.out.println(str);
		
		//获取指定元素的第一次出现的下标
		int index = list.indexOf("abc");
		System.out.println(index);
		
		//根据元素下标删除该元素,返回该下标对应的元素
		String s = list.remove(0);
		System.out.println(s);
		
		//替换指定下标对应的元素值
		list.set(0, "789");
		System.out.println(list.get(0));
		
		//从指定下标(包含)开始到指定下标(不包含)结束截取集合
		List<String> l = list.subList(0, 2);
		System.out.println(l);
		
		//集合的遍历
		//1.for循环遍历
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		//2.增强for循环遍历
		for(String s1 : list)
		{
			System.out.println(s1);
		}
		
		//3.迭代器遍历
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
