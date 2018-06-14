package com.file.org;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// �ֱ�涨�ϴ����ļ���С���ܳ������ٱ���, ����Ĵ�С���ܳ������ٱ���
// -1��ʾû������
@MultipartConfig(maxFileSize=-1, maxRequestSize=-1)
@WebServlet("/FileUpload30")
public class FileUpload30 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUpload30() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String message = part.getHeader("Content-Disposition");
			// ������ϵ�IE�����, message������:form-data; name="file01"; filename="D:\CELSÿ������\jd-gui.cfg"
			// �µ��������Ϊ: form-data; name="file01"; filename="jd-gui.cfg"
			// System.out.println(message);
			String[] strArr = message.split(";");
			// 1. ������ͨ��, ����ֻ��ӡ��ͨ����ֵ
			// ��ͨ�������Ϣ: form-data; name="pText"
			// ˵������һ����ͨ����
			if (strArr.length < 3) {
				// �������ڶ�������ֵ, ������name��ñ��е�value
				// '='�ָ�ɹ���{name, "pText"}
				String pName = strArr[1].split("=")[1].replaceAll("\"", "");
				System.out.println("��ͨ�����nameΪ:" + pName + ", ��Ӧ��ֵΪ:"
						+ request.getParameter(pName));
				continue;
			}
			// 2. ����type=file, �����û�û�н����ϴ��ĵط�, ���ǿ���ֱ���Թ�
			// û���ϴ��ļ��ı���:
			// form-data; name="file02"; filename=""
			// strArr[2]����:filename=""
			if ("".equals(strArr[2].split("=")[1].replaceAll("\"", ""))) {
				continue;
			}
			// 3. �����ṩ���û�����ϴ�, �����û��ύ���ļ�, ����������, ʹ��part.write(��ŵ�·��)������ϴ�
			// form-data; name="file01"; filename="D:\CELSÿ������\jd-gui.cfg"
			// tempStr����: "D:\CELSÿ������\jd-gui.cfg"
			String tempStr = strArr[2].split("=")[1];
			String fileName = tempStr.substring(tempStr.lastIndexOf("\\") + 1)
					.replaceAll("\"", "");
			String storePath = getServletContext().getRealPath("/WEB-INF/uploadFiles");
			part.write(storePath + File.separator + fileName);
			// servlet3.1�汾����ͨ��
			// part.getSubmittedFileName();��ȡ���ļ�������
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
