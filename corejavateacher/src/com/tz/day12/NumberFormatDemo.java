package com.tz.day12;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class NumberFormatDemo
{
	@Test
	public void test()
	{
		//创建NumberFormat对象
		NumberFormat nf = NumberFormat.getInstance();
		
		//获取货币的格式化对象
		NumberFormat nf1 = 
				NumberFormat.getCurrencyInstance(Locale.FRENCH);
		String money  = nf1.format(123456);
		System.out.println(money);
		
		//设置小数位最大保留位数
		nf.setMaximumFractionDigits(5);
		
		//获取保留小数位最大位数
		int xiao_max = nf.getMaximumFractionDigits();
		System.out.println(xiao_max);
	
		//设置小数位最小位数
		nf.setMinimumFractionDigits(2);
		
		//保留小数位最小位数
		int xiao_min = nf.getMinimumFractionDigits();
		System.out.println(xiao_min);
		
		//设置整数位最大位数
		nf.setMaximumIntegerDigits(5);
		
		//保留整数位最大位数
		int int_max = nf.getMaximumIntegerDigits();
		System.out.println(int_max);
		
		//设置小数位最小位数
		nf.setMinimumIntegerDigits(2);
		
		//保留整数位最小位数
		int int_min = nf.getMinimumIntegerDigits();
		System.out.println(int_min);
		
		//将数字格式化,四舍五入
		String num = nf.format(6.123556);
		System.out.println(num);
	}
}
