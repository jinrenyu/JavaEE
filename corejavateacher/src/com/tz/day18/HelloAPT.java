package com.tz.day18;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tz.day17.Hello;
import com.tz.day17.UseHello;

public class HelloAPT
{
	public static void main(String[] args)
	{
		//1.首先获取UseHello的class对象
		Class<UseHello> c = UseHello.class;
		//2.创建这个类的实例
		try
		{
			UseHello obj = c.newInstance();
			//3. 获取这个类中的sayHi方法
			Method m = c.getDeclaredMethod("sayHi", String.class);
			//4. 获取添加到这个方法上的注解
			Hello h = m.getAnnotation(Hello.class);
			//5. 获取这个注解的属性
			String value = h.value();
			//6.把这个值做为参数 来调用 sayHi方法
			m.invoke(obj, value);
			//
			System.out.println("APT程序处理完成...");
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
}
