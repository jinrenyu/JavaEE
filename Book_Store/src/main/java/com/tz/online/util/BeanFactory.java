package com.tz.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Bean工厂类
 */
public class BeanFactory {
	
	private static Properties prop = new Properties();
	
	static{
		
		InputStream in = Thread.currentThread()
				 			   .getContextClassLoader()
							   .getResourceAsStream("beans.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("sorry,not found beans.properties!");
		}
	}
	
	public static Object createBeans(String className){
		Object obj = null;
		
		String cname = prop.getProperty(className);
		try {
			Class<?> c = Class.forName(cname);
			obj = c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
}
