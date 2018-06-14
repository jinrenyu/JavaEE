package com.tz.cels.service;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;

import com.tz.cels.exceptions.NohistoryException;
import com.tz.cels.service.impl.GameServiceImpl;

public class GameServiceImplTest
{
	@Test
	public void test1()
	{
		IGameService gs = new GameServiceImpl();
		try
		{
			Map<String, String> map = new TreeMap<>();
			map=gs.en2cn(true);
			Set<Entry<String, String>> entrys = map.entrySet();
			for (Entry<String, String> entry : entrys)
			{
				//获取key
				String key = entry.getKey();
				//获取value
				String value = entry.getValue();
				//输出
				System.out.printf("%s   ->   %s\n",key,value);
			}
		} catch (NohistoryException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void test2()
	{
		IGameService gs = new GameServiceImpl();
		Map<String, String> map = new TreeMap<>();
		try
		{
			map=gs.cn2en(true);
			Set<Entry<String, String>> entrys = map.entrySet();
			for (Entry<String, String> entry : entrys)
			{
				//获取key
				String key = entry.getKey();
				//获取value
				String value = entry.getValue();
				//输出
				System.out.printf("%s   ->   %s\n",key,value);
			}
			
		} catch (NohistoryException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3()
	{
		IGameService gs = new GameServiceImpl();
		Map<String, String> map = new TreeMap<>();
		gs.saveGameHistory(map, true);
	}
}
