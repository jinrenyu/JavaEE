package com.tz.day03;

/*******
 * 本类用来演示java中的三目运算符
 * @author 吴老师
 *
 * 2017年3月3日上午9:51:41
 */
public class Demo1
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		//判断表达式 ? 表达式1 : 表达式2
		/*
		 * 判断表达式的结果为true时,得到表达式1的结果
		 * 否则得到表达式2的结果
		 */
		int num = 1 > 0 ? 10 : 5;
		if(1 > 0){
			num = 10;
		}else{
			num = 5;
		}
		//数据类型的自动提升
		double d = num > 0 ? 10 : 1.0;
		System.out.println(num > 0 ? 10 : 1.0);
	}
}
