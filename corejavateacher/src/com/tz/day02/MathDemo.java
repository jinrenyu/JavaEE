package com.tz.day02;

/*************
 * 本类用来演示java中的Math类
 * 	java.lang.Math
 * 此类提供一系列关于数学的运算,如:求绝对值,求幂次方,求最值.....
 * @author 吴老师
 *
 * 2017年3月2日上午11:08:57
 */
public class MathDemo {
	public static void main(String[] args) {
		
		System.out.println(Math.PI);
		
		System.out.println(Math.E);
		
		int num = -1;
		//求一个数字的绝对值
		System.out.println(Math.abs(num));
		
		//求一个数字的幂次方,得到的结果为double
		double n = Math.pow(2,3);
		System.out.println(n);
		
		//求两个数字的最大值
		int max = Math.max(5, 10);
		System.out.println(max);
		
		max = Math.max(max, 50);
		
		System.out.println(Math.ceil(123.123456));
	}
}
