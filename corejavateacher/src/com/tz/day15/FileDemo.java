package com.tz.day15;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo
{
	public static void main(String[] args)
	{
		//
		String path = "d:\\temp\\test";
		//转换成File对象
		File file = new File(path);
		//判断
		if(!file.exists()) {
			//创建
			file.mkdirs(); //创建目录结构
			System.out.println("创建目录成功...");
		} else {
			System.out.println("文件已存在...");
		}
		//
		for(int i=0;i<10;i++) {
			File f = new File(file, "file_"+(i+1)+".log");
			//创建
			try
			{
				if(f.exists()) {
					f.delete();
					System.out.printf("删除[%s]成功>>>\n",f.getName());
				} else {
					f.createNewFile();
					System.out.printf("创建文件[%s]成功>>>\n",f.getName());
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("finished...");
		System.out.println("\n-----------------------------------");
		//
		showDir("D:\\hello");
	}
	
	//查看指定目录下的所有子文件和目录
	public static void showDir(String dir) {
		//
		File file = new File(dir);
		if(!file.exists()) {
			System.out.println("目标目录不存在...");
			return ;
		}
		//
		if(file.isFile()) {
			System.out.println("目标不是一个合法的目录...");
			return ;
		}
		//
		showDir(file);
		
	}

	private static void showDir(File file)
	{
		//
//		String[] result = file.list();
//		File[] result = file.listFiles();
		File[] result = 
				file.listFiles(
					new FilenameFilter(){
						@Override
						public boolean accept(File dir, String name)
						{
							File temp = new File(dir, name);
							//判断
							if(temp.isDirectory()) {
								return true;
							} else if(temp.getName().endsWith(".java")) {
								return true;
							} else {
								return false;
							}
						}
					});
		//
		for (File s : result)
		{
			//判断是否要递归
			if(s.isDirectory()) {
				System.out.printf("[%s] 目录下: \n",
									s.getAbsolutePath());
				//又是目录，则递归调用
				showDir(s); //调用自己
			} else {
				//直接显示文件名
				System.out.println("\t"+s.getName());
			}
		}
	}
}

