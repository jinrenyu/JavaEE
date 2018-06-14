package com.jdbc.maintest;

public class Test {

	public static void main(String[] args) {
			
			int i=1;
		
			System.out.println(i--);
			System.out.println(i);
			
			int a = 0;
			/*
			 * 1.把a的值赋值给a++整体,a++ = 0
			 * 2.a的值自增,a = a + 1 = 1
			 * 3.把a++整体的值赋值给a,a = a++ = 0
			 */
			a = a++;
			
			System.out.println(a);
			a = a++;
			System.out.println(a);
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			a = a++;
			System.out.println(a);
			
			
	}

}
