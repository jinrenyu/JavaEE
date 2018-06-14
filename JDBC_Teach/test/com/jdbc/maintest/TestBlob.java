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
            System.out.println("Ŀ���ļ�������......");
        } else if (file.isDirectory()) {
            System.out.println("Ŀ���ļ�Ϊһ��Ŀ¼......");
        } else {
            // �������ݿ���ɶ��ļ��Ķ�ȡ�����뵽���ݿ���
            upload(file);
        }
    }

    private void upload(File file) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JdbcUtil.getConnection();
            // ����SQLģ��
            String sql = "insert into t_file values(seq_file_id.nextval, ?, sysdate, ?)";
            pst = conn.prepareStatement(sql);
            // ����һ��Blob�������ڴ���Ҫ����Ķ���������, �൱��һ�����ҵ����
            Blob blob = conn.createBlob();
            // ��ȡ�ļ�������, �Ѷ���������д�뵽blobʵ����, �൱�ڰ�ҩ�۷��뽺����ȥ
            writeData(blob, file);
            // ���ò���
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
                // ͨ���ļ���������ȡ�ļ�
                BufferedInputStream bIn = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bOut = new BufferedOutputStream(blob.setBinaryStream(1))
                ) {
            int len = -1;
            int total = 0;
            byte[] bytes = new byte[2 * 1024];
            while((len = bIn.read(bytes)) != -1) {
                bOut.write(bytes);
                total += len;
                System.out.println("�ϴ���" + total + "�ֽڵ�����");
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
            // ������ݴ���id�����ݿ��в�ѯ���˼�¼, ��������
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
                // ��ȡblob�����ڴ��в������ָ���ļ���
                BufferedInputStream bIn = new BufferedInputStream(blob.getBinaryStream());
                BufferedOutputStream bOut = new BufferedOutputStream(new FileOutputStream(file))
                ) {
            int len = -1;
            int total = 0;
            byte[] bytes = new byte[2 * 1024];
            while((len = bIn.read(bytes)) != -1) {
                bOut.write(bytes);
                total += len;
                System.out.println("������" + total + "�ֽڵ�����");
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
