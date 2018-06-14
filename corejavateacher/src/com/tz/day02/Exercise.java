package com.tz.day02;

//1.导入Scanner
import java.util.Scanner;

/*
 * 输入一个四位整数数字,输入每一位上的数字
 * 如:1234
 * 输出:千位数字是1...
 */
public class Exercise {
	public static void main(String[] args) {
		//2.创建Scanner对象
		Scanner sc = new Scanner(System.in);
		//提示
		System.out.println("请输入一个四位数字>");
		//3.接收键盘输入
		int num = sc.nextInt();//1234
		//4.关闭
		sc.close();
		System.out.println("千位数字是>" + (num / 1000));
		System.out.println("百位数字是>" + (num % 1000 / 100));
		System.out.println("十位数字是>" + (num % 100 / 10));
		System.out.println("个位数字是>" + (num % 10));
	}
}
