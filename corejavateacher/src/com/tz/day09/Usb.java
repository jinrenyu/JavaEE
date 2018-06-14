package com.tz.day09;

public interface Usb
{
	//接口中没有普通属性
//	public int num;
	
	//接口中可以有常量属性,常量必须是static
	public static final int NUM = 10;
	//接口中的常量的修饰符可以省略
	int N = 10;
	
	//接口中没有构造方法,不能创建实例
//	public Usb(){}
	
	//接口中不能有方法实现,所以接口中的方法必须是抽象的
//	public void show(){
//	}
	
	public abstract void connect();
	//抽象方法的修饰符可以省略
//	void show();
}
