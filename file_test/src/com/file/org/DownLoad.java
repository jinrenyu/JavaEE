package com.file.org;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����post��ʽ�ύ������, ��Ҫ���ñ�������ֹ����
		// request.setCharacterEncoding("utf-8");
		// ��Ҫ�õ��û�Ҫ���ص��ļ�������
		String fileName = request.getParameter("fileName");
		String storePath = "D:";
		String totalPath = storePath + File.separator + fileName;
		File file = new File(totalPath);
		// �ж��û�������ļ��Ƿ����
		if (file.exists()) {
			// ������Ӧ����, ����ǰ���ܲ�������Ӧ�������������Ϣ���
			response.reset();
			// ������360/Chrome/IE8�Ժ���Խ����������
			// fileName = URLEncoder.encode(fileName, "UTF-8");
			// ��Ի����������Ľ������
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			// ������Ӧ�����ͷ��Ϣ, ��֪���������һ�����и�������Ӧ, ����������ض���
			// ��֪����������ص���Ϣ��һ������, ��Ҫִ�����ز���
			response.addHeader("Content-Type", "application/x-msdownload");
			// ��֪�����, ��Ӧͷ��ĸ�������ʲô
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
			// ��֪�����, ���������ݴ�С
			response.addHeader("Content-Length", String.valueOf(file.length()));
			// ��ȡ�������û�������ļ�
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			// ��ȡ�����ظ��û��������
			OutputStream out = response.getOutputStream();
			byte[] buffer = new byte[2 * 1024];
			int len = -1;
			while ((len = in.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer, 0, len);
			}
			// �����Ӧ���еĻ��浽��������, ��ֹ������д���һЩû�д����������
			out.flush();
			out.close();
			in.close();
		} else {
			response.setContentType("text/html;charset=utf-8");
			// �ȼ���
			// response.addHeader("Content-Type", "text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println("<script>alert('����������ӵ�ַ�Ѿ�ʧЧ');</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
