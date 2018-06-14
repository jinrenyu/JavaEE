package com.tz.day12;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class SortedSetDemo
{
	@Test
	public void test()
	{
		//创建比较器对象
		Comparator<Person> c = new SortAge();
		SortedSet<Person> set = new TreeSet<>(c);
		
		Person p1 = new Person("Rose","女",25);
		Person p2 = new Person("Jack","男",23);
		Person p3 = new Person("Jerry","女",27);
		Person p4 = new Person("Tom","女",29);
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		for(Person p : set)
		{
			System.out.println(p);
		}
	}
}
