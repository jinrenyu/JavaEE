package com.tz.day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/****
 * 本类用来演示 集合框架的练习
 * @author 吴老师
 *
 * 2017年3月16日上午10:53:15
 */
public class JcfExercise
{
	//

	public List sort(Map<Integer,Long> data) {
		
		//自已实现
		return null;
	}
	
	/*********
	 * 统计list集合中，每个数字所出现的次数
	 */
	public Map<Integer, Long> count(List<Integer> data) {
		//创建map
		Map<Integer, Long> map = new HashMap<Integer, Long>();
		//放入99个元素到此map中
		for(int i=1;i<=99;i++) {
			map.put(i, Long.valueOf(0));
		}
		//遍历list
		for(Integer d : data) {
			//判断
			if(map.containsKey(d)) {
				//取出，并++
				Long value = map.get(d);
				map.put(d, value+1);
			}
		}
		//返回
		return map;
	}

	/***********
	 * 根据指定的长度来使用随机数填充这个集合，并返回
	 * 随机数范围从[1~99]
	 * @param length
	 * @return
	 */
	public List<Integer> getList(int length) {
		//1.创建List
		List<Integer> data = new ArrayList<>();
		//2.创建Random对象
		Random r = new Random();
		int d = -1;
		//循环填充值
		for(int i=0;i<length;i++) {
			//产生随机数
			d = r.nextInt(100);
			//把0去掉
			if(d == 0) {
				i--; //此轮循环不算数
				continue;
			}
			//
			data.add(Integer.valueOf(d));
		}
		//返回
		return data;
	}
}


