package com.tz.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class CollectionDemo
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test()
	{
		Collection coll = new ArrayList();
		
		//集合添加元素
		coll.add("123");
		coll.add(123);
		coll.add("abc");
		coll.add(123.123);
		
		//获取集合中的元素个数
		int size = coll.size();
		System.out.println(size);
		
		//将集合转换成数组
		Object[] obj = coll.toArray();
		System.out.println(Arrays.toString(obj));
		
		//遍历集合
		for(Object o : coll)
		{
			System.out.println(o);
		}
		System.out.println("-------");
		//迭代器遍历
		Iterator it = coll.iterator();
		//循环判断是否有下一个元素
		while(it.hasNext())
		{
			//获取下一个元素
			System.out.println(it.next());
			it.remove();
		}
		
		//删除元素
		coll.remove(123);
		
		System.out.println(coll);
		
		//清空一个集合
		coll.clear();
		
		//判断集合是否为空
		System.out.println(coll.isEmpty());
	}
}
