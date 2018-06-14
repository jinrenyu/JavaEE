/**
 * 
 */
package com.tz.day13;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.tz.day11.Student;

/**
 * 本类用来演示 TreeSet
 * 
 * @author 吴老师
 *
 *         2017年3月16日下午4:29:55
 */
public class TreeSetDemo
{
	public static void main(String[] args)
	{
		//创建一个Student比较器对象
		Comparator<Student> c = new StudentComparator();
		// 创建TreeSet对象 [以比较器为参数]
		SortedSet<Student> stuSet = new TreeSet<>(c);
		// 模拟三个学员
		Student s1 = new Student("jack", "男", 18, 175);
		Student s2 = new Student("ann", "女", 17, 169);
		Student s3 = new Student("solo", "男", 16, 178);
		//
		Student s4 = new Student("ann", "男", 18, 171);
		//
		stuSet.add(s1); 
		stuSet.add(s2);
		stuSet.add(s3);
		System.out.printf("元素个数：%d\n",stuSet.size());
		//
		stuSet.add(s4);
		//
		System.out.printf("元素个数：%d\n",stuSet.size());
		//
		for(Student s : stuSet) {
			System.out.println(s);
		}
		System.out.println("===华丽丽地分割线=====");
		//
		SortedSet<Student> sSet = new TreeSet<>(
					ComparatorFactory.getInstance(1));
		sSet.add(s1);
		sSet.add(s2);
		sSet.add(s3);
		sSet.add(s4);
		//
		for(Student s : sSet) {
			System.out.println(s);
		}
	}
}

