package com.tz.day11;

import org.junit.Test;

public class TestObject
{
	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void test()
	{
		ObjectDemo demo1 = new ObjectDemo();
		ObjectDemo demo2 = new ObjectDemo();
		
		//1.	对象.getClass()
		Class<ObjectDemo> c1 = 
				(Class<ObjectDemo>) demo1.getClass();
		Class<ObjectDemo> c2 = 
				(Class<ObjectDemo>) demo2.getClass();
		System.out.println(c1 == c2);
		System.out.println(c1.getName());
		//2.	类名.class属性
		Class<ObjectDemo> c = ObjectDemo.class;
		
		//3.	Class.forName("类的全限定名")
		try
		{
			Class<ObjectDemo> c3 = 
					(Class<ObjectDemo>) Class.forName("com.tz.day11.ObjectDemo");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		//4.基本类型获取class实例的方式
		Class<Integer> c4 = int.class;
		
		//5.包装类型获取class实例的方式
		Class<Integer> c5 = Integer.TYPE;
	}
}
