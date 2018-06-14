package com.tz.day16;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo
{
	public static void main(String[] args)
	{
		String path = "d:\\temp\\test.txt";
		//
		File file = new File(path);
		//
		if(!file.exists()) {
			System.out.println("文件不存在...");
			return;
		}
		//创建RandomAccessFile对象
		try(RandomAccessFile raf = 
				new RandomAccessFile(file, "r");) {
			//获取当前文件指针的偏移量
			long pointer = raf.getFilePointer();
			//
			System.out.println("当前的位置："+pointer);
			//
			System.out.println("文件的长度："+raf.length());
			//读取1个字节
			int b = raf.read();
			System.out.println("本次读到的字节："+(char)b);
			//再看文件的长度
			pointer = raf.getFilePointer();
			System.out.println("当前的位置："+pointer);
			//定位 
			raf.seek(raf.length() - 1);
			//再看位置
			pointer = raf.getFilePointer();
			System.out.println("当前的位置："+pointer);
			//再读
			b = raf.read();
			System.out.println("本次读到的字节："+(char)b);
			//再看位置
			pointer = raf.getFilePointer();
			System.out.println("当前的位置："+pointer);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
