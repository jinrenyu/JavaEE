package com.file.org;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

@WebServlet("/FileUpload25")
public class FileUpload25 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUpload25() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �ж��ύ�ı���enctype�Ƿ���multipart/form-data����.��,����true;��֮false
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// ���������ϴ��ļ��Ĺ�����ʵ��
			ServletFileUpload fileupload = new ServletFileUpload();
			// ���������ļ�ͷ�ı��뷽ʽ, ���������������
			fileupload.setHeaderEncoding("utf-8");
			try {
				// �ѱ��ڵ�input������һ����Fileitem����
				FileItemIterator fileItem = fileupload.getItemIterator(request);
				// �ж��ύ�ı����Ƿ���б�����
				while(fileItem.hasNext()) {
					// fileItemStream���а����˱��и���input������(һ��)
					FileItemStream fileItemStream = fileItem.next();
					// �õ������������
					InputStream in = fileItemStream.openStream();
					// �õ������name����
					String formFiled = fileItemStream.getFieldName();
					// �жϵ�ǰ�ı����Ƿ�����ͨ����(����type=file��������input)
					if (fileItemStream.isFormField()) {
						// ���û�����ͨ���������������
						String formValue = Streams.asString(in, "utf-8");
						System.out.println("��ͨ����name����Ϊ:" + formFiled + ", ֵΪ"
								+ formValue);
					} else {
						// ��ȡ���ϴ��ļ����ļ���
						String fileName = fileItemStream.getName();
						System.out.println("�ϴ���ԭ�ļ���Ϊ:" + fileName);
						// ����ҵ�������Դ洢�ļ������ֽ��й涨, 
						// �˴�ʹ�õ�ǰʱ��+�ϴ��ļ���׺���ķ�ʽ���������ļ�
						// ����hello.txt
						String suffix = "";
						if ("".equals(fileName)) {
							continue;
						}
						if (fileName.contains(".")) {
							suffix = fileName.substring(fileName.lastIndexOf("."));
						}
						// ƴ�ӳ�����������ļ���(312312421.txt)
						String renamedFile = new Date().getTime() + suffix;
						String storePath = getServletContext().getRealPath("/WEB-INF/uploadFiles");
						// ƴ�Ӵ洢�ļ���Ŀ¼·��������������ļ���, �õ�һ������·��
						String totalPath = storePath + File.separator + renamedFile;
						// ��ȡҪ��д���ļ��������
						BufferedOutputStream out = new BufferedOutputStream(
								new FileOutputStream(totalPath));
						// ��ȡ���ļ���д�뵽ָ�����ļ�������ϴ�
						byte[] buffer = new byte[2 * 1024];
						int len = -1;
						while((len = in.read(buffer, 0, buffer.length)) != -1) {
							out.write(buffer, 0, len);
						}
						out.close();
					}
					in.close();
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
