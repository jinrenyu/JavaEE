package com.tz.day01;

//1.导入Scanner的全限定名
/**
 * java.lang包下的类可以直接使用,不需要导入
 */
import java.util.Scanner;

public class Hello
{
	public static void main(String[] args) 
	{
		System.out.println("Hello java!");
		//2.创建Scanner对象
		Scanner sc = new Scanner(System.in);
		//3.接受键盘输入
		//接受数字
		//输入的数据与变量的类型不匹配时会抛出
		//java.util.InputMisMatchException
	//	int num = sc.nextInt();
	//	System.out.println(num);

		//接受一段话,String类型
		//nextLine()和nextInt()不能混用
		//nextLine()和next()不能混用
	//	String str = sc.next();
	//	System.out.println(str);

		String word = sc.nextLine();
		System.out.print(word);
		
		//4.关闭
		sc.close();
		//一个类只能关闭Scanner一次
	//	Scanner sc1 = new Scanner(System.in);
	//	String str1 = sc1.nextLine();
	//	sc1.close();
	}
}