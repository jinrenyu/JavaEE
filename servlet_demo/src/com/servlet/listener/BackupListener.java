package com.servlet.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.servlet.action.LoginAction;

public class BackupListener implements ServletContextListener {

	public BackupListener() {
	}

	public void contextDestroyed(ServletContextEvent se) {
		String filePath = se.getServletContext().getRealPath("/fcount");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(se.getServletContext().getAttribute(LoginAction.VISIT_COUNT).toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 启动的时候读取指定的文件中的数字, 并存入到ServletContext对象中
	public void contextInitialized(ServletContextEvent se) {
		// 拿到存储信息的文本路径
		String filePath = se.getServletContext().getRealPath("/fcount");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			Integer count = Integer.parseInt(br.readLine());
			se.getServletContext().setAttribute(LoginAction.VISIT_COUNT, count);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
