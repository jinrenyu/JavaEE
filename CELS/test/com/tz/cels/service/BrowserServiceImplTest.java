package com.tz.cels.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.junit.Test;

import com.tz.cels.entity.PageBean;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.service.impl.BrowserServiceImpl;

public class BrowserServiceImplTest
{
	@Test
	public void test(){
		BrowserServiceImpl br = new BrowserServiceImpl();
		Map<Character,Set<Word>> map = new TreeMap<>();
		map=br.getFirstMap();
		Set<Entry<Character, Set<Word>>> entrys = map.entrySet();
		for (Entry<Character, Set<Word>> entry : entrys)
		{
			//获取key
			Character key = entry.getKey();
			//获取value
			Set<Word> value = entry.getValue();
			//输出
			System.out.println(key.toUpperCase(0)+"----------");
			for (Word word : value)
			{
				System.out.println(word.getEn()+" => 解释："+Arrays.toString(word.getCn()));
			}
			
		}
		System.out.println(map.size());
	}
	
	
	@Test
	public void test1()
	{
		BrowserServiceImpl br = new BrowserServiceImpl();
		PageBean pb= new PageBean();
		pb=br.getPageVocabularies(1);
		List<Vocabulary> list = new ArrayList<>();
		list=pb.getVdatas();
		for (Vocabulary v : list)
		{
			System.out.println(v);
		}
		
	}
	
	
	
	@Test
	public void test2()
	{
		BrowserServiceImpl br = new BrowserServiceImpl();
		PageBean pb= new PageBean();
		
		Map<Character,Set<Word>> map = new TreeMap<>();
		Set<Word> words = new TreeSet<>();
		map=br.getFirstMap();
		words=map.get('a');
		
		pb=br.getPageWords(1,words);
		List<Word> list = new ArrayList<>();
		list=pb.getWdatas();
		for (Word word : list)
		{
			System.out.println(word);
		}
	}
}
