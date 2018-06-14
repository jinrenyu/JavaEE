package com.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class SimplateDataSource {

    // �������ģʽ[��������(���̰߳�ȫ��)/��������(�̰߳�ȫ��)...]
    // ��������
    private static final SimplateDataSource ds = new SimplateDataSource();
    private static final String FILEPATH = "db_config.properties";
    private static Properties prop = new Properties();
    private static BasicDataSource bs = null;
    
    static {
        InputStream inStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(FILEPATH);
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bs = new BasicDataSource();
        // ����������·��
        bs.setDriverClassName(prop.getProperty("oracleDriver"));
        // ����URL
        bs.setUrl(prop.getProperty("url"));
        // �����û���
        bs.setUsername(prop.getProperty("user"));
        // ��������
        bs.setPassword(prop.getProperty("password"));

        // ���ù������ӵĲ���
        // �������ӳ��ڵĳ�ʼ���ӵ���Ŀ
        bs.setInitialSize(Integer.parseInt(prop.getProperty("initialSize")));
        // �������ӳ��ڻ���ӵ��������
        bs.setMaxActive(Integer.parseInt(prop.getProperty("maxActive")));
        // �������ӳ��������е���������
        bs.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        // �������ӵ����ȴ�ʱ��(��λ:����)
        bs.setMaxWait(Integer.parseInt(prop.getProperty("maxWait")));
    }
    // ����/��������
//    private static SimplateDataSource ds = null;
    // ��һ��, �ѹ��췽�����˽�е�, ��ֹ�����µ�ʵ��
    private SimplateDataSource() {}

    // �ڶ���, �ṩһ������ʵ���ķ���, ���뱣֤�����ص�ʵ����һ������ʵ��
    public static SimplateDataSource getInstance() {
        return ds;
    }

    public Connection getConnection() throws SQLException {
        return bs == null ? null : bs.getConnection();
    }
}
