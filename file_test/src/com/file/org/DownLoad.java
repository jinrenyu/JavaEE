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
		// 如果是post方式提交的请求, 需要设置编码来防止乱码
		// request.setCharacterEncoding("utf-8");
		// 需要得到用户要下载的文件的名字
		String fileName = request.getParameter("fileName");
		String storePath = "D:";
		String totalPath = storePath + File.separator + fileName;
		File file = new File(totalPath);
		// 判断用户请求的文件是否存在
		if (file.exists()) {
			// 重置响应对象, 把以前可能残留在响应对象里的其他信息清空
			response.reset();
			// 可以在360/Chrome/IE8以后可以解决中文乱码
			// fileName = URLEncoder.encode(fileName, "UTF-8");
			// 针对火狐中文乱码的解决方案
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			// 设置响应对象的头信息, 告知浏览器这是一个带有附件的响应, 让其产生下载动作
			// 告知浏览器被返回的消息是一个附件, 需要执行下载操作
			response.addHeader("Content-Type", "application/x-msdownload");
			// 告知浏览器, 响应头里的附件名叫什么
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
			// 告知浏览器, 附件的内容大小
			response.addHeader("Content-Length", String.valueOf(file.length()));
			// 读取服务上用户请求的文件
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			// 获取到返回给用户的输出流
			OutputStream out = response.getOutputStream();
			byte[] buffer = new byte[2 * 1024];
			int len = -1;
			while ((len = in.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer, 0, len);
			}
			// 清空响应流中的缓存到服务器端, 防止这个流中存在一些没有传输完的数据
			out.flush();
			out.close();
			in.close();
		} else {
			response.setContentType("text/html;charset=utf-8");
			// 等价于
			// response.addHeader("Content-Type", "text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println("<script>alert('您请求的链接地址已经失效');</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
