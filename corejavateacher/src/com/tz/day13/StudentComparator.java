/**
 * 
 */
package com.tz.day13;

import java.util.Comparator;

import com.tz.day11.Student;

/**本类用来演示 学生比较器
 * @author 吴老师
 *
 * 2017年3月16日下午4:37:52
 */
public class StudentComparator implements Comparator<Student>
{
	@Override
	public int compare(Student o1, Student o2) {
		System.out.println(">>> invoked...");
		//定义比较的逻辑
		return o1.getAge() - o2.getAge();
	}
}
