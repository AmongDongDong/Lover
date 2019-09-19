package com.lover.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lover.entity.Attention;
import com.lover.entity.Basic;
import com.lover.service.ForgetService;
import com.lover.service.impl.ForgetServiceImpl;
import com.lover.util.CheckSumBuilder;
import com.lover.util.SendCode;

/**
 * 忘记密码
 * @author Administrator
 *
 */
public class ForgetServlet {

	ForgetService fs = new ForgetServiceImpl();
	
	
	public void ajaxEnter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====enter-ajax=====");
		//1.获取电话号码
		response.setContentType("textml; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String vali = null;
		try {
			vali = SendCode.getStringNum(phone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过PrintWriter将信息响应
		PrintWriter pWriter = response.getWriter();
		pWriter.write(vali);
		
	}
	
	public void enterReset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====enter-reset=====");
		//1.获取电话号码
		request.setCharacterEncoding("utf-8");
		String telforget = request.getParameter("phone");
		request.getSession().setAttribute("telforget", telforget);
		request.getRequestDispatcher("/login-register/forget3.jsp").forward(request, response);	
	}
	
	public void resetPhonePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("=========reset-PhonePassword==========");
		//1.获得新密码
		String password =CheckSumBuilder.getMD5(request.getParameter("password1"));
		String telforget = (String) request.getSession().getAttribute("telforget");
		
		//2.修改密码
		fs.updatePassword(telforget, password);
		
		//3.跳转
		request.getRequestDispatcher("/propaganda.jsp").forward(request, response);
		
	}
	
	

}
