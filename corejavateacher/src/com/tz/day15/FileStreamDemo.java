package com.tz.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo
{
	public static void main(String[] args)
	{
		String path = "D:\\temp\\image3.jpg";
		String dest = "d:\\temp\\image4.jpg";
		//转换成File对象
		File file = new File(path);
		//判断
		if(!file.exists()) {
			System.out.println("文件不存在...");
			return ;
		}
		if(file.isDirectory()) {
			System.out.println("暂不支持目录的读取...");
			return ;
		}
		//创建FileInputStream对象
		/*try(FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(dest);)*/
		try(BufferedInputStream fis = 
				new BufferedInputStream(
						new FileInputStream(file));
			BufferedOutputStream fos = 
				new BufferedOutputStream(
						new FileOutputStream(dest));) 
		{
			//
			byte[] buf = new byte[100*1024]; //100k
			int len = -1; //用来保存实际读到的字节个数
			long total = 0; //记录总字节数【可选】
			//循环读取
			while((len = fis.read(buf)) != -1) {
				//你要做的就是处理这个  buf 数组
				//写入
				fos.write(buf, 0, len);
				total += len;
				System.out.printf("已读取【%d】字节,并写入\n",total);
			}
			System.out.printf("读取完毕，共计：[%d] 字节.\n",total);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
