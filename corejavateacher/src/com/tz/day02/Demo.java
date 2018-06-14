package com.tz.day02;

public class Demo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.print(" abcdefghi" + "\b");	
		System.out.print(" abcdefg");
		
		//类型范围较大的变量可以接收范围小的数据
		//byte -> short -> int -> long -> double
		//char -> int
		double d = 1;
		long l = 10;
		
		int i = '0';
		
		//强制类型转换
		int num = (int)123.123;
		int n = (int)Math.pow(2, 31);
		System.out.println(n);
		
		System.out.println(1 + 1.0);
		System.out.println("Hello World!" + "abc" + 123);
		
		System.out.println(1 + 1 + "1" + 1 + 1 + "1");
	
		//-只有数学减法运算
		
		//	/整数的除法运算得到的结果还是整数
		System.out.println(9 / 2);
		
		//	%取余(模)运算
		System.out.println(9 % 2);
		
		int m = 10;
		m += 10;//=> m = m + 10;
		System.out.println(m);//20
		
		//++
		/*
		 * 1.把m的值赋值给m++整体,m++ = 20
		 * 2.m的值自增1;m = m + 1 = 21
		 * 3.把m++整体的值赋值给x
		 */
		int x = m++;//m += 1;
		/*
		 * 1.m的值自增1;m = m + 1 = 22
		 * 2.把m的值赋值给++m整体,++m = 22
		 * 3.把++m的值赋值给x
		 */
		x = ++m;
		System.out.println(m);//22
		System.out.println(x);//22
		
		int a = 0;
		/*
		 * 1.把a的值赋值给a++整体,a++ = 0
		 * 2.a的值自增,a = a + 1 = 1
		 * 3.把a++整体的值赋值给a,a = a++ = 0
		 */
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		a = a++;
		System.out.println(a);
		
		System.out.println(m++ - --m+m++ + ++m+m--);
		
		//125
		System.out.println(Integer.toBinaryString(125));
		System.out.println(Integer.toOctalString(125));
		System.out.println(Integer.toHexString(125));
		System.out.println("-------");
		System.out.println(-4 >> 2);
		System.out.println(-4 >>> 2);
		System.out.println(125 << 2);
	}
}
