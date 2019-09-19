package com.lover.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lover.dao.FirstDao;
import com.lover.dao.impl.FirstDaoImpl;
import com.lover.entity.Basic;
import com.lover.entity.Message;
import com.lover.service.MessageService;
import com.lover.service.impl.MessageServiceImpl;
import com.sun.swing.internal.plaf.basic.resources.basic;

/**
 * 
 * @author Administrator
 *
 */
public class MessageServlet {
	MessageService ms = new MessageServiceImpl();
	FirstDao ft = new FirstDaoImpl();
	/**
	 * 进入消息中心的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void enterMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("======enter-Message=======");
		//1.获得自己的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.根据id查找相应basic
		Basic b = ft.queryUser(id);
		request.setAttribute("firstUser", b);
		if (!ft.queryVip(id)) {
			//3、不是为会员->进入充值页面
			request.getRequestDispatcher("/vip/vip.jsp").forward(request, response);
		}else {
			
			//2.查找到用户参与的所有信息
			List<ArrayList<Message>> lam = ms.findMessageByID(new Integer(id));
			System.out.println("lam:"+lam);
			//3.先判断lam是否为空
			if(!lam.isEmpty()) {
				//3.先判断管理员给他发信息了没有
				ArrayList<Message> mess1 = lam.get(0);
				ArrayList<Message> root1 = null;//存放不需要回复的管理员信息
				ArrayList<Message> root2 = null;//存放需要回复的管理员信息
				List<ArrayList<Message>> normal = null;//存放用户信息
				List<ArrayList<Basic>> send = null;//存放发件人
				List<ArrayList<Basic>> receive = null;//存放收件人
				
				if(mess1!=null) {
					//说明管理员给他发了消息
					root1  = new ArrayList<Message>();
					root2  = new ArrayList<Message>();
					for (Message me : mess1) {
						if(me.getM_content().endsWith("yes")){
							root2.add(me);
						}else if(me.getM_content().endsWith("no")) {
							root1.add(me);
						}else {
							
						}
					}
					if(root1.isEmpty()) {
						root1 = null;
					}
					if(root2.isEmpty()) {
						root2 = null;
					}
					
					normal = new ArrayList<ArrayList<Message>>();
					send = new ArrayList<ArrayList<Basic>>();
					receive = new ArrayList<ArrayList<Basic>>();
					
					//从1开始循环
					for(int i = 1 ; i < lam.size() ; i++) {
						normal.add(lam.get(i));
					}
					
					//再循环找到发件人与收件人
					for(int i = 0 ; i < normal.size() ; i++) {
						ArrayList<Basic> send1 = new ArrayList<Basic>();  
						ArrayList<Basic> recive1 = new ArrayList<Basic>();  
						for(int j = 0 ; j < normal.get(i).size() ; j++ ) {
							Integer sendid = normal.get(i).get(j).getMessage_id();
							Integer receiveid = normal.get(i).get(j).getMessaged_id();
							Basic b1 = ft.queryUser(sendid.toString());
							Basic b2 = ft.queryUser(receiveid.toString());
							send1.add(b1);
							recive1.add(b2);
						}
						send.add(send1);
						receive.add(recive1);
					}
				}else {
					//说明没有管理员信息
					
					normal = new ArrayList<ArrayList<Message>>();
					send = new ArrayList<ArrayList<Basic>>();
					receive = new ArrayList<ArrayList<Basic>>();
					
					//添加其他用户发过来的信息
					for(int i = 0 ; i < lam.size() ; i++) {
						normal.add(lam.get(i));
					}
					
					//再循环找到发件人与收件人
					for(int i = 0 ; i < normal.size() ; i++) {
						ArrayList<Basic> send1 = new ArrayList<Basic>();  
						ArrayList<Basic> recive1 = new ArrayList<Basic>();  
						for(int j = 0 ; j < normal.get(i).size() ; j++ ) {
							Integer sendid = normal.get(i).get(j).getMessage_id();
							Integer receiveid = normal.get(i).get(j).getMessaged_id();
							Basic b1 = ft.queryUser(sendid.toString());
							Basic b2 = ft.queryUser(receiveid.toString());
							send1.add(b1);
							recive1.add(b2);
						}
						send.add(send1);
						receive.add(recive1);
					}
				}
					
				//3.将数据丢过去
				
				request.setAttribute("root1", root1);
				request.setAttribute("root2", root2);
				request.setAttribute("normal", normal);
				request.setAttribute("send", send);
				request.setAttribute("receive", receive);
			}
			
			request.getRequestDispatcher("/first/message.jsp").forward(request, response);
		}
	}


	/**
	 * 进入消息中心的Servlet的第二种方案
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void enterMessage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("======enter-Message=======");
		//1.获得自己的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.根据id查找相应basic
		Basic b = ft.queryUser(id);
		request.setAttribute("firstUser", b);
		if (!ft.queryVip(id)) {
			//3、不是为会员->进入充值页面
			request.getRequestDispatcher("/vip/vip.jsp").forward(request, response);
		}else {
			
			//2.查找到用户参与的所有信息
			List<ArrayList<Message>> lam = ms.findMessageByID(new Integer(id));
			System.out.println("lam:"+lam);
			//3.先判断lam是否为空
			if(!lam.isEmpty()) {
				//3.先判断管理员给他发信息了没有
				ArrayList<Message> mess1 = lam.get(0);
				ArrayList<Message> root1 = null;//存放不需要回复的管理员信息
				ArrayList<Message> root2 = null;//存放需要回复的管理员信息
				List<ArrayList<Message>> normal = null;//存放用户信息
				List<ArrayList<Basic>> send = null;//存放发件人
				List<ArrayList<Basic>> receive = null;//存放收件人
				
				if(mess1!=null) {
					//说明管理员给他发了消息
					root1  = new ArrayList<Message>();
					root2  = new ArrayList<Message>();
					for (Message me : mess1) {
						if(me.getM_content().endsWith("yes")){
							root2.add(me);
						}else{
							root1.add(me);
						}
					}
					if(root1.isEmpty()) {
						root1 = null;
					}
					if(root2.isEmpty()) {
						root2 = null;
					}
					
					normal = new ArrayList<ArrayList<Message>>();
					send = new ArrayList<ArrayList<Basic>>();
					receive = new ArrayList<ArrayList<Basic>>();
					
					//从1开始循环
					for(int i = 1 ; i < lam.size() ; i++) {
						normal.add(lam.get(i));
					}
					
					//再循环找到发件人与收件人
					for(int i = 0 ; i < normal.size() ; i++) {
						ArrayList<Basic> send1 = new ArrayList<Basic>();  
						ArrayList<Basic> recive1 = new ArrayList<Basic>();  
						for(int j = 0 ; j < normal.get(i).size() ; j++ ) {
							Integer sendid = normal.get(i).get(j).getMessage_id();
							Integer receiveid = normal.get(i).get(j).getMessaged_id();
							Basic b1 = ft.queryUser(sendid.toString());
							Basic b2 = ft.queryUser(receiveid.toString());
							send1.add(b1);
							recive1.add(b2);
						}
						send.add(send1);
						receive.add(recive1);
					}
				}else {
					//说明没有管理员信息
					
					normal = new ArrayList<ArrayList<Message>>();
					send = new ArrayList<ArrayList<Basic>>();
					receive = new ArrayList<ArrayList<Basic>>();
					
					//添加其他用户发过来的信息
					for(int i = 1 ; i < lam.size() ; i++) {
						normal.add(lam.get(i));
					}
					
					//再循环找到发件人与收件人
					for(int i = 0 ; i < normal.size() ; i++) {
						ArrayList<Basic> send1 = new ArrayList<Basic>();  
						ArrayList<Basic> recive1 = new ArrayList<Basic>();  
						for(int j = 0 ; j < normal.get(i).size() ; j++ ) {
							Integer sendid = normal.get(i).get(j).getMessage_id();
							Integer receiveid = normal.get(i).get(j).getMessaged_id();
							Basic b1 = ft.queryUser(sendid.toString());
							Basic b2 = ft.queryUser(receiveid.toString());
							send1.add(b1);
							recive1.add(b2);
						}
						send.add(send1);
						receive.add(recive1);
					}
				}
					
				//3.将数据丢过去
				
				request.setAttribute("root1", root1);
				request.setAttribute("root2", root2);
				request.setAttribute("normal", normal);
				request.setAttribute("send", send);
				request.setAttribute("receive", receive);
			}
			
			request.getRequestDispatcher("/first/message2.jsp").forward(request, response);
		}
	}
	
	
	
	/**
	 * 回复成功的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void replyAgree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("======reply-replyAgreeMessage=======");
		//1.获得自己的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.获得消息内容
		String message = request.getParameter("message");
		//3.根据消息内容获得blind_id
		String[] messageSplit = message.split("_");
		String blindid = messageSplit[0];
		ms.replyRoot(new Integer(blindid), "同意"+id);
		request.getRequestDispatcher("/MessageServlet_enterMessage2.do").forward(request, response);
	}

	
	/**
	 * 查看所有与一个人的所有信息的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void enterAllMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("======reply-replyAgreeMessage=======");
		//1.获得一个List<ArrayList> 的下标
		String index = request.getParameter("listIndex");
		//2.获得自己的id
		String id = (String)request.getSession().getAttribute("userId");
		
		//3.查找到用户参与的所有信息
		List<ArrayList<Message>> lam = ms.findMessageByID(new Integer(id));
		System.out.println("lam:"+lam);
		//4.先判断lam是否为空
		if(!lam.isEmpty()) {
			//5.先判断管理员给他发信息了没有
			ArrayList<Message> mess1 = lam.get(0);
			List<ArrayList<Message>> normal = null;//存放用户信息
			List<ArrayList<Basic>> send = null;//存放发件人
			List<ArrayList<Basic>> receive = null;//存放收件人
			
			if(mess1!=null) {
				//说明管理员给他发了消息
				
				normal = new ArrayList<ArrayList<Message>>();
				send = new ArrayList<ArrayList<Basic>>();
				receive = new ArrayList<ArrayList<Basic>>();
				
				//从1开始循环
				for(int i = 1 ; i < lam.size() ; i++) {
					normal.add(lam.get(i));
				}
				
				//再循环找到发件人与收件人
				for(int i = 0 ; i < normal.size() ; i++) {
					ArrayList<Basic> send1 = new ArrayList<Basic>();  
					ArrayList<Basic> recive1 = new ArrayList<Basic>();  
					for(int j = 0 ; j < normal.get(i).size() ; j++ ) {
						Integer sendid = normal.get(i).get(j).getMessage_id();
						Integer receiveid = normal.get(i).get(j).getMessaged_id();
						Basic b1 = ft.queryUser(sendid.toString());
						Basic b2 = ft.queryUser(receiveid.toString());
						send1.add(b1);
						recive1.add(b2);
					}
					send.add(send1);
					receive.add(recive1);
				}
			}else {
				//说明没有管理员信息
				
				normal = new ArrayList<ArrayList<Message>>();
				send = new ArrayList<ArrayList<Basic>>();
				receive = new ArrayList<ArrayList<Basic>>();
				
				//添加其他用户发过来的信息
				for(int i = 1 ; i < lam.size() ; i++) {
					normal.add(lam.get(i));
				}
				
				//再循环找到发件人与收件人
				for(int i = 0 ; i < normal.size() ; i++) {
					ArrayList<Basic> send1 = new ArrayList<Basic>();  
					ArrayList<Basic> recive1 = new ArrayList<Basic>();  
					for(int j = 0 ; j < normal.get(i).size() ; j++ ) {
						Integer sendid = normal.get(i).get(j).getMessage_id();
						Integer receiveid = normal.get(i).get(j).getMessaged_id();
						Basic b1 = ft.queryUser(sendid.toString());
						Basic b2 = ft.queryUser(receiveid.toString());
						send1.add(b1);
						recive1.add(b2);
					}
					send.add(send1);
					receive.add(recive1);
				}
			}
				
			//3.将数据丢过去
			request.setAttribute("normal", normal);
			request.setAttribute("send", send);
			request.setAttribute("receive", receive);
			
			//将下标传送过去
			request.setAttribute("oneIndex", index);	
		}
		request.getRequestDispatcher("/first/qqchat.jsp").forward(request, response);
	}

	
	
	
	/**
	 * 回复拒绝的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void replyRefuse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("======reply-replyRefuseMessage=======");
		//1.获得自己的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.获得消息内容
		String message = request.getParameter("message");
		//3.根据消息内容获得blind_id
		String[] messageSplit = message.split("_");
		String blindid = messageSplit[0];
		ms.replyRoot(new Integer(blindid), "不同意"+id);
		request.getRequestDispatcher("/MessageServlet_enterMessage2.do").forward(request, response);
	}
	
	
}
