package com.tz.day16;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo
{
	public static void main(String[] args)
	{
		//准备一个字符文件的路径
		String path = "note/day15笔记.txt";
		//
		File file = new File(path);
		//
		if(!file.exists()) {
			System.out.println("文件不存在...");
			return ;
		}
		//
		try(FileReader fr = new FileReader(file);) {
			//定义变量
			int c = -1;
			//循环读取
			while((c = fr.read()) != -1) { //每次读1个字符
				//
				System.out.printf("%s",(char)c);
				//
				try
				{
					Thread.sleep((long)(Math.random()*100));
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			//
			System.out.println("\n读取完成...");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
