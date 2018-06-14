package com.tz.day10;

import org.junit.Test;

import com.tz.day07.Animal;
import com.tz.day07.Cat;
import com.tz.day07.Dog;

public class ExceptionDemo
{
	@Test
	public void test()
	{
		/*SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			sdf.parse("");
		} catch (ParseException e)
		{
			e.printStackTrace();
		}*/
		
		/*try
		{
			int[] arr = new int[10];
			System.out.println(arr[10]);
		} catch (NullPointerException e)
		{
			System.out.println("空指针异常");
		} catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("数组下标越界");
		}finally 
		{
			//资源的释放,IO流的关闭
			System.out.println("finally代码块执行了");
		}*/
		
		test1();
	}
	
	public void test1()
	{
		try
		{
			test2();
			Animal dog = new Dog();
			if(dog instanceof Cat)
			{
				@SuppressWarnings("unused")
				Cat cat = (Cat)dog;
			}else
			{
				throw new ClassCastException("类型转换异常");
			}
		} catch (Exception e)
		{
		}
	}
	
	public void test2() throws ClassCastException
	{
		Animal dog = new Dog();
		if(dog instanceof Cat)
		{
			@SuppressWarnings("unused")
			Cat cat = (Cat)dog;
		}else
		{
			throw new ClassCastException("类型转换异常");
		}
	}
	
}
