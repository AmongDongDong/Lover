package com.lover.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lover.service.SecretService;
import com.lover.service.UserService;
import com.lover.service.impl.SecretServiceImpl;
import com.lover.service.impl.UserServiceImpl;
import com.lover.util.CheckSumBuilder;


public class SecretServlet {
	SecretService us = new SecretServiceImpl();
	
	public void findSecret(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("****找回密码手机号方式*****");
		request.getRequestDispatcher("/login-register/forget1.jsp").forward(request, response);
	}
	public void verifyPhone(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("****验证手机*****");
		
		request.getRequestDispatcher("/login-register/forget4.jsp").forward(request, response);
		request.getRequestDispatcher("/SecretServlet_findSecret.do").forward(request, response);
	}
	public void secretQuestion(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("****密保问题*****");
		request.getRequestDispatcher("/login-register/forget2.jsp").forward(request, response);
	}
	public void secretForget2(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("****密保问题2*****");
		String phone = request.getParameter("phone");
		String question = request.getParameter("q");
		String answer = request.getParameter("answer");
		System.out.println(question+answer+phone);
		//String phone = "18756904538";
		System.out.println(us.findQuestion(phone));
		if (us.findQuestion(phone).equals(question)){
			if (answer.equals(us.getAnswer(phone))){
				request.setAttribute("phoneNumber", phone);
				request.getRequestDispatcher("/login-register/forget4.jsp").forward(request, response);
			}else {
				request.setAttribute("errMsg", "密保问题或答案错误!");
				request.getRequestDispatcher("/SecretServlet_secretQuestion.do").forward(request, response);
			}
		}else {
			request.setAttribute("errMsg", "手机号码与问题不匹配");
			request.getRequestDispatcher("/SecretServlet_secretQuestion.do").forward(request, response);
		}
	}
	public void updatePwd(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("****修改密码*****");
		String phone = request.getParameter("telephone");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		System.out.println(password1+"***"+password2+"***");
		//String phone = "18756904538";/*(String) request.getSession().getAttribute("phone");*/
		//这里的手机号是从上面得到的
		String id = us.getId(phone);
		System.out.println(id);
		if (password1.equals(password2)) {
			us.updatePassword(CheckSumBuilder.getMD5(password1),id);
			
			//密码修改成功，请重新登录，页面即将跳转
			request.getRequestDispatcher("/propaganda.jsp").forward(request, response);
			
		}else {
			request.setAttribute("errorMsg", "两次输入密码不一致!");
			request.getRequestDispatcher("/login-register/forget4.jsp").forward(request, response);
		}
	}
}
