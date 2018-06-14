package com.tz.day12;

import java.util.LinkedList;

import org.junit.Test;

public class LinkedListDemo
{
	@Test
	public void test()
	{
		//利用LinkedList模拟堆栈
		LinkedList<String> stack = new LinkedList<>();
		//向堆栈中添加元素
		stack.push("123");
		stack.push("abc");
		stack.push("456");
		stack.push("efg");
		//获取但不移除第一个元素
		String s = stack.peek();
		System.out.println(s);
		//获取并移除第一个元素
		stack.pop();
		System.out.println(stack);
		
		//模拟队列
		LinkedList<String> queue = new LinkedList<>();
		//向队列中添加元素
		queue.offer("123");
		queue.offer("abc");
		queue.offer("456");
		queue.offer("789");
		
		//获取但不移除列表的头
		String str = queue.getFirst();
		System.out.println(str);
		//获取并移除列表的第一个元素
		queue.pollFirst();
		
		System.out.println(queue);
	}
}
