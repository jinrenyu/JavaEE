package com.tz.day08;

import java.util.Calendar;
import static java.util.Calendar.*;
import static java.lang.Math.max;

import org.junit.Test;

import static com.tz.day08.StaticDemo.show;

public class Demo
{
	@Test
	public void test()
	{
		//访问非本类的静态成员,通过类名.成员名
		System.out.println(StaticDemo.num);
		show();
		
		StaticDemo s1 = new StaticDemo();
		System.out.println(s1.getN());
		StaticDemo s2 = new StaticDemo();
		System.out.println(s2.getN());
		
		Calendar cal = getInstance();
		System.out.println(cal.get(YEAR));
		System.out.println(cal.get(MONTH));
		
		System.out.println(max(10,5));
		
		System.out.println(s1 == s2);
		
		SingletonDemo demo1 = SingletonDemo.newInstance();
		SingletonDemo demo2 = SingletonDemo.newInstance();
		System.out.println(demo1 == demo2);
		System.out.println(A.demo == B.demo);
	}
}

class A 
{
	static SingletonDemo demo = SingletonDemo.newInstance();
}

class B
{
	static SingletonDemo demo = SingletonDemo.newInstance();
}




