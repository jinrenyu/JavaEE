package com.tz.day03;

/*****
 * 本类用来演示java中的自定义方法及方法调用
 * 
 * @author 吴老师
 *
 *         2017年3月3日上午11:18:05
 */
public class MethodDemo
{
	String name;// 属性

	String account;

	double money;

	public void saveMoney(String account, double money)
	{
		this.money += money;
	}

	public void getMoney(String account, double money)
	{
		this.money -= money;
	}

	// static方法调用非static方法,必须先创建对象然后由对象.方法名
	public static void main(String[] args)
	{
		// 创建当前类型的对象
		MethodDemo demo = new MethodDemo();
		// 由对象名.方法名调用方法
		// String name = demo.getName();
		// System.out.println(name);

		int num = demo.add(10, 5);
		int n1 = 10, n2 = 20;
		num = demo.add(n1, n2);
		System.out.println(num);

		demo.setName("张三");
		demo.setName("李四");
		String n = demo.getName();
		System.out.println(n);

		demo.saveMoney("", 500);
		System.out.println(demo.money);
	}

	public String getName()
	{
		System.out.println("getName方法被调用了");
		return name;
	}

	// 计算两个整数数字的和,返回结果
	public int add(int n1, int n2)
	{
		return n1 + n2;
	}

	public void setName(String newName)
	{
		name = newName;
	}

}
