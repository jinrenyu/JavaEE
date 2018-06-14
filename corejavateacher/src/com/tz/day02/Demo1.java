package com.tz.day02;

public class Demo1 {
	public static void main(String[] args) {
		System.out.println(test1()|test1());
		System.out.println("----");
		System.out.println(test1()||test1());
		System.out.println("----");
		System.out.println(test2()&test1());
		System.out.println("----");
		System.out.println(test2()&&test1());
	}
	
	public static boolean test1(){
		System.out.println("test1方法被调用了");
		return true;
	}
	
	public static boolean test2(){
		System.out.println("test2方法被调用了");
		return false;
	}
}
