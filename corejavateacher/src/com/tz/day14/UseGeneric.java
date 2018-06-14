/**
 * 
 */
package com.tz.day14;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 本类用来演示
 * 
 * @author 吴老师
 *
 *         2017年3月17日上午10:21:01
 */
public class UseGeneric
{

	public static void main(String[] args)
	{
		// 创建一个Entry对象
		Entry<Integer, String> e1 = new Entry<>(1, "hello");
		//
		Entry<Long, Double> e2 = new Entry<>();
		System.out.println(e1.getClass() == e2.getClass());
		//
		List<Number> n1 = new ArrayList<Number>();
		List<String> n2 = new ArrayList<String>();
		//验证泛型只是编译时的类型
		System.out.println(n1.getClass() == n2.getClass());
		//
		Collections.addAll(n1, 1,3,5,7,9);
		Collections.addAll(n2, "one","two","three","four");
		//
		showList(n1);
		showList(n2);
	}
	
	public static void showList(List<? extends Serializable> list) 
	{
		//迭代
		for(Serializable n : list) {
			System.out.println(n);
		}
	}
}
