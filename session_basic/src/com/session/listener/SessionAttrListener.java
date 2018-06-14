package com.session.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttrListener implements HttpSessionAttributeListener {

	public SessionAttrListener() {
	}

	// 每当session对象中有参数被添加的时候就会调用该方法
	// 它可以拦截这些参数, 来对参数进行审核和改变
	public void attributeAdded(HttpSessionBindingEvent se) {
		String str = (String) se.getValue();
		str += "TTTTTTTTT";
		se.getSession().setAttribute("data01", str);
		System.out.println("属性名为: " + se.getName() + "的参数被添加进Session中");
	}

	// 每当session对象中有参数被删除的时候就会调用该方法
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("属性名为: " + se.getName() + "的参数被移除");
	}

	// 每当session对象中有参数被替换的时候就会调用该方法
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("属性名为: " + se.getName() + "的参数被替换");
	}

}
