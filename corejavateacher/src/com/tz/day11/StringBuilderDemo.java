package com.tz.day11;

import org.junit.Test;

public class StringBuilderDemo
{
	@Test
	public void test()
	{
		//创建一个StringBuilder对象
		StringBuilder builder = new StringBuilder();
		
		//1.字符串的拼接
		builder.append("abc").append("defg");
		
		//2.返回当前容量
		System.out.println(builder.capacity());
		
		//3.返回长度(字符数)
		System.out.println(builder.length());
		
		//4.返回此序列中指定索引处的 char 值
		char c = builder.charAt(0);
		System.out.println(c);
		
		//5.删除指定位置字符序列(end不包含)
		StringBuilder sb = builder.delete(0, 2);
		System.out.println(builder.toString());
		System.out.println(sb.toString());
		//移除此序列指定位置上的 char
		builder.deleteCharAt(0);
		System.out.println(builder.toString());
		
		//6.返回第一次出现的指定子字符串在该字符串中的索引
		int index = builder.indexOf("c");
		System.out.println(index);
		
		//7.将字符串插入此字符序列中
		builder.insert(0, "abc");
		System.out.println(builder.toString());
		
		//8.替换方法
		builder.replace(0, 3, "ABCD");
		System.out.println(builder.toString());
		
		//9.反转字符串
		builder.reverse();
		System.out.println(builder.toString());
		
		//10.将给定索引处的字符设置为 ch
		builder.setCharAt(0, '1');
		System.out.println(builder.toString());
		
		//11.设置字符序列的长度 
		builder.setLength(7);
		System.out.println(builder.toString());
		
		//12.截取方法
		String str = builder.substring(0, 2);
		System.out.println(builder.toString());
		System.out.println(str);
		
		System.out.println(builder.capacity());
		//13.尝试减少用于字符序列的存储空间
		builder.trimToSize();
		System.out.println(builder.capacity());
	}
}
