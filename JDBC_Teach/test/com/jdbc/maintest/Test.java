package com.jdbc.maintest;

public class Test {

	public static void main(String[] args) {
			
			int i=1;
		
			System.out.println(i--);
			System.out.println(i);
			
			int a = 0;
			/*
			 * 1.��a��ֵ��ֵ��a++����,a++ = 0
			 * 2.a��ֵ����,a = a + 1 = 1
			 * 3.��a++�����ֵ��ֵ��a,a = a++ = 0
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
