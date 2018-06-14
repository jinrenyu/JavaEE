package com.tz.cels.dao;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public class BaseTermDaoImplTest
{
	@Test
	//单词测试
	public void test()
	{
		IBaseTermDao a = new BaseTermDaoImpl();
		Set<Word> set1 = new TreeSet<>();
		set1 = a.getAllWords();
		for (Word w : set1)
		{
			System.out.println(w);
		}
		System.out.println(set1.size());
		

	}
	
	//词汇测试
	@Test
	public void testvocab()
	{
		IBaseTermDao a = new BaseTermDaoImpl();
		Set<Vocabulary> set = new TreeSet<>();
		set=a.getAllVocabularies();
		for (Vocabulary v : set)
		{
			System.out.println(v);
		
		}
		System.out.println(set.size());
	}
	
}
