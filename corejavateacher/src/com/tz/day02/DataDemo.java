package com.tz.day02;

@SuppressWarnings("unused")
public class DataDemo {
	
	{
		byte b = 10;
		{
			System.out.println(b);
			byte B = 10;
		}
		byte B;
	}
	
	static byte b3;//0
	
	public static void main(String[] args) {
		/*
		 * 整型,默认值都是0
		 */
		//1.byte 字节型	-128~127(-2^7~2^7-1) 1字节=8bit
		byte b;//定义一个byte类型变量,变量名为b
		b = 10;//给变量b赋初始值为10
		byte B = 10;
		B = b;
		byte b1 = b;
		b = 20;
		//变量在使用之前必须初始化
		{
			byte _b;
		}
		byte b2 = 127;
		System.out.println(b3);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		//2.short 短整型	(-2^15~2^15-1)	2字节=16bit
		short s = 10;
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
	
		//3.int 整型	-2^31~2^31-1	4字节=32bit
		int num = 10;
		num = 20;
		
		//常量
		final int CHANG_LIANG = 10;
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	
		//long 长整型	  -2^63~2^63-1	8字节=64bit
		long l = 2200000000L;
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
	
		/*
		 * 浮点型
		 */
		//1.float 单精度	1.4E-45~3.40E38 0.0f
		float f = 0.0F;
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		//2.double 双精度(浮点型的默认类型) 0.0
		//4.9E-324~1.798E308
		double d = 0.0;
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		
		/*
		 * 布尔型
		 */
		//boolean true|false	false
		boolean bool = true;
		boolean flag = false;
		
		/*
		 * 字符型
		 */
		//char	65535个字符  默认值\u0000
		char c = ' ';
		System.out.println(Character.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
		int n = Character.MAX_VALUE;
		System.out.println(n);
		int n1 = '0';//48
		int n2 = 'a';//97
		int n3 = 'A';//65
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
	}
}
