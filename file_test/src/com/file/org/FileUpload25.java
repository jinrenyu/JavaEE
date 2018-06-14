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
		// 判断提交的表单的enctype是否是multipart/form-data类型.是,返回true;反之false
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 创建解析上传文件的工具类实例
			ServletFileUpload fileupload = new ServletFileUpload();
			// 可以设置文件头的编码方式, 解决中文乱码问题
			fileupload.setHeaderEncoding("utf-8");
			try {
				// 把表单内的input表单项变成一个个Fileitem对象
				FileItemIterator fileItem = fileupload.getItemIterator(request);
				// 判断提交的表单内是否具有表单数据
				while(fileItem.hasNext()) {
					// fileItemStream就中包含了表单中各项input的数据(一个)
					FileItemStream fileItemStream = fileItem.next();
					// 拿到表单项的输入流
					InputStream in = fileItemStream.openStream();
					// 拿到表单项的name属性
					String formFiled = fileItemStream.getFieldName();
					// 判断当前的表单项是否是普通表单项(除了type=file的其他表单input)
					if (fileItemStream.isFormField()) {
						// 把用户的普通表单项的输入变成文字
						String formValue = Streams.asString(in, "utf-8");
						System.out.println("普通表单的name属性为:" + formFiled + ", 值为"
								+ formValue);
					} else {
						// 获取到上传文件的文件名
						String fileName = fileItemStream.getName();
						System.out.println("上传的原文件名为:" + fileName);
						// 根据业务的需求对存储文件的名字进行规定, 
						// 此处使用当前时间+上传文件后缀名的方式来重命名文件
						// 例如hello.txt
						String suffix = "";
						if ("".equals(fileName)) {
							continue;
						}
						if (fileName.contains(".")) {
							suffix = fileName.substring(fileName.lastIndexOf("."));
						}
						// 拼接出重命名后的文件名(312312421.txt)
						String renamedFile = new Date().getTime() + suffix;
						String storePath = getServletContext().getRealPath("/WEB-INF/uploadFiles");
						// 拼接存储文件的目录路径和重命名后的文件名, 得到一个绝对路径
						String totalPath = storePath + File.separator + renamedFile;
						// 获取要书写的文件的输出流
						BufferedOutputStream out = new BufferedOutputStream(
								new FileOutputStream(totalPath));
						// 读取流文件并写入到指定的文件中完成上传
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
