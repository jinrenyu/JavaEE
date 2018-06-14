package com.tz.cels.dao.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.entity.TestRecord;

public class TestRecordDaoImpl implements ITestRecordDao
{
	// 持久化测试记录，每次都要先读取已经存在的历史记录，并把此record追加到那个集合中，再持久化那个集合
	@Override
	public void write(List<TestRecord> records, String fileName)
	{
		// TODO 把测试记录持久化到指定的文件中

		// 1.根据文件创建对象输出流

		// 2.调用持久化对象的方法

		// 3.处理IO异常
		File file = new File(fileName);
		//
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));)
		{
			oos.writeObject(records);
			System.out.println("写入成功>>>");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	// 加载所有的已保存的测试记录，并返回整个List
	@Override
	public List<TestRecord> read(String fileName)
	{
		// TODO 从文件是读出持久化的对象数据

		// 1.根据文件创建对象输入流

		// 2.调用读取对象的方法，并做强制类型转换

		// 3.处理IO异常

		// 4.返回
		List<TestRecord> list = new ArrayList<>();
		File file = new File(fileName);
		//
		if (!file.exists())
		{
			System.out.println("数据文件不存在..");
			return null;
		}
		//
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));)
		{
			// 读取
			list=(List<TestRecord>)ois.readObject();
			return list;
			
		} catch (IOException |ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
