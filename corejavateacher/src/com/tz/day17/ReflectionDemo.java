package com.tz.day17;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.tz.day11.Student;

/*********
 * 本类用来演示 反射的案例
 * @author 吴老师
 *
 * 2017年3月22日下午4:29:14
 */
public class ReflectionDemo
{
	//根据给定的类型，通过反射来显示这个类的结构
	public static void showClass(Class<?> c) {
		//1.通过反射API来获取我们要的信息
		Package p = c.getPackage();
		System.out.println("所在包名："+p.getName());
		//获取类的修饰符 
		int modifiers = c.getModifiers();
		//利用 Modifier来解析这个整数
		System.out.println("修饰符："+Modifier.toString(modifiers));
		//
		System.out.println("类名："+c.getName());
		//获取所有属 性
		Field[] fields = c.getDeclaredFields();
		//遍历
		for(Field f : fields) {
			//
			String mod = Modifier.toString(f.getModifiers());
			//获取属性类型
			String type = f.getType().getSimpleName();
			String name = f.getName();
			//假设常量属性不显示
			if(Modifier.isFinal(f.getModifiers())) {
				continue;
			}
			//输出
			System.out.printf("属性：%s %s %s\n",mod,type,name);
		}
		//获取所有的构造
		Constructor<?>[] carr = c.getDeclaredConstructors();
		System.out.println("\n本类的所有构造器如下：");
		//遍历
		for (Constructor<?> cr : carr)
		{
			String mod = Modifier.toString(cr.getModifiers());
			String name = cr.getName();
			//获取参数个数
			int count = cr.getParameterCount();
			Class<?>[] types = cr.getParameterTypes();
			System.out.printf("%d 参构造如下：\n",count);
			System.out.printf("%s %s(",mod,name);
			//循环输出这个构造方法的参数
			int i = 0;
			for (Class<?> class1 : types)
			{
				System.out.printf("%s %s",
						class1.getSimpleName(),
						"arg"+i);
				i++;
				//判断 是否添加逗号
				if(i < count) {
					System.out.print(",");
				}
			}
			System.out.println(")");
			//
		}
		//获取所有的方法
		Method[] methods = c.getDeclaredMethods();
		System.out.println("\n所有的方法签名如下：");
		for (Method method : methods)
		{
			int mod = method.getModifiers(); //获取修饰符
			String rtnType = method.getReturnType()
										.getSimpleName();//返回类型
			String mName = method.getName(); //方法名
			//获取参数个数
			int count = method.getParameterCount();
			System.out.printf("%s %s %s(", 
					Modifier.toString(mod),rtnType,mName);
			//得到所有参数
			Class<?>[] types = method.getParameterTypes();
			//循环输出这个构造方法的参数
			int i = 0;
			for (Class<?> class1 : types)
			{
				System.out.printf("%s %s",
						class1.getSimpleName(),
						"arg"+i);
				i++;
				//判断 是否添加逗号
				if(i < count) {
					System.out.print(",");
				}
			}
			System.out.println(")");
		}
		//over
	}
	
	public static void main(String[] args)
	{
		showClass(Student.class);
	}
}

