package com.tz.day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework
{
	public boolean copy(String file, String dir)
	{
		File f1 = new File(file);
		File f2 = new File(dir);
		if (!f1.exists())
		{
			System.out.println("文件不存在");
			return false;
		}
		if (f1.isDirectory())
		{
			System.out.println("在不支持目录的读取....");
			return false;
		}
		// 判断
		if (!f2.exists())
		{
			// 创建
			f2.mkdirs();// 创建目录结构
		} 
		File newfile = new File(f2.getAbsolutePath() + "\\" + f1.getName());//获得新文件路径
		try (FileInputStream in = new FileInputStream(f1); FileOutputStream out = new FileOutputStream(newfile))
		{
			byte[] buf = new byte[10*1024 * 1024];
			int len = -1;
			while ((len = in.read(buf)) != -1)
			{
				out.write(buf, 0, len);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	public boolean copy1(String srcDir, String destDir)
	{
		File f1 = new File(srcDir);
		File f2 = new File(destDir);
		File[] file = f1.listFiles();
		if (!f1.exists())
		{
			System.out.println("文件夹不存在");
			return false;
		}
		if (!f2.exists())
		{
			// 创建
			f2.mkdirs();// 创建目录结构
		} 
		for (File file2 : file)
		{
			File oldFile = new File(f1.getAbsolutePath() + "\\" + file2.getName()); // 需要复制的文件
			File newFile = new File(f2.getAbsolutePath() + "\\" + file2.getName());// 复制后的文件
			try (FileInputStream in = new FileInputStream(oldFile);
					FileOutputStream out = new FileOutputStream(newFile))
			{
				byte[] buf = new byte[5*1024 * 1024];
				int len = -1;
				while ((len = in.read(buf)) != -1)
				{
					out.write(buf, 0, len);
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return true;
	}
}
