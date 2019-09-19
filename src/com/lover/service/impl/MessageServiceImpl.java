package com.lover.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import com.lover.dao.BlindDAO;
import com.lover.dao.MessageDAO;
import com.lover.dao.impl.BlindDAOImpl;
import com.lover.dao.impl.MessageDAOImpl;
import com.lover.entity.Blind;
import com.lover.entity.Message;
import com.lover.service.MessageService;

public class MessageServiceImpl implements MessageService{
	//创建MessageDAO对象，用于实现其功能
	MessageDAO messagedao = new MessageDAOImpl();
	//创建BlindDAO对象，用于实现其功能
	BlindDAO blinddao = new BlindDAOImpl();
	
	/**
	 * 查询当前用户留言信息
	 * @return 当前用户留言信息
	 */
	@Override
	public List<ArrayList<Message>> findMessageByID(int user_id) {
		//10.创建结果List
		List<ArrayList<Message>> rs = new ArrayList<ArrayList<Message>>();
		//1.根据用户ID查询所有收到的留言信息
		ArrayList<Message> messaged = messagedao.findMessaged(user_id);
		System.out.println("messaged:"+messaged);
		//2.根据用户ID查询所有发出的留言信息
		ArrayList<Message> message = messagedao.findMessage(user_id);
		System.out.println("message:"+message);
		//3.找出所有管理员给的所有通知
		ArrayList<Message> root = new ArrayList<Message>();
		for (Message msg : messaged) {//遍历收到的留言信息
			if(msg.getMessage_id() < 1000 && Long.valueOf(msg.getM_date()) > (new Date().getTime()-86400000l*3l)){//判断是否为管理员发来的消息(即通知)
				root.add(msg);
			}
		}
		System.out.println("所有来自管理的通知root:"+root);
		for (Message rootMsg : root) {//遍历所有通知
			if(rootMsg.getM_content().substring(0, 9).matches("\\d{8}_")){
				//4.获取对应相亲订单ID
				String content = rootMsg.getM_content();
				System.out.println("管理员的相亲通知消息:"+content);
				String strBlind_id = content.substring(0,8);
				int Blind_id = Integer.valueOf(strBlind_id);
				System.out.println("Blind_id:"+Blind_id);
				//5.获取消息时间的Long类型
				Long longDate = Long.valueOf(rootMsg.getM_date());
				//6.获取当前时间的Long类型
				Date date = new Date();
				Long nowLongDate = date.getTime();
				//7.校验是否过期,及各种情况
				if((nowLongDate-longDate)>86400000){//情况a:该最新通知已过期,当前用户未回复
					
					/*测试所用时间,
					 * 代表5分钟的Long型时间差300000
					 * 代表10分钟的Long型时间差600000
					 * 代表1小时的Long型时间差3600000
					 * 代表1天的Long型时间差86400000
					 * 代表3天的Long型时间差259200000
					 */
					System.out.println("过期");
					//根据相亲订单ID修改相亲订单状态
					String upDlind = "待就绪";
					blinddao.upDateBlind(Blind_id,upDlind);
					
					//8.在通知内容后附加状态及可否操作(情况a不可操作)
					String m_content = content+"_该通知已过期,很遗憾您未回复";
					rootMsg.setM_content(m_content);
					
				}else{//该最新通知未过期
					
					//9.根据相亲订单ID查询相亲订单信息
					Blind blind = blinddao.findBlindByID(Blind_id);
					if(blind.getBlind().equals("待回复")){//情况b:当前用户和对方都待回复
						//8.在通知内容后附加状态及可否操作(情况b可操作)
						String m_content = content+"_期待你们的回复哦!_yes";
						rootMsg.setM_content(m_content);
					}else if(blind.getBlind().substring(2).matches("^\\d{8}$")
							&&!blind.getBlind().substring(2).equals(user_id+"")){//情况c:当前用户待回复对方已经同意
						//8.在通知内容后附加状态及可否操作(情况c可操作)
						String m_content = content+"_对方已经同意了!期待您的回复哦!_yes";
						rootMsg.setM_content(m_content);
					}else if(blind.getBlind().equals("待反馈")){//情况d:双方都已经同意
						//8.在通知内容后附加状态及可否操作(情况d不可操作)
						String m_content = content+"_你们都已经同意了,商家会在最近联系你哦!";
						rootMsg.setM_content(m_content);
					}else if(blind.getBlind().equals("待就绪")){//情况e:对方不同意或者对方通知过期未回复
						//8.在通知内容后附加状态及可否操作(情况e不可操作)
						String m_content = content+"_很遗憾,对方不同意或者对方通知过期未回复";
						rootMsg.setM_content(m_content);
					}else{
						System.out.println("查看留言时漏掉的相亲情况");
					}
					
				}
			
			
			}
			
		
		}
		//11.添加处理后的最新管理员通知
		rs.add(root);
		//12.获取当前用户与其他各个用户之间的全部留言信息
//		//创建一个检查数组,防止数据录入结果重复
//		int[] check = new int[0];
//		//遍历当前用户发出的留言信息,逐个选择一个被留言用户
//		for (Message msgnum : message) {
//			//判断所选被留言用户是否录入过信息
//			boolean isFlag = true;
//			for(int i =0;i<check.length;i++){
//				if(msgnum.getMessaged_id()==check[i]){
//					isFlag = false;
//				}
//			}
//			if(isFlag){
//				//创建一个临时ArrayList<Message>,用来存放当前用户和所选被留言用户之间的全部留言信息
//				ArrayList<Message> normal = new ArrayList<Message>();
//				//检查数组自增,并保持所选被留言用户的ID
//				check = Arrays.copyOf(check, check.length+1);
//				check[check.length-1] = msgnum.getMessaged_id();
//				//遍历当前用户发出的留言信息
//				for (Message msg : message) {
//					//找到当前用户给所选被留言用户发的全部信息
//					if(msgnum.getMessaged_id()==msg.getMessaged_id()){
//						normal.add(msg);
//					}
//				}
//				//遍历当前用户收到的留言信息
//				for (Message msgd : messaged) {
//					//排除管理员发来的消息
//					if(msgd.getMessage_id() > 1000){
//						//找到当前用户收到的所选被留言用户发出的全部信息
//						if(msgnum.getMessaged_id() == msgd.getMessage_id()){
//							normal.add(msgd);
//						}
//					}
//				}
//				rs.add(normal);
//			}
//		}
//		//13.当前用户跟各个用户之间的全部留言按时间排序
//		for (ArrayList al : rs) {
//			for (Object obj : al) {
//				Message m = (Message)obj;
//				String strDate = m.getM_date();
//			}
//		}
		//a.创建一个LinkedHashSet(有序,不可重复)储存所有跟当前用户有留言互动的用户id
		LinkedHashSet idSet = new LinkedHashSet();
		for (Message msg : message) {//遍历当前用户发出的信息,获取所有收到当前用户留言信息的用户ID
			idSet.add(msg.getMessaged_id());
		}
		for (Message msgd : messaged) {//遍历当前用户收到的信息,获取所有给当前用户发送过留言信息的用户ID
			if(msgd.getMessage_id()>1000){
				idSet.add(msgd.getMessage_id());
			}
		}
		//b.获取当前用户与每个与他有留言互动的用户之间的全部留言信息
		for (Object obj : idSet) {//遍历idSet
			int id = (int)obj;
			//c.根据两个用户id,查询他们之间的全部留言信息
			ArrayList<Message> msgList = messagedao.findAllMsgByID(user_id,id);
			rs.add(msgList);
		}
		return rs;
	}
	
	
	/**
	 * 处理用户对管理员相亲通知的回复
	 * @param Blind_id 相亲通知的想亲订单号
	 * @param reply 用户的回复(只有两种1."同意+当前用户ID"2."不同意+当前用户ID")
	 */
	@Override
	public void replyRoot(int blind_id, String reply) {
		//1.查询这条相亲订单当前的状态
		Blind bd = blinddao.findBlindByID(blind_id);
		if(bd.getBlind().equals("待回复")){//相亲订单双方都还未回复
			//2.根据当前用户的回复,修改相亲订单状态
			if(reply.substring(2).matches("^\\d{8}$")){//当前用户同意
				//3.修改相亲订单状态为reply(该情况下reply为:同意+当前用户ID)
				blinddao.upDateBlind(blind_id, reply);
			}else{//当前用户不同意
				/*3.修改相亲订单状态为"待就绪"(该情况下reply为:不同意+当前用户ID)
				 * 及相亲失败量级+1
				 */
				//根据相亲订单ID修改相亲订单状态
				blinddao.upDateBlind(blind_id, "待就绪");
				//根据相亲订单ID修改相亲失败量级
				int fail = bd.getFail() + 1;
				blinddao.upDateBlindFail(blind_id,fail);
			}
		}else if(bd.getBlind().substring(2).matches("^\\d{8}$")){//对方已经同意
			//2.根据当前用户的回复,修改相亲订单信息
			if(reply.substring(2).matches("^\\d{8}$")){//当前用户同意
				//3.修改相亲订单状态为"待反馈"(该情况下reply为:同意+当前用户ID)
				blinddao.upDateBlind(blind_id, "待反馈");
			}else{//当前用户不同意
				/*3.修改相亲订单状态为"待就绪"(该情况下reply为:不同意+当前用户ID)
				 * 及相亲失败量级+1
				 */
				//根据相亲订单ID修改相亲订单状态
				blinddao.upDateBlind(blind_id, "待就绪");
				//根据相亲订单ID修改相亲失败量级
				int fail = bd.getFail() + 1;
				blinddao.upDateBlindFail(blind_id,fail);
			}
		}else{
			System.out.println("处理回复时漏掉的相亲情况");
		}
		
	}
	
	
	
