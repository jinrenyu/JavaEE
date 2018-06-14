package com.tz.day10;

import org.junit.Test;

import com.tz.day10.InnerClass.MemberInnerClass;
import com.tz.day10.InnerClass.StaticInnerClass;

public class TestInnerClass
{
	@Test
	public void test()
	{
		//创建外部类对象
		InnerClass inner = new InnerClass();
		//创建内部类对象
		InnerClass.MemberInnerClass member = 
				inner.new MemberInnerClass();
		member.member();
		System.out.println("-----");
		MemberInnerClass.A a = member.new A();
		a.t();
		System.out.println("------");
		//创建静态内部类对象
		StaticInnerClass sta = new StaticInnerClass(); 
		sta.staticMethod();
		
		System.out.println("-------");
		inner.test();
		
		System.out.println("------");
		inner.test1();
	}
}
