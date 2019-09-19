<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人详情页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/detailPersonal.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bottom.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/top.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
		
	</head>
	<body>
		<%@ include file="top.jsp" %>
		
		<div class="detail">
			<center>
				<div class="detail-1">
					<div class="detail-1-1">
						<img src="${pageContext.servletContext.contextPath}/userHead/${deBasic.phone}/${deBasic.head}" width="180px" height="180px" style="border-radius: 10px;float: left;"/>
						<div class="detail-1-1-1">
							<div class="detail-1-1-1-1">
								<strong>${deBasic.nickname}</strong>
							</div>
							<div class="detail-1-1-1-2">
								${deBasic.address} | ${deBasic.birthday} | ${deBasic.education} | ${deBasic.marry}| ${deBasic.height} | ${deBasic.salary}元
							</div>
							<div class="detail-1-1-1-2">
								ID:${deBasic.userid}
							</div>
							<div class="detail-1-1-1-3">
								<c:if test="${!isfocus}">
									<button onclick="jumpFocus()" ><i class="fa fa-heart"></i>&nbsp;&nbsp;&nbsp;关注</button>
								</c:if>
								<c:if test="${isfocus}">
									<button onclick="cancelFocus()" ><i class="fa fa-heart"></i>&nbsp;&nbsp;&nbsp;取消</button>
								</c:if>
							</div>
							<script type="text/javascript">
								function jumpFocus(){
									location.href="${pageContext.servletContext.contextPath}/FirstServlet_focus.do?id=${deBasic.userid}";
								}
								function cancelFocus(){
									location.href="${pageContext.servletContext.contextPath}/FirstServlet_canfocus.do?id=${deBasic.userid}";
								}
								function enterSendMessage(){
									location.href="${pageContext.servletContext.contextPath}/SendServlet_enterSendMessage.do?receiveId=${deBasic.userid}";
								}
								
							</script>
						</div>
			
					</div>
					
					<div class="detail-1-2">
						<div class="detail-1-2-1">
							<a href="${pageContext.servletContext.contextPath}/SendServlet_enterSayHello.do?receiveId=${deBasic.userid}" style="color: #AC77F0; text-decoration: none;">
							<i class="fa fa-commenting"></i>&nbsp;&nbsp;打招呼
							</a>
						</div>
						<div class="detail-1-2-1">
							<a href="${pageContext.servletContext.contextPath}/SendServlet_enterSendMessage.do?receiveId=${deBasic.userid}" style="color: #AC77F0; text-decoration: none;">
							<i class="fa fa-telegram"></i>&nbsp;&nbsp;发消息
							</a>
						</div>
						<div class="detail-1-2-2">
						<c:if test="${!isfocus}">
							<a href="${pageContext.servletContext.contextPath}/FirstServlet_focus.do?id=${deBasic.userid}" style="color: #AC77F0; text-decoration: none;">
							<i class="fa fa-heart"></i>&nbsp;&nbsp;关注
							</a>
						</c:if>
						<c:if test="${isfocus}">
							<a href="${pageContext.servletContext.contextPath}/FirstServlet_canfocus.do?id=${deBasic.userid}"" style="color: #AC77F0; text-decoration: none;">
							<i class="fa fa-heart"></i>&nbsp;&nbsp;取消关注
							</a>
						</c:if>
						</div>
					</div>
				</div>
			</center>
		</div>
		<div class="contt">
			<center>
				<div class="contt-1">
					<div class="contt-1-title"><strong>&nbsp;&nbsp;&nbsp;内心独白</strong></div>
					<div class="contt-1-tent">${deDetail.hearttalk}</div>
					<div class="contt-1-title"><strong>&nbsp;&nbsp;&nbsp;个人资料</strong></div>
					<div class="contt-1-tent2">
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.body} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.hbaby} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.place} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.star} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.wbaby} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.wmarry} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label1">
							<strong>&nbsp;&nbsp; ${deDetail.weight} &nbsp;&nbsp;</strong>				
						</div>
					</div>
				
					<div class="contt-1-tent2">
						<div class="contt-label2">
							<strong>&nbsp;&nbsp; ${deWorklife.car} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label2">
							<strong>&nbsp;&nbsp; ${deWorklife.drink} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label2">
							<strong>&nbsp;&nbsp; ${deWorklife.smoke} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label2">
							<strong>&nbsp;&nbsp; ${deWorklife.type} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label2">
							<strong>&nbsp;&nbsp; ${deWorklife.house} &nbsp;&nbsp;</strong>				
						</div>
					</div>
					
					<div class="contt-1-title"><strong>&nbsp;&nbsp;&nbsp;兴趣爱好</strong></div>
					<div class="contt-1-tent3">
						<div class="contt-1-tent3-1">
							喜欢的一道菜：${deHobby.greens}
						</div>
						<div class="contt-1-tent3-1">
							欣赏的一个名人:${deHobby.famous}
						</div>
						<div class="contt-1-tent3-1">
							喜欢的一首歌：${deHobby.song}
						</div>
						<div class="contt-1-tent3-1">
							喜欢的一本书:${deHobby.book}
						</div>
						<div class="contt-1-tent3-1">
							喜欢做的事：${deHobby.thing}
						</div>
						
					</div>
					
					<div class="contt-1-title"><strong>&nbsp;&nbsp;&nbsp;择偶条件</strong></div>
					<div class="contt-1-tent2">
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;地址： ${deCouple.address} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;年龄： ${deCouple.age} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;体型： ${deCouple.body} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;饮酒情况： ${deCouple.drink} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;婚姻情况： ${deCouple.marry} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;教育情况： ${deCouple.education} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;薪资情况： ${deCouple.salary} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;身高情况： ${deCouple.height} &nbsp;&nbsp;</strong>				
						</div>
						<div class="contt-label3">
							<strong>&nbsp;&nbsp;是否想要孩子： ${deCouple.wbaby} &nbsp;&nbsp;</strong>				
						</div>
					</div>
				</div>
			</center>
		</div>
		
		
		<div class="bottom">
			<div class="bottom1">
				<div class="bottom1-1">
					<li>*页面中的图片为模拟图片，仅为说明之目的，是否真实，自行判断。</li>
					<li>*页面中的广告，我方仅提供宣传途径，产品是否真实可靠，自行判断，本网站概不负责广告产品的真实性，请谨慎点击广告</li>
					<li>*本网站提供的屏幕和图像内容，是仅为说明目的而展示的模拟画面。宣传图片以及
						图片中的人物、用户界面和其他产品信息等仅供参考，饼干罐工作室对其有最终解释说明权
						除非经特殊说明，本网站中所涉及的数据均为饼干罐工作室亲自测试，如有疑惑，请联系客服，或拨打联系电话</li>				
				</div>
			</div>
			<div class="bottom2">
				<div class="bottom2-1">
					<div class="bottom2-1-1">
						<strong>产品与服务</strong>
					</div>
					<div class="bottom2-1-2">
						<strong>购买渠道</strong>
					</div>
					<div class="bottom2-1-2">
						<strong>服务支持</strong>
					</div>
					<div class="bottom2-1-2">
						<strong>关于我们</strong>
					</div>
					<div class="bottom2-1-3">
						<li>迅速匹配</li>
						<li>精准查询</li>
						<li>红娘牵线</li>
						<li>线下支持</li>
						<li>完美相遇</li>
						<li>创造缘分</li>
						<li>琉璃之恋</li>
					</div>
					<div class="bottom2-1-3">
						<li>认同闪婚</li>
						<li>全面个人资料</li>
						<li>资料真实</li>
						<li>海量用户在线</li>
						<li>实名认证</li>
						<li>南岛之恋</li>
					</div>
					<div class="bottom2-1-3">
						<li>最新活动</li>
						<li>网上实时相亲</li>
						<li>额外的旅游服务</li>
						<li>全门店查询</li>
						<li>线上商城</li>
						<li>合作企业</li>
						<li>成功案例</li>
					</div>
					<div class="bottom2-1-3">
						<li>在线服务</li>
						<li>邮件咨询</li>
						<li>联系我们</li>
						<li>服务中心</li>
						<li>服务热线</li>
					</div>
					<div class="bottom2-1-3">
						<li>关于饼干罐</li>
						<li>投资者关联</li>
						<li>新闻中心</li>
						<li>人才招聘</li>
						<li>饼干罐开发者网站</li>
						<li>成为技术服务商</li>
					</div>
				</div>
				<div class="bottom2-2">
					<li>© 2019 饼干罐（中国）工作室 版权所有</li>
					<li>此网页最好使用IE9 浏览器、谷歌浏览器、苹果浏览器和其他新式浏览器进行浏览。</li>
					<li>ICP备05068163号  湘公网安备17673130854号</li>
				</div>
			</div>
			<div class="bottom3">
				<div class="bottom3-1">
					<li><strong>中国/中文&nbsp;&nbsp;&nbsp;</strong></li>
					<li><strong>网站地图&nbsp;&nbsp;&nbsp;</strong></li>
					<li><strong>服务条款&nbsp;&nbsp;&nbsp;</strong></li>
					<li><strong>隐私政策&nbsp;&nbsp;&nbsp;</strong></li>
					<li><strong>重要声明&nbsp;&nbsp;&nbsp;</strong></li>
				</div>
			</div>
		</div>
	
	</body>
</html>
