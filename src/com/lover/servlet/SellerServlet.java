package com.lover.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.entity.Seller;
import com.lover.service.SellerService;
import com.lover.service.impl.SellerServiceImpl;

public class SellerServlet {
	SellerService ss = new SellerServiceImpl();
	public void sellerStart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****商家 首页****");
		request.getRequestDispatcher("/seller/sellerPage.jsp").forward(request, response);
	}
	public void sellerLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****商家登录 ****");
		request.getRequestDispatcher("/seller/sellerLogin.jsp").forward(request, response);
	}
	public void LoginCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("*****登录校验存数据 ****");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		System.out.println(name + pwd);
		if (pwd.equals(ss.getPassword(name)))
		{
			//账号密码成功了
			//判断状态
			if(ss.getStatus(name).equals("审核失败")) {
				request.getRequestDispatcher("/seller/fail.jsp").forward(request, response);
			}else if(ss.getStatus(name).equals("待审核")) {
				request.getRequestDispatcher("/seller/check.jsp").forward(request, response);
			}else {
				HttpSession se = request.getSession();
				se.setAttribute("sellerId", ss.getId(name));
				se.setAttribute("sellerName", name);
				//跳转列表界面
				request.getRequestDispatcher("/SellerServlet_sellerCenter.do").forward(request, response);
			}
		}else{
			request.setAttribute("errMsg", "用户名或密码错误!");
			request.getRequestDispatcher("/SellerServlet_sellerLogin.do").forward(request, response);
		}
	}
	public void sellerCenter(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("*****商家中心订单 ****");
		ArrayList<Blind> blind = ss.selectBlind((String)request.getSession().getAttribute("sellerId"),"成功","待反馈");
		System.out.println(blind);
		ArrayList<Basic> man = new ArrayList<>();
		ArrayList<Basic> woman = new ArrayList<>();
		for (Blind b : blind) {
			int m = b.getMan_id();
			int w = b.getWoman_id();
			Basic b1 = ss.selectCouple(new Integer(m).toString());
			Basic b2 = ss.selectCouple(new Integer(w).toString());
			man.add(b1);
			woman.add(b2);
		}
		System.out.println(man);
		System.out.println(woman);
		request.setAttribute("blind", blind);
		request.setAttribute("man", man);
		request.setAttribute("woman", woman);
		request.getRequestDispatcher("/seller/sellerOrder.jsp").forward(request, response);
	}
	
	public void sellerUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("*****商家个人中心 ****");
		request.getRequestDispatcher("/seller/sellerUpdate.jsp").forward(request, response);
	}
	
	public void sellerAlterDate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("*****商家资料 ****");
		String id = (String) request.getSession().getAttribute("sellerId");
		Seller seller = ss.selectSellerData(id);
		String[] address = seller.getSaddress().split("-");
		for (int i = 0; i < address.length; i++) {
			System.out.println(address[i]);
		}
		String[] time = seller.getSdate().split("-");
		for (int i = 0; i < time.length; i++) {
			System.out.println(time[i]);
		}
		request.setAttribute("sellerData", seller);
		request.setAttribute("address", address);
		request.setAttribute("time", time);
		request.getRequestDispatcher("/seller/sellerAlterData.jsp").forward(request, response);
	}
	public void sellerLeague(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****商家加盟 ****");
		request.getRequestDispatcher("/seller/sellerRegister.jsp").forward(request, response);
	}
	
	public void sellerRegisterCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****商家名称校验 ****");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		PrintWriter pWriter = response.getWriter();
		if (!ss.getId(name).equals("")) {
			pWriter.print("商家名称已存在!");
		} else {
			//ss.insertSeller();
			pWriter.print("商家名称可以注册!");
		}
	}
	
	public void sellerRegister(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****商家注册 ****");
		String name = request.getParameter("name");
		System.out.println(name);
		String summary = request.getParameter("summary");
		String sheng = request.getParameter("sheng");
		String shi  = request.getParameter("shi");
		String xian = request.getParameter("xian");
		String address = sheng+"-"+shi+"-"+xian;
		System.out.println(address);
		String week = request.getParameter("week");
		String time = request.getParameter("time");
		String servicetime = week+"-"+time;
		System.out.println(servicetime);
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String question =request.getParameter("q");
		String answer = request.getParameter("answer");
		
		if(ss.getId(name).equals("")){
			ss.insertSeller(name,summary,address,servicetime,phone,password,question,answer);
			request.getRequestDispatcher("/seller/check.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "用户名已存在不能重复注册!");
			request.getRequestDispatcher("/SellerServlet_sellerLeague.do").forward(request, response);
		}
	}
	
	public void sellerUpdateData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****商家修改资料 ****");
		String id = (String) request.getSession().getAttribute("sellerId");
		String name = (String) request.getSession().getAttribute("sellerName");
		//String name = request.getParameter("name");
		//System.out.println(name);
		String summary = request.getParameter("summary");
		System.out.println(summary);
		String sheng = request.getParameter("sheng");
		String shi  = request.getParameter("shi");
		String xian = request.getParameter("xian");
		String address = sheng+"-"+shi+"-"+xian;
		System.out.println(address);
		String week = request.getParameter("week");
		String time = request.getParameter("time");
		String servicetime = week+"-"+time;
		System.out.println(servicetime);
		String phone = request.getParameter("phone");
		System.out.println("ssssss");
		ss.updateSeller(id,summary,address,servicetime,phone);
		request.getRequestDispatcher("/SellerServlet_sellerAlterDate.do").forward(request, response);
	}
	
	
	
	public void changeBlind(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****修改牵手状态 ****");
		String bindId =request.getParameter("id");
		System.out.println(bindId);
		ss.changeStatus(bindId,"成功");
		System.out.println(ss.getManId(bindId)+","+ss.getWomanId(bindId));
		ss.alterUserStatus(ss.getManId(bindId),ss.getWomanId(bindId),"相亲成功");
		
		request.getRequestDispatcher("/SellerServlet_sellerCenter.do").forward(request, response);
	}
	
	public void changeFail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("*****牵手失败状态 ****");
		String id =request.getParameter("id");
		System.out.println(id);
		ss.handFail(id,"待就绪",+10);
		ss.alterUserStatus(ss.getManId(id),ss.getWomanId(id),"待就绪");
		System.out.println(ss.getManId(id)+","+ss.getWomanId(id));
		request.getRequestDispatcher("/SellerServlet_sellerCenter.do").forward(request, response);
	}

}
