package com.tz.day18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/****
 * 本类用来演示 利用Properties来读到属性文件
 * @author 吴老师
 *
 * 2017年3月23日上午10:48:24
 */
public class DemoConfig
{
	private final static String PATH = 
						"demo.properties"; //属性文件的位置
	//
	private static Properties content; //存储属性文件的内容
	//
	static {
		//1.创建Properties
		content = new Properties(); //
		//2. 把文件变成流
		try
		{
//			InputStream in = new FileInputStream(PATH);
			
			/*InputStream in = 
					DemoConfig.class.getResourceAsStream(PATH);*/
			
			InputStream in = 
					Thread.currentThread()
						.getContextClassLoader()
							.getResourceAsStream(PATH);
			
			//3. 利用properties来加载
			content.load(in);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//再提供一个对外的静态方法来通过key获取value
	public static String get(String key) {
		return content == null ? null : content.getProperty(key);
	}
}
