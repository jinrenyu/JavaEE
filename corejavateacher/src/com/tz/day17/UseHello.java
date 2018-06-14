/**
 * 
 */
package com.tz.day17;

/**本类用来演示 使用我们自己定义的注解
 * @author 吴老师
 *
 * 2017年3月22日下午4:53:25
 */
public class UseHello
{
	@Hello("张三")
	public void sayHi(String name) {
		//
		System.out.println(">>你好，"+name);
	}
}
