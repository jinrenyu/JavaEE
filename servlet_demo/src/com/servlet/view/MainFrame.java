package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.action.LoginAction;

public class MainFrame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ��Ϊ�洢�û���һ�η���ʱ��cookie�е�name���Ե�ֵ
	public static final String LVISIT_KEY = "lvisit";
       
    public MainFrame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 1. ��ȡ���ڵ�ʱ��, ������yyyy-MM-dd HH:mm:ss�ķ�ʽת�����ַ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strNow = sdf.format(new Date());
		// ��ȡ�ͻ��˷��͹���������cookie��Ϣ
		Cookie[] cookies = request.getCookies();
		// ����һ����ʶ����, �����û��ǵ�һ�ε�¼
		boolean isFirst = true;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				// ȥ���Ի�ȡ�洢��һ�η��ʵ�ʱ���cookie�ֶ�
				if(LVISIT_KEY.equals(cookie.getName())) {
					isFirst = false;
					out.println("����������һ�η��ʸ���վ��ʱ��Ϊ: " + cookie.getValue());
					// ��Ҫ����cookie�д洢����һ�εķ���ʱ��
					cookie.setValue(strNow);
					// �󲿷�������ڷ���cookie��Ϣ��ʱ�򲢲��ḽ��cookie�Ĺ���ʱ��
					// �������������value������������ʱ��, �ͻ��������ʱ�䱻����
					// Ϊ"��ǰ�Ự����", �����Ҫ���Ϳ���ʹ��js����cookie���з���
					cookie.setMaxAge(7 * 24 * 3600);
					// ����Ѹ��ºõ�cookie���·��ظ��ͻ���
					response.addCookie(cookie);
				}
			}
		}
		// ����ǵ�һ�ε�¼�������Ӧ����ʾ��Ϣ, ���ѵ�ǰʱ��洢��cookie�з��ظ��û�
		if (isFirst) {
			out.println("������������һ�η������ǵ�վ��");
			Cookie lTime = new Cookie(LVISIT_KEY, strNow);
			// ��cookie���һ�ܵ�ʱ��
			lTime.setMaxAge(7 * 24 * 3600);
			response.addCookie(lTime);
		}
		out.println("<p>���Ǳ���վ�ĵ�" + getServletContext().getAttribute(LoginAction.VISIT_COUNT) + "λ�ÿ�</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
