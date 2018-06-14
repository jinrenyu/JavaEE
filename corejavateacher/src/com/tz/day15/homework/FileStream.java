package com.tz.day15.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileStream {
	
	public void copy(String file, String dir) {
		File srcFile = new File(file);
		File destFile = new File(dir);
		if (!destFile.exists()) {
			destFile.mkdirs(); //目录
			System.out.println("文件目录创建成功...");
		}
		if (!srcFile.exists()) {
			System.out.println("文件不存在...");
			return;
		}
		if (srcFile.isDirectory()) {
			System.out.println("暂不支持目录读取...");
			return ;
		}
		File realFile = null;
		if(destFile.isDirectory()) {
			//考虑目的地所在的目录与源文件所在的目录是同一个
			if(destFile.equals(srcFile.getParentFile())) {
				//
				realFile = new File(destFile, "复件 "+srcFile.getName());
			} else {
				//
				realFile = new File(destFile, srcFile.getName());
			}
		} else {
			//目标本身是文件
			realFile = destFile;
		}
		
		try (FileInputStream fis = 
				new FileInputStream(srcFile); 
				FileOutputStream fos = 
						new FileOutputStream(realFile);) {

			byte[] buf = new byte[100 * 1024];
			int len = -1;
			long total = 0;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
				total += len;
				System.out.printf("已读取【%d】字节，内容如下：\n", total);
			}
			System.out.printf("读取完毕，共计：【%d】字节。\n", total);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//两个文件的COPY
	public void copyFile(String src, String dest) {
		//..
		
		
	}
	
	public boolean copyDir(String srcDir, String destDir) {
		
		return false;
		
	}
}
