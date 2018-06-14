package com.tz.day03;

public class ChinaDemo
{
	public static void main(String[] args)
	{
		int count = 0;
		for(char c = '\u4e00';c <= '\u9fa5';c++){
			System.out.print(c + " ");
			count++;
			if(count % 30 == 0){
				System.out.println();
			}
		}
		System.out.println(count);
	}
}
