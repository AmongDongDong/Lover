package com.lover.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lover.entity.Attention;
import com.lover.entity.Basic;
import com.lover.entity.Browse;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;
import com.lover.service.FirstService;
import com.lover.service.UserService;
import com.lover.service.impl.FirstServiceimpl;
import com.lover.service.impl.UserServiceImpl;

/**
 * 首页servlet
 * @author 肖双
 *
 */
public class FirstServlet {
	FirstService fs = new FirstServiceimpl();
	/**
	 * servlet 进入首页
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void enterFirst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====enter-FirstPage=====");
		//1.查找数据，放入首页
		
		//2.根据id查找相应basic
		String id = (String)request.getSession().getAttribute("userId");
		Basic b = fs.queryUser(id);
		request.getSession().setAttribute("firstUser", b);
		
		//3.查找随机推荐数据,传入首页
		//查找到除自己外的所有的用户，使用ArrayList存起来
		ArrayList<Basic> al = fs.queryOtherUser(id);
		Random random = new Random();
		int u1 = random.nextInt(al.size());
		int u2 = (u1+1)%al.size();
		int u3 = (u1+2)%al.size();
		request.setAttribute("u1", al.get(u1));
		request.setAttribute("u2", al.get(u2));
		request.setAttribute("u3", al.get(u3));
		
		//查找动态内容传入首页
		
		//查找自己的动态传入
		if(fs.queryOneDynamic(id).isEmpty()) {
			request.setAttribute("dym1", "你还没有动态，这里只能显示他人的动态呀！");
		}else {
			request.setAttribute("myDym", fs.queryOneDynamic(id));
		}
		
		
		//查找他人动态传入
		if(fs.queryAllDynamic(id).isEmpty()) {
			request.setAttribute("dym2", "其他人也没有发布动态，好懒呀！");
		}else {
			request.setAttribute("otherDym", fs.queryAllDynamic(id));
		}
		
		
		request.getRequestDispatcher("/first/main.jsp").forward(request, response);
	

	}
	
	/**
	 * servlet 进入whoSeeMe页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void whoSeeMe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====enter-whoSeeMePage=====");
		
		//1、判断是否为会员
		String id = (String)request.getSession().getAttribute("userId");
		//2.根据id查找相应basic
		Basic b = fs.queryUser(id);
		request.setAttribute("firstUser", b);
		if (!fs.queryVip(id)) {
			//3、不是为会员->进入充值页面
			request.getRequestDispatcher("/vip/vip.jsp").forward(request, response);
		}else {
			//4、是会员->继续下面流程
			//5、查找u_browse中的数据
			ArrayList<Browse> ab = fs.queryWhoSeeMe(id);
			ArrayList<Basic> as = new ArrayList<Basic>();
			for (Browse browse : ab) {
				as.add(fs.queryUser(new Integer(browse.getBrowseid()).toString()));
			}
			System.out.println(ab);
			System.out.println(as);
			request.setAttribute("ab", ab);
			request.setAttribute("as", as);
			request.setAttribute("sz", as.size());
			//6、进入该谁看我页面
			request.getRequestDispatcher("/first/whoSeeMe.jsp").forward(request, response);
		}
	}
	
	
	/**
	 * servlet 进入myAttention页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void myAttention(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====enter-myAttentionPage=====");
		
		//1.根据id查找相应basic
		String id = (String)request.getSession().getAttribute("userId");
		Basic b = fs.queryUser(id);
		request.setAttribute("firstUser", b);
		//2.查找相应的数据
		ArrayList<Attention> aa = fs.queryMyAttention(id);
		ArrayList<Basic> as = new ArrayList<Basic>();
		for (Attention browse : aa) {
			as.add(fs.queryUser(new Integer(browse.getAttentioned_id()).toString()));
		}
		System.out.println(aa);
		System.out.println(as);
		request.setAttribute("ab", aa);
		request.setAttribute("as", as);
		request.setAttribute("sz", as.size());
		//6、进入该谁看我页面
		request.getRequestDispatcher("/first/myAttention.jsp").forward(request, response);
	}
	
	/**
	 * 发布动态的servlet
	 */
	public void releaseTrends(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========enter-releaseTrends========");
		//第一步，创建文件解析器工厂
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				//第二步 通过工厂创建解析器
				ServletFileUpload sfu = new ServletFileUpload(dfif);
				//第三步 使用解析器，将request中的内容解析出来
				String userid = (String) request.getSession().getAttribute("userId");
				String speak = "";
				int dynamicId = 0;
				try {
					List<FileItem> lf = sfu.parseRequest(request);
					for (FileItem fi : lf) {
						//第四步，判断是否为文件类型
						if(fi.isFormField()) {
							//不是文件类型
							if("speak".equals(fi.getFieldName())) {
								//获取id
								 speak = new String(fi.getString().getBytes("ISO8859-1"), "utf-8");
							}
						}else {
							//是文件类型
							String oldName = fi.getName();//原来的名字
							String newName = "xs"+new Date().getTime()+oldName.substring(oldName.lastIndexOf("."));//新的名字
							System.out.println(newName);
							
							//开始上传
							System.out.println(fi.getFieldName());
							if(fi.getFieldName().equals("photo")){
								//将图片名存入数据库
							    dynamicId = fs.releaseTrends(speak, newName, userid);
							}
							//第一步获取上传路径
							String path = request.getServletContext().getRealPath("/userDynamicImg");
							path = path+"/"+dynamicId;
							new File(path).mkdir();
							System.out.println(path);
							//将图片写入路径中的文件夹
							fi.write(new File(path,newName));
						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("/FirstServlet_enterFirst.do").forward(request, response);
	}
	
	/**
	 * servlet 进入message页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void enterMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
	 * FirstServlet_enterDetailPersonal.do
	 * servlet 进入detailPersonal页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void enterDetailPersonal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserServiceImpl();
		System.out.println("=======enter-DetailPersonal=========== ");
		//获取你要查看的用户的id
		String deid = request.getParameter("deid");
		System.out.println(deid);
		//获取自己的id
		String selfId = (String) request.getSession().getAttribute("userId");
		
		//将这条信息加入浏览历史表中
		fs.insertBrowse(selfId, deid);
		
		//查看自己是否关注了他
		boolean isfocus = fs.isFocus(deid, selfId);
		System.out.println(isfocus);
		//获取这个用户所有的资料
		//1.获取basic表中的资料
		Basic deBasic = fs.queryUser(deid);
		System.out.println(deBasic.getUserid());
		//2.查找detail表中的所有数据
		Detail deDetail = us.selectdetail(deBasic.getUserid());
		//3.查找couple表中的所有数据
		Couple deCouple = us.selectcouple(deBasic.getUserid());
		//4.查找work表中的所有数据
		Worklife deWorklife = us.selectworklife(deBasic.getUserid());
		//5.查找hobby表中的数据
		Hobby deHobby = us.selecthobby(deBasic.getUserid());
		
		//将数据传送到DetailPersonal页面
		request.setAttribute("isfocus", isfocus);
		request.setAttribute("deBasic", deBasic);
		request.setAttribute("deDetail", deDetail);
		request.setAttribute("deCouple", deCouple);
		request.setAttribute("deWorklife", deWorklife);
		request.setAttribute("deHobby", deHobby);
		System.out.println(deBasic);
		System.out.println(deDetail);
		System.out.println(deCouple);
		System.out.println(deWorklife);
		System.out.println(deHobby);
		//跳转detailPersonal.jsp页面
		request.getRequestDispatcher("/first/detailPersonal.jsp").forward(request, response);
	}
	
	
	/**
	 * FirstServlet_focus.do
	 * servlet 实现关注功能
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void focus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======enter-focus=========== ");
		//获取你要关注的用户的id
		String focusid = request.getParameter("id");
		System.out.println(focusid);
		//获取自己的ID
		String selfId = (String) request.getSession().getAttribute("userId");
		System.out.println(selfId);
		fs.insertFocus(focusid, selfId);
		//跳转detailPersonal.jsp页面

		request.getRequestDispatcher("/FirstServlet_enterDetailPersonal.do?deid="+focusid).forward(request, response);
	}
	
	/**
	 * FirstServlet_canfocus.do
	 * servlet 实现取消关注功能
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void canfocus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======enter-focus=========== ");
		//获取你要取消关注的用户的id
		String focusid = request.getParameter("id");
		//获取自己的ID
		String selfId = (String) request.getSession().getAttribute("userId");
		System.out.println(selfId);
		System.out.println(focusid);
		fs.deleteFocus(focusid, selfId);
		//跳转detailPersonal.jsp页面
		request.setAttribute("deid", focusid);
		request.getRequestDispatcher("/FirstServlet_enterDetailPersonal.do?deid="+focusid).forward(request, response);
	}
	
	/**
	 * FirstServlet_canfocusAttention.do
	 * servlet 实现取消关注功能
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void canfocusAttention(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======enter-focus=========== ");
		//获取你要取消关注的用户的id
		String focusid = request.getParameter("id");
		//获取自己的ID
		String selfId = (String) request.getSession().getAttribute("userId");
		System.out.println(selfId);
		System.out.println(focusid);
		fs.deleteFocus(focusid, selfId);
		//跳转myAttention.jsp页面
		request.getRequestDispatcher("/FirstServlet_myAttention.do").forward(request, response);
	}
	
}
