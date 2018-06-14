package com.tz.day03;

import java.util.Random;

/******
 * 本类用来演示java中随机数的产生方式
 * 1.java.lang.Math
 * 	Math.random()返回一个double类型随机数,[0,1)
 * 2.java.util.Random
 * 	创建Random对象	Random rand = new Random();
 * 	产生随机数			int num = rand.nextInt();
 * @author 吴老师
 *
 * 2017年3月3日上午10:04:36
 */
public class RandomDemo
{
	public static void main(String[] args)
	{
		//产生[1,10]的随机数
		System.out.println((int)(Math.random() * 10 + 1));
		System.out.println((char)((int)(Math.random() * 26 + 'a')));
		
		//创建Random对象
		Random rand = new Random();
		//产生随机数	,随机数的范围是int类型的范围
		//产生[0,10)随机数
		int num = rand.nextInt(10) + 1;//[1,10]
		System.out.println(num);
	}
}
