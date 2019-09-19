package com.lover.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.service.FirstService;
import com.lover.service.SendService;
import com.lover.service.impl.FirstServiceimpl;
import com.lover.service.impl.SendServiceImpl;

/**
 * 发送消息的Servlet
 * @author Administrator
 *
 */
public class SendServlet {
	FirstService fs = new FirstServiceimpl();
	SendService ss = new SendServiceImpl();
	/**
	 * 
	 * SendServlet_enterSendMessage.do?receiveId=
	 * 进入发送消息的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void enterSendMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("=======enter-enterSendMessage========");
		//1.第一步，拿到用户的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.第二步判断是否为会员
		if(!fs.queryVip(id)) {
			//不是，跳入vip充值页面
			request.getRequestDispatcher("/vip/vip.jsp").forward(request, response);
		}else {
			//是会员
			//1.拿到要收件人的id
			String receiveId = request.getParameter("receiveId");
			System.out.println(receiveId);
			//2.传入写消息页面
			request.setAttribute("receive", receiveId);
			request.getRequestDispatcher("/first/messageBoard.jsp").forward(request, response);
		}
	}

	
	/**
	 * 离开发送消息的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void outSendMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("=======out-enterSendMessage========");
		//1.第一步，拿到用户的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.拿到要收件人的id
		String receiveId = request.getParameter("deid");
		System.out.println(receiveId);
		//3.拿到消息的内容
		String content = request.getParameter("sendContent");
		System.out.println(content);
		
		//4.判断两人的性别
		Basic send = fs.queryUser(id);
		Basic receive = fs.queryUser(receiveId);
		if(send.getSex().equals(receive.getSex())) {
			//两个人性别一样，只将信息存入表中，并不需要做校验
			ss.insertMessage(send.getUserid(), receive.getUserid(), content);
		}else {
			//性别不一样,将两个人区分性别，然后开始判断
			Basic man = null;			
			Basic woman = null;
			if(send.getSex().equals("男")) {
				man = send;
				woman = receive;
			}else {
				man = receive;
				woman = send;
			}
			//5.查找在blind表中是否存在这一条相亲信息
			if(ss.existBlind(new Integer(man.getUserid()).toString(), new Integer(woman.getUserid()).toString())){
				//6.查到了，就查出整条数据
				Blind blind = ss.queryBlind(new Integer(man.getUserid()).toString(), new Integer(woman.getUserid()).toString());
				//7.判断状态,是否为待就绪
				if(blind.getBlind().equals("待就绪")) {
					//8.判断是否达到量级
					if((blind.getFail()+1)*5>blind.getCount()) {
						//9.未达到失败量级，数据插入留言表，count+1
						ss.insertMessage(send.getUserid(), receive.getUserid(), content);
						ss.addCount(new Integer(blind.getBlind_id()).toString());
					}else {
						//10.达到失败量级，修改状态为待通知，count+1
						ss.updateBlind(new Integer(blind.getBlind_id()).toString(), "待通知");
						ss.addCount(new Integer(blind.getBlind_id()).toString());
					}
				}else {
					//11.不是待就绪状态，数据插入留言表，count+1
					ss.insertMessage(send.getUserid(), receive.getUserid(), content);
					ss.addCount(new Integer(blind.getBlind_id()).toString());
				}
			}else{
				//12.未查到，则在blind表中增加一条新数据,count=1,状态=待就绪,fail=0
				ss.insertBlind(man.getUserid(), woman.getUserid());
				//13.在留言表中插入一条数据
				ss.insertMessage(send.getUserid(), receive.getUserid(), content);
			}
			
		}
		request.setAttribute("receive", receiveId);
		request.getRequestDispatcher("/first/messageBoard.jsp").forward(request, response);
	}
	
	
	
	/**
	 * 离开发送消息的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void qqchatSendMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("=======out-enterSendMessage========");
		//0.第零步拿到index下标 
		String index = request.getParameter("qqchatindex");
		//1.第一步，拿到用户的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.拿到要收件人的id
		String receiveId = request.getParameter("qqchatreceiveid");
		System.out.println(receiveId);
		//3.拿到消息的内容
		String content = request.getParameter("qqchatmessage");
		System.out.println(content);
		
		//4.判断两人的性别
		Basic send = fs.queryUser(id);
		Basic receive = fs.queryUser(receiveId);
		if(send.getSex().equals(receive.getSex())) {
			//两个人性别一样，只将信息存入表中，并不需要做校验
			ss.insertMessage(send.getUserid(), receive.getUserid(), content);
		}else {
			//性别不一样,将两个人区分性别，然后开始判断
			Basic man = null;			
			Basic woman = null;
			if(send.getSex().equals("男")) {
				man = send;
				woman = receive;
			}else {
				man = receive;
				woman = send;
			}
			//5.查找在blind表中是否存在这一条相亲信息
			if(ss.existBlind(new Integer(man.getUserid()).toString(), new Integer(woman.getUserid()).toString())){
				//6.查到了，就查出整条数据
				Blind blind = ss.queryBlind(new Integer(man.getUserid()).toString(), new Integer(woman.getUserid()).toString());
				//7.判断状态,是否为待就绪
				if(blind.getBlind().equals("待就绪")) {
					//8.判断是否达到量级
					if((blind.getFail()+1)*5>blind.getCount()) {
						//9.未达到失败量级，数据插入留言表，count+1
						ss.insertMessage(send.getUserid(), receive.getUserid(), content);
						ss.addCount(new Integer(blind.getBlind_id()).toString());
					}else {
						//10.达到失败量级，修改状态为待通知，count+1
						ss.updateBlind(new Integer(blind.getBlind_id()).toString(), "待通知");
						ss.addCount(new Integer(blind.getBlind_id()).toString());
					}
				}else {
					//11.不是待就绪状态，数据插入留言表，count+1
					ss.insertMessage(send.getUserid(), receive.getUserid(), content);
					ss.addCount(new Integer(blind.getBlind_id()).toString());
				}
			}else{
				//12.未查到，则在blind表中增加一条新数据,count=1,状态=待就绪,fail=0
				ss.insertBlind(man.getUserid(), woman.getUserid());
				//13.在留言表中插入一条数据
				ss.insertMessage(send.getUserid(), receive.getUserid(), content);
			}
			
		}
		request.getRequestDispatcher("/MessageServlet_enterAllMessage.do?listIndex="+index).forward(request, response);
	}
	
	
	
	/**
	 * 
	 * SendServlet_enterSayHelllo.do?receiveId=
	 * 进入打招呼的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void enterSayHello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("=======enter-enterSayHelllo========");
		//1.第一步，拿到用户的id
		String id = (String)request.getSession().getAttribute("userId");
		//2.第二步判断是否为会员
		if(!fs.queryVip(id)) {
			//不是，跳入vip充值页面
			request.getRequestDispatcher("/vip/vip.jsp").forward(request, response);
		}else {
			//是会员
			//1.拿到要收件人的id
			String receiveId = request.getParameter("receiveId");
			System.out.println(receiveId);
			//3.拿到消息的内容
			String content = "你好啊，很想认识一下你！";
			System.out.println(content);
			
			//4.判断两人的性别
			Basic send = fs.queryUser(id);
			Basic receive = fs.queryUser(receiveId);
			if(send.getSex().equals(receive.getSex())) {
				//两个人性别一样，只将信息存入表中，并不需要做校验
				ss.insertMessage(send.getUserid(), receive.getUserid(), content);
			}else {
				//性别不一样,将两个人区分性别，然后开始判断
				Basic man = null;			
				Basic woman = null;
				if(send.getSex().equals("男")) {
					man = send;
					woman = receive;
				}else {
					man = receive;
					woman = send;
				}
				//5.查找在blind表中是否存在这一条相亲信息
				if(ss.existBlind(new Integer(man.getUserid()).toString(), new Integer(woman.getUserid()).toString())){
					//6.查到了，就查出整条数据
					Blind blind = ss.queryBlind(new Integer(man.getUserid()).toString(), new Integer(woman.getUserid()).toString());
					//7.判断状态,是否为待就绪
					if(blind.getBlind().equals("待就绪")) {
						//8.判断是否达到量级
						if((blind.getFail()+1)*5>blind.getCount()) {
							//9.未达到失败量级，数据插入留言表，count+1
							ss.insertMessage(send.getUserid(), receive.getUserid(), content);
							ss.addCount(new Integer(blind.getBlind_id()).toString());
						}else {
							//10.达到失败量级，修改状态为待通知，count+1
							ss.updateBlind(new Integer(blind.getBlind_id()).toString(), "待通知");
							ss.addCount(new Integer(blind.getBlind_id()).toString());
						}
					}else {
						//11.不是待就绪状态，数据插入留言表，count+1
						ss.insertMessage(send.getUserid(), receive.getUserid(), content);
						ss.addCount(new Integer(blind.getBlind_id()).toString());
					}
				}else{
					//12.未查到，则在blind表中增加一条新数据,count=1,状态=待就绪,fail=0
					ss.insertBlind(man.getUserid(), woman.getUserid());
					//13.在留言表中插入一条数据
					ss.insertMessage(send.getUserid(), receive.getUserid(), content);
				}
				
			}
			request.getRequestDispatcher("/FirstServlet_enterDetailPersonal.do?deid="+receiveId).forward(request, response);
		}
	}
}