	//测试
//	public static void main(String[] args) {
//		//Date -> Long -> String -> Long -> Date
////		Date date = new Date();
////		System.out.println("date:"+date);
////		Long longDate = date.getTime();
////		System.out.println("longDate:"+longDate);
////		String strDate = longDate+"";
////		System.out.println("strDate:"+strDate);
////		Long longDates = Long.valueOf(strDate);
////		System.out.println("longDates:"+longDates);
////		Date dates = new Date(longDates);
////		System.out.println("dates:"+dates);
////		String str1 = "待就绪";
////		String str2 = "同意16000001";
////		String str3 = "不同意16000000";
////		System.out.println("str1:"+(str1.equals("待回复")||(str1.substring(2).matches("^\\d{8}$")&&!str1.substring(2).equals("16000000"))));
////		System.out.println("str2:"+(str2.equals("待回复")||(str2.substring(2).matches("^\\d{8}$")&&!str2.substring(2).equals("16000000"))));
////		System.out.println("str3:"+(str3.equals("待回复")||(str3.substring(2).matches("^\\d{8}$")&&!str3.substring(2).equals("16000000"))));
////		String str4 = "111_天天向上_不好_42424";
////		String[] strs = str4.split("_");
////		for (String string : strs) {
////			System.out.println(string);
////		}
////		System.out.println("20000000_通知:天天向上".substring(0, 9));
////		System.out.println("20000000_通知:天天向上".substring(0, 9).matches("\\d{8}_"));
//		MessageServiceImpl msi = new MessageServiceImpl();
//		List<ArrayList> list = msi.findMessageByID(16000014);
//		for (ArrayList arrayList : list) {
//			System.out.println("信息对话框:"+arrayList);
//			for (Object object : arrayList) {
//				System.out.println(object);
//			}
//		}
//	}
}
