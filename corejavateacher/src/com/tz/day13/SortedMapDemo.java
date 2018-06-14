/**
 * 
 */
package com.tz.day13;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.tz.day11.Student;

/**本类用来演示 SortedMap的使用
 * @author 吴老师
 *
 * 2017年3月16日下午3:35:50
 */
public class SortedMapDemo
{
	public static void main(String[] args)
	{
		//1.创建一个SortedMap
		SortedMap<String, Student> smap = 
				new TreeMap<>();
		//模拟三个学员
		Student s1 = new Student("jack", "男", 18, 175);
		Student s2 = new Student("ann", "女", 17, 169);
		Student s3 = new Student("solo", "男", 19, 178);
		//
		Student s4 = new Student("ann", "男", 21, 171);
		//添加到集合中
		smap.put(s1.getName(), s1);
		smap.put(s2.getName(), s2);
		smap.put(s3.getName(), s3);
		//
		smap.put(s4.getName(), s4);
		//不能使用null值为key,否则，运行时会出现空指针异常
//		smap.put(null, s2);
		
		//输出
		Set<String> keys = smap.keySet();
		for (String key : keys)
		{
			//通过key来取value
			Student value = smap.get(key);
			//
			System.out.printf("%s -> %s\n",key,value);
		}
	}
}

