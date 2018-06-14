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
        // 1. 先判断目标文件是否存在
        // 2. 判断其是否是一个目录
        // 3. 判断该文件是否以.sql结尾
        // 4. 如果是一个有效的SQL文件, 使用字符流进行逐行解析
        // 5. 把读取到的行首尾的空格去掉
        // 6. 跳过对'--'或者'rem'开头的解析,以及读取到的行的字符长度为0的
        // 7. 如果读取到的行不是以;结尾的, 为它的最后添加上一个空格
        // 8. 直至解析完所有的脚本文件,放在一个字符串中
        // 9. 以;为标示进行分割,得到有效SQL语句的一个数组
        // 10. 依次执行这些有效的SQL语句
        // 定义一个文件对象,便于接下去的文件操作判定
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("目标路径下不存在文件......");
        } else if (file.isDirectory()) {
            System.out.println("目标文件为一个目录......");
        } else if (file.getName().endsWith(".sql")) {
            // 开始读取文件进行解析
            // 定义一个变量存储读取到的行内容
            String line = null;
            StringBuilder builder = new StringBuilder();
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(file));
                while ((line = bf.readLine()) != null) {
                    // 去掉首位的空格
                    line = line.trim();
                    // 跳过无效Sql行的解析
                    if (line.startsWith("--")
                            || line.startsWith("rem")
                            || line.length() == 0) {
                        continue;
                    }
                    // 把有效的Sql语句加入到一个存在总的Sql语句的对象中
                    builder.append(line).append(" ").append("\n");
                }
                for (String sql : builder.toString().split(";\\s*\\n?")) {
                    // 执行有效的Sql语句
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
            System.out.println("目标文件不是一个有效的Sql脚本......");
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
                // 拿到结果集并打印查询结果
                rs = st.getResultSet();
                // 结果集的'元数据'
                // TODO
            } else {
                // 获取更新语句受影响的行数
                int num = st.getUpdateCount();
                System.out.println("影响了[" + num + "]条记录");
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
