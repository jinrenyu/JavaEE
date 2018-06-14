package com.tz.day08;

public class SingletonDemo
{
	//2.创建静态私有本身对象
	private static SingletonDemo single = 
			new SingletonDemo();
	
	//1.构造方法私有化
	private SingletonDemo(){}
	
	//3.提供一个公开静态的方法返回这个对象
	public static SingletonDemo newInstance()
	{
		return single;
	}
}
