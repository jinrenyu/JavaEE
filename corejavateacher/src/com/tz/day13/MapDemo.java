package com.tz.day13;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tz.day11.Student;

/*******
 * 本类用来演示
 * @author 吴老师
 *
 * 2017年3月16日上午10:01:06
 */
public class MapDemo
{
	/******
	 * 主方法
	 * @param args
	 */
	public static void main(String[] args)
	{
		//创建Map对象
		Map<String, Student> map = new HashMap<>();
		//模拟三个学员对象
		Student s1 = new Student("jack", "男", 18, 175);
		Student s2 = new Student("ann", "女", 17, 169);
		Student s3 = new Student("solo", "男", 19, 178);
		
		//把此三个学员添加到map中
		map.put(s1.getName(), s1);
		map.put(s2.getName(), s2);
		map.put(s3.getName(), s3);
		//
		System.out.printf("map中元素个数：%d\n",map.size());
		//
		System.out.println("==数据如下：");
		//方式一
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		System.out.println("Key   ->   Value");
		while (iter.hasNext())
		{
			String key = iter.next();
			//通过key来获取value
			Student value = map.get(key);
			//输出
			System.out.printf("%s   ->   %s\n",key,value);
		}
		//
		System.out.println("=== 方式二 :");
		Collection<Student> values = map.values();
		for (Student s : values)
		{
			System.out.println(s);
		}
		//
		System.out.println("=== 方式三:");
		Set<Entry<String, Student>> entrys = map.entrySet();
		for (Entry<String, Student> entry : entrys)
		{
			//获取key
			String key = entry.getKey();
			//获取value
			Student value = entry.getValue();
			//输出
			System.out.printf("%s   ->   %s\n",key,value);
		}
	}
}

