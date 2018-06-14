package com.tz.day11;

import java.math.BigInteger;

import org.junit.Test;

public class BigIntegerDemo
{
	@Test
	public void test()
	{
		BigInteger big = new BigInteger("100");
		
		System.out.println(BigInteger.ONE);
		System.out.println(BigInteger.ZERO);
		System.out.println(BigInteger.TEN);
		
		BigInteger big1 = new BigInteger("20");
		
		//加法
		System.out.println(big.add(big1));
		
		//减法
		System.out.println(big.subtract(big1));
		
		//乘法
		System.out.println(big.multiply(big1));
		
		//除法
		System.out.println(big.divide(big1));
		
		System.out.println("-------");
		System.out.println(jie(new BigInteger("1000")).toString().length());
	}
	
	//求1000的阶乘
	public BigInteger jie(BigInteger num)
	{
		//退出出口
		if(num.equals(BigInteger.ONE))
		{
			return BigInteger.ONE;
		}
		return num.multiply(jie(num.subtract(BigInteger.ONE)));
	}
}
