package com.lover.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lover.service.AlipayService;
import com.lover.service.impl.AlipayServiceImpl;

public class AlipayServlet {
	AlipayService as = new AlipayServiceImpl();
	/**
	 * 成为VIP，并跳转首页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void becomeVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.拿到用户ID，并修改VIP等级
		String id =(String) request.getSession().getAttribute("userId");
		as.updateGrade(id);
		
		//2.跳转进入首页的Servlet
		request.getRequestDispatcher("/FirstServlet_enterFirst.do").forward(request, response);
	}
}
