package com.lover.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lover.dao.impl.LoginDaoImpl;
import com.lover.entity.Basic;
import com.lover.service.LoginService;
import com.lover.service.impl.FirstServiceimpl;
import com.lover.service.impl.LoginServiceImpl;
import com.lover.util.CheckSumBuilder;
import com.lover.util.DateUtil;
import com.lover.util.FileCopy;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 登录Servlet
 * @author 肖双
 *
 */
public class LoginServlet {
	LoginService ls = new LoginServiceImpl();
	/**
	 * servlet 登录函数
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====login-Servlet=====");
		//获取用户填写的用户名密码，用户名为所注册的手机号码.
		String phone = request.getParameter("username");
		String password = request.getParameter("password");
		//判断账号密码正确性
		if(CheckSumBuilder.getMD5(password).equals(ls.getPassword(phone))) {
			//账号密码正确,将用户信息保存在session中，确保其他页面能够拿到
			HttpSession hs =request.getSession();
			Integer id = ls.getUserId(phone);
			hs.setAttribute("userId", id.toString());
			hs.setAttribute("userBasic", new FirstServiceimpl().queryUser(id.toString()));
			
			//跳转进入首页的servlet
			request.getRequestDispatcher("/FirstServlet_enterFirst.do").forward(request, response);
			
		}else {
			//失败
			request.setAttribute("error", "用户名密码错误");
			request.getRequestDispatcher("/propaganda.jsp").forward(request, response);
		}
	}
	
	/**
	 * servlet ajax查看电话号码是否存在的函数
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void existPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====existPhone-Servlet=====");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String phone = request.getParameter("phone");
		System.out.println(phone);

		
		//通过PrintWriter将信息响应
		PrintWriter pWriter = response.getWriter();
		if("".equals(ls.getPassword(phone))) {
			pWriter.write(" ");
		}else{
			pWriter.write("该号码已被注册");
		}
		
	}
	
	
	/**
	 * servlet 注册的数据写入数据库的函数
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws ParseException 
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		System.out.println("=====register-Servlet=====");
		//获得参数
		String sex = request.getParameter("sex");
		String date= request.getParameter("date");
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String xian = request.getParameter("xian");
		String marry = request.getParameter("marry");
		String edu = request.getParameter("edu");
		String salary = request.getParameter("salary");
		String phone = request.getParameter("phone");
		String password = CheckSumBuilder.getMD5(request.getParameter("password"));
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		//修改字符集
		request.setCharacterEncoding("utf-8");
		
		//使用Basic存数据
		Basic b1 = new Basic(0, 0, 0, 0, 0, answer,question, password, "待相亲", "logo.png", null, 0, salary, sheng+"/"+shi+"/"+xian, phone, 0, edu, marry, DateUtil.strToDate(date, "yyyy-MM-dd"), sex, null);
		
		//创建一个文件夹
		//获得userHead的路径
		String path = request.getServletContext().getRealPath("/userHead");
		File dir = new File(path+"/"+b1.getPhone());
		dir.mkdir();
		
		//给一张默认图片作为头像
		FileCopy.copyTxtFileBuffer(path+"/boy.jpg", path+"/"+b1.getPhone()+"/boy.jpg"); 
		FileCopy.copyTxtFileBuffer(path+"/girl.jpg", path+"/"+b1.getPhone()+"/girl.jpg"); 
		b1.setHead("logo.png");
		
		//将数据写入数据库
		ls.addUser(b1);
		request.getRequestDispatcher("/propaganda.jsp").forward(request, response);
	}
	
}
