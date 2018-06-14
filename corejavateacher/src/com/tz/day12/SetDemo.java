package com.tz.day12;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetDemo
{
	@Test
	public void test()
	{
		//创建一个set集合
		Set<String> set = new HashSet<>();
		//添加元素
		set.add("123");
		set.add("abc");
		set.add("456");
		set.add("123");//相同元素无法添加到set集合中
		
		System.out.println(set);
		
		Set<Person> s = new HashSet<>();
	
		Person p1 = new Person("张三","女",25);
		Person p2 = new Person("李四","男",23);
		Person p3 = new Person("王五","女",27);
		
		s.add(p1);
		s.add(p2);
		s.add(p3);
		s.add(p1);
		
		System.out.println(s);
	}
}
