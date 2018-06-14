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

// 分别规定上传的文件大小不能超过多少比特, 请求的大小不能超过多少比特
// -1表示没有限制
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
			// 如果是老的IE浏览器, message会形如:form-data; name="file01"; filename="D:\CELS每天任务单\jd-gui.cfg"
			// 新的浏览器则为: form-data; name="file01"; filename="jd-gui.cfg"
			// System.out.println(message);
			String[] strArr = message.split(";");
			// 1. 对于普通表单, 我们只打印普通表单的值
			// 普通表单项的信息: form-data; name="pText"
			// 说明这是一个普通表单项
			if (strArr.length < 3) {
				// 解析出第二参数的值, 并根据name获得表单中的value
				// '='分割成功后{name, "pText"}
				String pName = strArr[1].split("=")[1].replaceAll("\"", "");
				System.out.println("普通表单项的name为:" + pName + ", 对应的值为:"
						+ request.getParameter(pName));
				continue;
			}
			// 2. 对于type=file, 但是用户没有进行上传的地方, 我们可以直接略过
			// 没有上传文件的表单项:
			// form-data; name="file02"; filename=""
			// strArr[2]代表:filename=""
			if ("".equals(strArr[2].split("=")[1].replaceAll("\"", ""))) {
				continue;
			}
			// 3. 对于提供了用户浏览上传, 并且用户提交了文件, 则正常解析, 使用part.write(存放的路径)来完成上传
			// form-data; name="file01"; filename="D:\CELS每天任务单\jd-gui.cfg"
			// tempStr代表: "D:\CELS每天任务单\jd-gui.cfg"
			String tempStr = strArr[2].split("=")[1];
			String fileName = tempStr.substring(tempStr.lastIndexOf("\\") + 1)
					.replaceAll("\"", "");
			String storePath = getServletContext().getRealPath("/WEB-INF/uploadFiles");
			part.write(storePath + File.separator + fileName);
			// servlet3.1版本可以通过
			// part.getSubmittedFileName();获取到文件的名字
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
