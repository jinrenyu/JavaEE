package com.ajax.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class SimplateDataSource {
	// 单例设计模式(饿汉单例:线程安全)
	// 饿汉单例
	private static final SimplateDataSource ds = new SimplateDataSource();
	// 保证连接池只有一个
	private static final String FILEPATH = "db_config.properties";
	private static Properties prop = new Properties();
	private static BasicDataSource bs = null;

	static {
		//以src为根目录加载文件并转化为输入流
		InputStream inStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream(FILEPATH);

		try {
			prop.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bs = new BasicDataSource();
		// 设置驱动类路径
		bs.setDriverClassName(prop.getProperty("oracleDriver"));
		// 设置url
		bs.setUrl(prop.getProperty("url"));
		// 设置用户名
		bs.setUsername(prop.getProperty("user"));
		// 设置密码
		bs.setPassword(prop.getProperty("password"));
		// 设置管理连接的策略
		// 设置连接池内的初始连接数目
		bs.setInitialSize(Integer.parseInt(prop.getProperty("InitialSize")));
		// 设置连接池内活动连接最大数量
		bs.setMaxActive(Integer.parseInt(prop.getProperty("MaxActive")));
		// 设置连接池内最大空闲的连接数量
		bs.setMaxIdle(Integer.parseInt(prop.getProperty("MaxIdle")));
		// 设置连接的最大等待时长(单位毫秒)
		bs.setMaxWait(Integer.parseInt(prop.getProperty("MaxWait")));

	}

	// 饱汉/懒汉单例
	// private static SimplateDataSource ds = null;
	// 1/构造方法私有化(防止创建新的实例)
	private SimplateDataSource() {
	}

	// 2.提供一个构建实例的方法,但是必须保证所返回的实例只有一个对象实例
	public static SimplateDataSource getInstance() {
		// if(ds == null){
		// ds = new SimplateDataSource();
		// }
		return ds;
	}

	//不能静态
	public Connection getConnection() throws SQLException {
		return bs == null ? null:bs.getConnection();
	}
	
	/*public void destory(){
		ds.destory();
	}*/
}
