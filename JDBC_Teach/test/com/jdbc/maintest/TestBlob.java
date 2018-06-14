package com.jdbc.maintest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.util.JdbcUtil;

public class TestBlob {

    public void upload(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("目标文件不存在......");
        } else if (file.isDirectory()) {
            System.out.println("目标文件为一个目录......");
        } else {
            // 连接数据库完成对文件的读取并插入到数据库中
            upload(file);
        }
    }

    private void upload(File file) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JdbcUtil.getConnection();
            // 定制SQL模板
            String sql = "insert into t_file values(seq_file_id.nextval, ?, sysdate, ?)";
            pst = conn.prepareStatement(sql);
            // 创建一个Blob对象用于存在要插入的二进制数据, 相当于一个胶囊的外壳
            Blob blob = conn.createBlob();
            // 读取文件的内容, 把二进制数据写入到blob实例中, 相当于把药粉放入胶囊中去
            writeData(blob, file);
            // 设置参数
            pst.setString(1, file.getName());
            pst.setBlob(2, blob);
            pst.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeData(Blob blob, File file) {
        try(
                // 通过文件输入流读取文件
                BufferedInputStream bIn = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bOut = new BufferedOutputStream(blob.setBinaryStream(1))
                ) {
            int len = -1;
            int total = 0;
            byte[] bytes = new byte[2 * 1024];
            while((len = bIn.read(bytes)) != -1) {
                bOut.write(bytes);
                total += len;
                System.out.println("上传了" + total + "字节的数据");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    public void download(int id, String dirPath) {
        String sql = "select * from t_file where id = " + id;
        try (
                Connection conn = JdbcUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                ) {
            // 如果根据传入id在数据库中查询到了记录, 进行下载
            if (rs.next()) {
                String fileName = rs.getString(2);
                Blob blob = rs.getBlob(4);
                File file = new File(dirPath + File.separator + fileName);
                download(file, blob);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void download(File file, Blob blob) {
        try(
                // 读取blob对象到内存中并输出到指定文件内
                BufferedInputStream bIn = new BufferedInputStream(blob.getBinaryStream());
                BufferedOutputStream bOut = new BufferedOutputStream(new FileOutputStream(file))
                ) {
            int len = -1;
            int total = 0;
            byte[] bytes = new byte[2 * 1024];
            while((len = bIn.read(bytes)) != -1) {
                bOut.write(bytes);
                total += len;
                System.out.println("下载了" + total + "字节的数据");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new TestBlob().upload("D:/06.jpg");
        new TestBlob().download(1, "E:");
    }
    
}
