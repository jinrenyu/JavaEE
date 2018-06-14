package com.jdbc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLUtil {
    
    public static void execute(String path) {
        // 1. ���ж�Ŀ���ļ��Ƿ����
        // 2. �ж����Ƿ���һ��Ŀ¼
        // 3. �жϸ��ļ��Ƿ���.sql��β
        // 4. �����һ����Ч��SQL�ļ�, ʹ���ַ����������н���
        // 5. �Ѷ�ȡ��������β�Ŀո�ȥ��
        // 6. ������'--'����'rem'��ͷ�Ľ���,�Լ���ȡ�����е��ַ�����Ϊ0��
        // 7. �����ȡ�����в�����;��β��, Ϊ������������һ���ո�
        // 8. ֱ�����������еĽű��ļ�,����һ���ַ�����
        // 9. ��;Ϊ��ʾ���зָ�,�õ���ЧSQL����һ������
        // 10. ����ִ����Щ��Ч��SQL���
        // ����һ���ļ�����,���ڽ���ȥ���ļ������ж�
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Ŀ��·���²������ļ�......");
        } else if (file.isDirectory()) {
            System.out.println("Ŀ���ļ�Ϊһ��Ŀ¼......");
        } else if (file.getName().endsWith(".sql")) {
            // ��ʼ��ȡ�ļ����н���
            // ����һ�������洢��ȡ����������
            String line = null;
            StringBuilder builder = new StringBuilder();
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(file));
                while ((line = bf.readLine()) != null) {
                    // ȥ����λ�Ŀո�
                    line = line.trim();
                    // ������ЧSql�еĽ���
                    if (line.startsWith("--")
                            || line.startsWith("rem")
                            || line.length() == 0) {
                        continue;
                    }
                    // ����Ч��Sql�����뵽һ�������ܵ�Sql���Ķ�����
                    builder.append(line).append(" ").append("\n");
                }
                for (String sql : builder.toString().split(";\\s*\\n?")) {
                    // ִ����Ч��Sql���
                    executeSql(sql);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bf != null) {
                    try {
                        bf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Ŀ���ļ�����һ����Ч��Sql�ű�......");
        }
    }

    private static void executeSql(String sql) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.createStatement();
            System.out.println(sql);
            boolean flag = st.execute(sql);
            if (flag) {
                // �õ����������ӡ��ѯ���
                rs = st.getResultSet();
                // �������'Ԫ����'
                // TODO
            } else {
                // ��ȡ���������Ӱ�������
                int num = st.getUpdateCount();
                System.out.println("Ӱ����[" + num + "]����¼");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(rs, st, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        DDLUtil.execute("d:/init_student.sql");
    }
}
