package com.tz.online.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.User;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/book/register")
public class RegisterAction extends HttpServlet {


	private static final long serialVersionUID = 1647121386052022075L;
	private IUserService userService = (IUserService) BeanFactory.createBeans("userService");
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	    String userName=req.getParameter("user");
    	    String passWord=req.getParameter("pwd");
    	    String email=req.getParameter("email");
    	    String phone=req.getParameter("phone");
    	    String company=req.getParameter("company");
    	    String address=req.getParameter("address");
    	    
    	   // System.out.println(userName+"**"+passWord+"**"+email+"**"+phone+"**"+company+"**"+address);
    	    
    	    User user=new User();
    	    user.setUserName(userName);
    	    user.setPassWord(passWord);
    	    user.setEmail(email);
    	    user.setPhone(phone);
    	    user.setCompany(company);
    	    user.setAddress(address);
    	    userService.register(user);
    	    
    	    resp.sendRedirect(req.getContextPath()+ "/book/list");
    	
    	    
    }
}
