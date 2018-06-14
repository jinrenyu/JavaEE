package com.tz.day14;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

public class SeasonTest
{
	@Test
	public void testSeason1() {
		//使用数组的方法来操作
		Season[] arr = Season.values();
		//
		for(Season s : arr) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testSeason2() {
		//使用 EnumSet 来操作这个枚举
		EnumSet<Season> set = EnumSet.allOf(Season.class);
		//
		for (Season s : set)
		{
			System.out.println(s);
		}
		//只存放了2个枚举常量
		EnumSet<Season> partOf = 
				EnumSet.of(Season.SPRING, Season.AUTUMN);
		//
		System.out.println("== 分割线 ===");
		for(Season s : partOf) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testSeason3() {
		//使用 EnumMap 来操作
		EnumMap<Season, String> map = 
					new EnumMap<>(Season.class);
		//填充值
		map.put(Season.SPRING, "春意盎然");
		map.put(Season.SUMMER, "夏日炎炎");
		map.put(Season.AUTUMN, "秋高气爽");
		map.put(Season.WINTER, "冬暖夏凉");
		//
		Set<Season> set = map.keySet();
		for (Season s : set)
		{
			//取出value
			String value = map.get(s);
			//输出
			System.out.printf("%s => %s\n",s,value);
		}
	}
	
	@Test
	public void testStart() {
		SeasonGame sg = new SeasonGame();
		sg.start();
	}
}

