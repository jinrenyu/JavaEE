package com.tz.cels.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public class BaseTermDaoImpl implements IBaseTermDao
{
	/*
	 * 获取所有的单词数据
	 * 
	 * @see com.tz.cels.dao.IBaseTermDao#getAllWords()
	 */

	@Override
	public Set<Word> getAllWords()
	{
		// 完成此方法
		// 1.要判断原始的单词数据文件是否存在
		// 2.利用IO流中的字符流来循环读到数据
		// 获取一行
		// 2.1依次处理读到的每一行数据，每一行对应一个Word对象

		// 2.2把创建好的Word对象添加到集合中

		// 3.要处理IO异常

		// 4.返回
		Set<Word> words = new TreeSet<>();
		File file = new File(WORD_FILE);
		if (!file.exists())
		{
			System.out.println("文件不存在");
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file));)
		{
			String value = null;
			while ((value=br.readLine()) != null)
			{
				//System.out.println(value);
				String[] strs = value.split("\\s+");
			
				String[] cnstrs = strs[1].split("[:]");
				Word word = new Word(strs[0], cnstrs);
				word.setFirst(strs[0].charAt(0));
				words.add(word);

			}
			//System.out.println(words.size());

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return words;
	}

	// 获取所有的词汇数据
	@Override
	public Set<Vocabulary> getAllVocabularies()
	{
		// 1.要判断原始的词汇数据文件是否存在
		// 2.利用IO流的字符流循环读到数据
		// 获取一行
		// 2.1依次处理读到的每一行数据，每一行对应一个Vocabulary对象
		// 注：要判断是否存在词汇的简称，如果存在，则设置简称

		// 2.2把创建好的Vocabulary对象添加到集合中

		// 3.要处理IO异常

		// 4.返回
		Set<Vocabulary> vSet = new TreeSet<>();
		File file = new File(VOCABULARY_FILE);
		if (!file.exists())
		{
			System.out.println("文件不存在");
		}
		try (BufferedReader br = new BufferedReader(new FileReader(file));)
		{
			String abbrev = null;
			String value=null;
			while ((value=br.readLine()) != null)
			{
				//String str = br.readLine();
				String[] strs = value.split("[#]");
				if (strs.length == 3)
				{
					abbrev = strs[2];
				} else
				{
					abbrev = null;
				}
				Vocabulary vocabulary = new Vocabulary(strs[0], strs[1].split("[:]"), abbrev);

				vSet.add(vocabulary);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return vSet;
	}

	// 此方法是把Map对象序列化到指定的文件名中
	@Override
	public void writeToFile(Map<String, String> map, String fileName)
	{
		// 利用对象流完成Map对象的序列化
		// 直接写入
		// 1.创建File对象

		// 2.判断此file是否是文件

		// 3.利用对象流完成写入

		// 4.处理异常
		File file = new File(fileName);
		//
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));)
		{
			oos.writeObject(map);
			System.out.println("写入成功>>>");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// 此方法是从fileName中读取一个Map的对象
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> readFromFile(String fileName)
	{
		// 判断fileName是否存在

		// 调用readObject方法直接读到

		// 正常返回
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
			return (Map<String, String>) ois.readObject();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
