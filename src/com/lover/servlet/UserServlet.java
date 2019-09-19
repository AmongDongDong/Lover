package com.lover.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
/*import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;*/
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;
import com.lover.service.FirstService;
import com.lover.service.UserService;
import com.lover.service.impl.FirstServiceimpl;
import com.lover.service.impl.UserServiceImpl;
import com.mysql.fabric.xmlrpc.base.Array;

public class UserServlet {

	UserService us = new UserServiceImpl();
	FirstService fs = new FirstServiceimpl();
	public void enterbasic(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("================进入基本资料=============");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));
		Basic b = us.selectbasic(id);
		String[] p = b.getAddress().split("/");
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);

		}
		
		HttpSession htse = request.getSession();
		htse.setAttribute("basic", b);
		System.out.println(b);
		try {
			htse.setAttribute("basicplace", p);
			request.getRequestDispatcher("/personal/center.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void outbasic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====跳出基本资料=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String xian = request.getParameter("shi");
		String address = sheng + "/" + shi + "/" + xian;
		String salary = request.getParameter("salary");
		String height = request.getParameter("height");
		try {
			us.updatebasic(id, nickname, phone, address, salary, height);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("userBasic", fs.queryUser(id.toString()));
		request.getRequestDispatcher("/UserServlet_enterdetail.do").forward(request, response);
	}

	public void enterdetail(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("================进入详细资料=============");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id
		Detail d = us.selectdetail(id);
		HttpSession htse = request.getSession();
		if(d.getPlace()!=null) {
			String[] p = d.getPlace().split("/");
			for (int i = 0; i < p.length; i++) {
				System.out.println(p[i]);
	
			}
			request.setAttribute("place", p);
		}
		htse.setAttribute("detail", d);
		System.out.println(d);
		try {
			request.getRequestDispatcher("/personal/detail.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void outdetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====跳出详细资料=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String place = sheng + "/" + shi;
		String weight = request.getParameter("weight");
		String body = request.getParameter("body");
		String star = request.getParameter("star");
		String havechild = request.getParameter("havechild");
		String wantchild = request.getParameter("wantchild");
		String marry = request.getParameter("marry");
		String hearttalk = request.getParameter("hearttalk");
		try {
			us.updatedetail(id, place, weight, body, star, havechild, wantchild, marry, hearttalk);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("userBasic", fs.queryUser(id.toString()));
		request.getRequestDispatcher("/UserServlet_enterworklife.do").forward(request, response);
	}

	public void enterworklife(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("================进入工作生活=============");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id;// 用户id
		Worklife w = us.selectworklife(id);
		HttpSession htse = request.getSession();
		htse.setAttribute("worklife", w);
		System.out.println(w);
		try {
			request.getRequestDispatcher("/personal/worklife.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void outworklife(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====跳出工作生活=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id;
		String type = request.getParameter("work");
		String house = request.getParameter("house");
		String car = request.getParameter("car");
		String smoke = request.getParameter("smoke");
		String drink = request.getParameter("drink");
		try {
			us.updateworklife(id, type, house, car, smoke, drink);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("userBasic", fs.queryUser(id.toString()));
		request.getRequestDispatcher("/UserServlet_entercouple.do").forward(request, response);
	}

	public void entercouple(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====进去择偶条件资料=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id;
		Couple c = us.selectcouple(id);
		HttpSession hs = request.getSession();
		if(c.getAddress()!=null) {
			String[] p = c.getAddress().split("/");
			for (int i = 0; i < p.length; i++) {
				System.out.println(p[i]);
			}
			request.setAttribute("place", p);
		}
		hs.setAttribute("couple", c);
		System.out.println(c);
		request.getRequestDispatcher("/personal/couple.jsp").forward(request, response);
	}

	public void outcouple(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====跳出择偶条件=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String salary = request.getParameter("salary");
		String edu = request.getParameter("edu");
		String marry = request.getParameter("marry");
		String body = request.getParameter("body");
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String xian = request.getParameter("xian");
		String place = sheng + "/" + shi + "/" + xian;
		String hchild = request.getParameter("havechild");
		String wchild = request.getParameter("wantchild");
		String smoke = request.getParameter("smoke");
		String drink = request.getParameter("drink");
		String photo = request.getParameter("photo");
		try {
			us.updatecouple(id, age, height, salary, edu, marry, body, place, hchild, wchild, smoke, drink, photo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("userBasic", fs.queryUser(id.toString()));
		request.getRequestDispatcher("/UserServlet_enterhobby.do").forward(request, response);
	}

	public void enterhobby(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====进去兴趣爱好资料=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id
		Hobby h = us.selecthobby(id);
		HttpSession hs = request.getSession();
		hs.setAttribute("hobby", h);
		System.out.println(h);
		request.getRequestDispatcher("/personal/hobby.jsp").forward(request, response);
	}

	public void outhobby(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====跳出兴趣爱好=====");
		/* int id = b.getUserid(); */
		Integer id =new  Integer((String)request.getSession().getAttribute("userId"));// 用户id
		String greens = request.getParameter("greens");
		String famous = request.getParameter("famous");
		String song = request.getParameter("song");
		String book = request.getParameter("book");
		String thing = request.getParameter("thing");
		try {
			us.updatehobby(id, greens, famous, song, book, thing);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("userBasic", fs.queryUser(id.toString()));
		request.getRequestDispatcher("/personal/changehead.jsp").forward(request, response);
	}

	
	 public void enterhead(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 System.out.println("================进入修改头像==============");
		 //第一步，创建文件解析器工厂
		 DiskFileItemFactory dfif = new DiskFileItemFactory();
		  //第二步 通过工厂创建解析器
		 ServletFileUpload sfu = new ServletFileUpload(dfif);
		  //第三步 使用解析器，将request中的内容解析出来 
		 String userid = (String)request.getSession().getAttribute("userId"); 
		 Basic basic =(Basic) request.getSession().getAttribute("userBasic");
		 try {
			 List<FileItem> lf = sfu.parseRequest(request); 
			 for(FileItem fi : lf) {
				 //第四步，判断是否为文件类型 
				 if(fi.isFormField()) { 
					 //不是文件类型
	
				 }else { 
					 //是文件类型 String
					 String	oldName = fi.getName();//原来的名字 
					 String newName = "xs"+new Date().getTime()+oldName.substring(oldName.lastIndexOf("."));//新的名字
					 System.out.println(newName);
					 //开始上传 
					 System.out.println(fi.getFieldName());
					 if(fi.getFieldName().equals("head")){ //将图片更新到数据库
						 us.updateHead(userid,newName); 
					     //第一步获取上传路径 
						 String path = request.getServletContext().getRealPath("/userHead"); 
						 path = path+"/"+basic.getPhone(); 
						 System.out.println(path);
						 //将图片写入路径中的文件夹
						 fi.write(new File(path,newName));
					} 
				} 
			 }
		} catch(FileUploadException e) { 
			// TODO Auto-generated catch block
			 e.printStackTrace(); 
		} catch (Exception e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		request.getSession().setAttribute("userBasic", fs.queryUser(userid));
		request.getRequestDispatcher("/personal/changehead.jsp").forward(request,response);
	 }
	 

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("============查询所有用户信息============");
		// 默认首页显示的是第1页的数据
		int pageno = 1;
		int count = 5;
		try {
			pageno = Integer.valueOf(request.getParameter("pageno"));
		} catch (Exception e) {

		}
		int num = us.querycount();
		// 获取总页面数
		int totalpageno = num % count == 0 ? num / count : num / count + 1;
		
		ArrayList<Basic> ar = us.selectAll(pageno,count);
		ArrayList<Detail> ad = new ArrayList<Detail>();
		for (Basic b : ar) {
			Detail de = us.queryDetail(b.getUserid());//
			ad.add(de);
		}
		// 传当前页
		request.setAttribute("pagen", pageno);
		// 传总页面数
		request.setAttribute("totalpageno", totalpageno);
		request.setAttribute("listd", ad);
		System.out.println(ar);
		request.setAttribute("list", ar);
		request.getRequestDispatcher("/query/query.jsp").forward(request, response);
	}

	public void findConditions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("=================根据条件查询============");
		// 获取数据
		String sex = request.getParameter("sex");
		String edu = request.getParameter("eduRange");
		String height = request.getParameter("height");
		String salary = request.getParameter("salary");
		System.out.println(sex + "==" + edu + "==" + height + "==" + salary);
		if (edu.equals("选择")) {
			edu = "";
		}
		if (sex.equals("选择")) {
			sex = "";
		}
		if (height.equals("选择")) {
			height = "";
		}
		if (salary.equals("选择")) {
			salary = "";
		}
		int pageno = 1;
		int count = 5;
		try {
			pageno = Integer.valueOf(request.getParameter("pageno"));
		} catch (Exception e) {
			
		}
		ArrayList<Basic> as = us.findCondition(sex, edu, height, salary, pageno, count);
		ArrayList<Basic> ass = us.findConditions(sex, edu, height, salary);
		int num =ass.size();
		System.out.println(num);
		// 获取总页面数
		int totalpageno = num % count == 0 ? num / count : num / count + 1;
		System.out.println(totalpageno);
		// 传当前页
		request.setAttribute("pagen", pageno);
		// 传总页面数
		request.setAttribute("totalpageno", totalpageno);
		// 跳转
		request.setAttribute("findlist", as);
		ArrayList<Detail> ad = new ArrayList<Detail>();
		for (Basic b : as) {
			Detail de = us.queryDetail(b.getUserid());
			ad.add(de);
		}
		request.setAttribute("findlistd", ad);
		request.getRequestDispatcher("/query/query.jsp").forward(request, response);
	}
	
	
	
}
