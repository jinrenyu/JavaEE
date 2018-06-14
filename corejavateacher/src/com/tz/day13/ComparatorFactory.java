/**
 * 
 */
package com.tz.day13;

import java.util.Comparator;

import com.tz.day11.Student;

/**本类用来演示
 * @author 吴老师
 *
 * 2017年3月16日下午4:56:44
 */
public class ComparatorFactory
{
	public static Comparator<Student> getInstance(int type) {
		//
		Comparator<Student> c = null;
		//
		if(type == 1) {
			//年龄比较器
			c = new Comparator<Student>()
			{
				
				@Override
				public int compare(Student o1, Student o2)
				{
					return o1.getAge() - o2.getAge();
				}
			};
		} else if(type == 2) {
			//身高比较器
			c = new Comparator<Student>()
			{
				
				@Override
				public int compare(Student o1, Student o2)
				{
					if(o1.getHeight() > o2.getHeight()) {
						return 1;
					} else if(o1.getHeight() < o2.getHeight()) {
						return -1;
					} else {
						return 0;
					}
				}
			};
		} else {
			//姓名比较器
			c = new Comparator<Student>()
			{
				
				@Override
				public int compare(Student o1, Student o2)
				{
					return o1.getName().compareTo(o2.getName());
				}
			};
		}
		//
		return c;
	}
}
