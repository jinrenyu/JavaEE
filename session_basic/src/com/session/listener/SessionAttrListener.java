package com.session.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttrListener implements HttpSessionAttributeListener {

	public SessionAttrListener() {
	}

	// ÿ��session�������в�������ӵ�ʱ��ͻ���ø÷���
	// ������������Щ����, ���Բ���������˺͸ı�
	public void attributeAdded(HttpSessionBindingEvent se) {
		String str = (String) se.getValue();
		str += "TTTTTTTTT";
		se.getSession().setAttribute("data01", str);
		System.out.println("������Ϊ: " + se.getName() + "�Ĳ�������ӽ�Session��");
	}

	// ÿ��session�������в�����ɾ����ʱ��ͻ���ø÷���
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("������Ϊ: " + se.getName() + "�Ĳ������Ƴ�");
	}

	// ÿ��session�������в������滻��ʱ��ͻ���ø÷���
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("������Ϊ: " + se.getName() + "�Ĳ������滻");
	}

}
