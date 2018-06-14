package com.tz.day10;

public class InnerClass
{

	int id = 10;
	
	static int uid = 20;
	
	//成员内部类
	public class MemberInnerClass
	{
		int id = 15;
		public class A
		{
			int id = 100;
			public void t()
			{
				System.out.println(InnerClass.this.id);
				System.out.println(MemberInnerClass.this.id);
				System.out.println(id);
				System.out.println(uid);
			}
		}
		public void member()
		{
			System.out.println(InnerClass.this.id);
			System.out.println(id);
			System.out.println(uid);
		}
	}
	
	//静态内部类
	public static class StaticInnerClass
	{
		public void staticMethod()
		{
			System.out.println(uid);
		}
	}
	
	//局部内部类
	public void test()
	{
		final int n = 10;
		class LocalClass
		{
			public void local()
			{
				System.out.println(n);
				System.out.println(id);
				System.out.println(uid);
			}
		}
		//创建局部内部类对象
		LocalClass l = new LocalClass();
		l.local();
	}
	
	//匿名内部类
	public void test1()
	{
		final int n = 10;
		new Anonymous()
		{
			@Override
			public void show()
			{
				System.out.println(n);
				System.out.println(id);
				System.out.println(uid);
			}
			
		}.show();
	}
}
