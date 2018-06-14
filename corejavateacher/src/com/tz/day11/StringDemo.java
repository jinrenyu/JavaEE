package com.tz.day11;

import java.util.Arrays;

import org.junit.Test;

public class StringDemo
{
	@Test
	public void test()
	{
		String str = "ab,cd,ae,fg";
		
		// 1.通过下标获取对应位置的字符
		//输入的下标不存在时会抛出
		//StringIndexoutOfBoundsException
		char c = str.charAt(0);
		System.out.println(c);
		
		//2.将一个字符串拼接到此字符串的末尾
		String nStr = str.concat("hijklmn");
		System.out.println(nStr);
		
		//3.判断字符串是否以指定字符开头或者结尾
		boolean flag = str.startsWith("abc");
		System.out.println(flag);
		flag = nStr.endsWith("mn");
		System.out.println(flag);
		
		//4.字符串比较相等
		boolean f = "abcdefg".equals(str);
		System.out.println(f);
		//忽略大小写比较相等
		System.out.println(str.equalsIgnoreCase("ABCdefg"));
		
		//5.通过字符/字符串获取第一次出现的下标
		int index = str.indexOf('a');
		System.out.println(index);
		//字符串中没有找到指定的字符/字符串时,得到的结果为-1
		index = str.indexOf('a', index + 1);
		System.out.println(index);
		index = str.indexOf("efg");
		System.out.println(index);
		
		//6.判断字符串是否为空
		String str1 = "";
		System.out.println(str1.isEmpty());
		
		//7.通过字符/字符串获取最后一次出现的下标
		index = str.lastIndexOf('a');
		System.out.println(index);
		index = str.lastIndexOf('a',index - 1);
		System.out.println(index);
		
		//8.返回此字符串的长度
		int length = str.length();
		System.out.println(length);
		
		//9.替换指定字符串的指定内容
		String str2 = "你个大SB,大JB,NNGT";
//		str2 = str2.replace("SB", "**");
		str2 = str2.replaceAll("SB|JB|NNGT", "****");
		System.out.println(str2);
		
		//10.字符串切割方法(按照指定的模式字符去切割)
		String[] strs = str.split(",");
		System.out.println(Arrays.toString(strs));
		
		//11.截取字符串
		str = "abcdefg";
		String str3 = str.substring(1, 4);
		System.out.println(str3);
		str3 = str.substring(3);
		System.out.println(str3);
		
		//12.转换字符串大小写
		String str4 = "我们是Jsd1702班";
		str4 = str4.toUpperCase();
		str4 = str4.toLowerCase();
		System.out.println(str4);
		
		//13.把字符串转换成字符数组
		char[] cs = str.toCharArray();
		System.out.println(Arrays.toString(cs));
		
		//14.把任意类型转换成字符串
		int num = 123;
		String str5 = String.valueOf(num);
		System.out.println(str5);
		
		//15.去除字符串左右两边的空白字符
		String str6 = " 	abc 123 efg 456	 	";
		str6 = str6.trim();
		System.out.println(str6);
		
		//16.判断字符串是否包含指定的字符串
		System.out.println(str.contains("abc"));
		
		System.out.println(str);
	}
}
