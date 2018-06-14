package com.tz.day16;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//对象序列化
public class ObjectSerialize
{
	private static final String PATH = "datas.dat";
	
	//写入对象
	public static void write(Object obj) {
		File file = new File(PATH);
		//
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream(file));) {
			//直接写入
			oos.writeObject(obj);
			System.out.println("写入成功>>>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//读取对象
	public static Object read() {
		File file = new File(PATH);
		//
		if(!file.exists()) {
			System.out.println("数据文件不存在..");
			return null;
		}
		//
		try (ObjectInputStream ois = new 
				ObjectInputStream(new BufferedInputStream(
								new FileInputStream(file)));) {
			//读取
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}


