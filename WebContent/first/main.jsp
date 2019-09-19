<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/apple.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/main.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/owl.carousel.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/magnific-popup.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/reset.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/dynamic.css" />
		<link rel="icon" href="${pageContext.servletContext.contextPath}/img/jar.ico"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
		<script src="${pageContext.servletContext.contextPath}/js/modernizr.js"></script>
		<style type="text/css">	
			body{
				padding: 0px;
				margin: 0px;
			}				
			.bottom{
				width: 100%;
				height: 450px;
				background-color: #525252;
				float: left;
			}
			.bottom1{
				width: 100%;
				height: 106px;
				background-color: #F7F7F7;
				float: left;
				margin-top: 2px;
			}
			.bottom1-1{
				width: 1200px;
				height: 64px;
				background-color: #F7F7F7;
				color: black;
				margin-top: 20px;
				margin-left: auto;
				margin-right: auto;
				font-size: 5px;
				list-style-type: none;
			}
			.bottom2{
				width: 100%;
				height: 380px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 2px;
			}
			.bottom2-1{
				width: 1390px;
				height: 243px;
				background-color: #F5F5F5;
				margin-top: 20px;
				margin-left: auto;
				margin-right: auto;
			}
			.bottom2-1-1{
				width: 540px;
				height: 20px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 20px;
				font-size: 14px;
			}
			.bottom2-1-2{
				width: 270px;
				height: 20px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 20px;
				font-size: 14px;
			}
			.bottom2-1-3{
				width: 270px;
				height: 184px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 10px;
				font-size: 14px;
				list-style-type: none;
				line-height: 25px;
			}
			.bottom2-2{
				width: 1390px;
				height: 98px;
				background-color: #F5F5F5;
				color: black;
				font-size: 5px;
				margin-top: 20px;
				margin-left: auto;
				margin-right: auto;
				list-style-type: none;
			}
			.bottom3{
				width: 100%;
				height: 60px;
				background-color: #525252;
				float: left;
			}
			.bottom3-1{
				width: 1400px;
				height: 60px;
				background-color: #525252;
				line-height: 60px;
				margin-left: auto;
				margin-right: auto;
			}
			.bottom3 li{
				display: inline-block;
				color: white;
				font-size: 14px;
			}

		</style>
	
	</head>
	<body>
		<div class="top"></div>
		<div class="navi">
			<div class="navi-1">
				<div class="navi-1-1">
					<i class="fa fa-xing"></i>
				</div>
				<div class="deferent">
					<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterFirst.do">首页</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/UserServlet_enterbasic.do">个人</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/UserServlet_list.do">搜索</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/SellerServlet_sellerStart.do">商家</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/vip/vip.jsp">Viper</a>
				</div>
				<div class="navi-1-3">
					<a href="#">技术支持</a>
				</div>
				<div class="navi-1-4" id="login">
					<i class="fa fa-search"></i>
				</div>
				<div class="navi-1-4" >
					<i class="fa fa-square-o"></i>
				</div>
				
			</div>
			<div class="navi-2">
				<a href="#"><img src="${pageContext.servletContext.contextPath}/userHead/${firstUser.phone}/${firstUser.head}"  /></a>
				<a href="#">
				<strong>${firstUser.nickname}&nbsp;&nbsp;&nbsp;Hi~
							<c:if test="${firstUser.grade==1}">
									<i style="color: gold;;" class="fa fa-paw"></i>
							</c:if>				
				</strong>
				</a>
			</div>
		</div>

		<section class="intro-section" id="home">
			<div class="intro-content">
				<h1>欢迎来到Lover</h1>
			
			</div>
			<a href="#about" class="down">
				<i class="fa fa-angle-down"></i>
			</a>
		</section>
		
		
				
		<section class="services-section spad" id="about" style="border-bottom: 5px solid white;">
			<div class="container">
			<!-- Services Items -->
				<div class="row">
					<!-- item -->
					<div class="col-md-3 col-sm-6 service-item">
						<div class="icon">
							<i class="fa fa-magic"></i>
							<span></span>
						</div>
						<h4><a href="${pageContext.servletContext.contextPath}/FirstServlet_whoSeeMe.do" style="color:#000000;text-decoration: none;">谁看了我</a></h4>
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_whoSeeMe.do" style="color:#444444;text-decoration: none;">到底是谁看了我呢?开通会员就知道了，还有开通优惠呢，只有开通了会员才能查看哦</a>
					</div>
					<!-- item -->
					<div class="col-md-3 col-sm-6 service-item">
						<div class="icon">
							<i class="fa fa-leaf"></i>
							<span></span>
						</div>
						<h4><a href="${pageContext.servletContext.contextPath}/FirstServlet_myAttention.do" style="color:#000000;text-decoration: none;">我的关注</a></h4>
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_myAttention.do" style="color:#444444;text-decoration: none;">今天有没有关注新的朋友呢，多交些朋友，才能快快找到另一半呀</a>
					</div>
					<!-- item -->
					<div class="col-md-3 col-sm-6 service-item">
						<div class="icon">
							<i class="fa fa-camera"></i>
							<span></span>
						</div>
						<h4><a href="${pageContext.servletContext.contextPath}/first/releaseTrends.jsp" style="color:#000000;text-decoration: none;">发布动态</a></h4>
						<a href="${pageContext.servletContext.contextPath}/first/releaseTrends.jsp" style="color:#444444;text-decoration: none;">发布一条动态吧，今天又有什么好玩的事呢，快来告诉大家吧，大家都等着呢</a>
					</div>
					<!-- item -->
					<div class="col-md-3 col-sm-6 service-item">
						<div class="icon">
							<i class="fa fa-cog"></i>
							<span></span>
						</div>
						<h4><a href="${pageContext.servletContext.contextPath}/MessageServlet_enterMessage2.do" style="color:#000000;text-decoration: none;">消息中心</a></h4>
						<a href="${pageContext.servletContext.contextPath}/MessageServlet_enterMessage2.do" style="color:#444444;text-decoration: none;">查看一下，都有哪些人给你发了消息吧</a>
					</div>
				</div>
			</div>
		</section>
				
	
		
		
<!-- ==== 每日推荐 ==== -->
		<section class="blog-section spad" id="recommend" style="border-bottom: 5px solid white;background-color: #F7F7F7;">
			<div class="container">
				<div class="section-title">
					<h2>每日推荐</h2>
				</div>
				<div class="row" >
					<!-- single-post -->
					<div class="col-md-4">
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${u1.userid}" class="blog-item">
							<img width="360px" height="360px"  src="${pageContext.servletContext.contextPath}/userHead/${u1.phone}/${u1.head}" alt="">
							<div class="blog-item-text">
								<h3>${u1.nickname}</h3>
								<p>${u1.address}</p>
								<h5>${u1.birthday}</h5>
							</div>
						</a>
					</div>
					<!-- single-post -->
					<div class="col-md-4">
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${u2.userid}" class="blog-item">
							<img width="360px" height="360px" src="${pageContext.servletContext.contextPath}/userHead/${u2.phone}/${u2.head}" alt="">
							<div class="blog-item-text">
								<h3>${u2.nickname}</h3>
								<p>${u2.address}</p>
								<h5>${u2.birthday}</h5>
							</div>
						</a>
					</div>
					<!-- single-post -->
					<div class="col-md-4">
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${u3.userid}" class="blog-item">
							<img width="360px" height="360px"	 src="${pageContext.servletContext.contextPath}/userHead/${u3.phone}/${u3.head}" alt="">
							<div class="blog-item-text">
								<h3>${u3.nickname}</h3>
								<p>${u3.address}</p>
								<h5>${u3.birthday}</h5>
							</div>
						</a>
					</div>
				</div>
				<div class="text-center mt20">
					<a href="blog-page.html" class="site-button">...</a>
				</div>
			</div>
		</section>
<!-- ==== 每日推荐 ==== -->
	
			<!--动态页面-->
			<div id="gtco-blog" data-section="blog" style="">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
						<h2><%=request.getAttribute("dym1")==null?"快来看看动态吧":request.getAttribute("dym1") %></h2>
						<p><%=request.getAttribute("dym2")==null?"幸福一经拒绝，就不值得我们再加重视。 ——简·奥斯汀 《傲慢与偏见》":request.getAttribute("dym2") %></p>
					</div>
				</div>
				<div class="row">
				<c:forEach items="${myDym}" var="i" >
					<div class="col-md-4">
						<a href="#" class="gtco-card-item has-text">
							<figure>
								<div class="overlay"><i class="ti-plus"></i></div>
								<img width="350px" height="262.5px" src="${pageContext.servletContext.contextPath}/userDynamicImg/${i.dynamicid}/${i.picture}" alt="Image" class="img-responsive">
							</figure>
							<div class="gtco-text text-left">
								<h2>用户ID:${i.userid}</h2>
								<p style="width:320px;height:108px">${i.content}</p>
								<p class="gtco-category">${i.date}</p>
							</div>
						</a>
					</div>
				</c:forEach>
				
				<c:forEach items="${otherDym}" var="i" >
					<div class="col-md-4">
						<a href="#" class="gtco-card-item has-text">
							<figure>
								<div class="overlay"><i class="ti-plus"></i></div>
								<img width="350px" height="262.5px" src="${pageContext.servletContext.contextPath}/userDynamicImg/${i.dynamicid}/${i.picture}" alt="Image" class="img-responsive">
							</figure>
							<div class="gtco-text text-left">
								<h2>用户ID:${i.userid}</h2>
								<p style="width:320px;height:108px">${i.content}</p>
								<p class="gtco-category">${i.date}</p>
							</div>
						</a>
					</div>
				</c:forEach>
					
					<div class="clearfix visible-lg-block visible-md-block"></div>
					<div class="clearfix visible-sm-block"></div>
		
				</div>
			</div>
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
	
			<!-- ==== Jquery and other scripts ==== -->
			<script src="${pageContext.servletContext.contextPath}/js/jquery-2.1.4.min.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/jquery.nav.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/imagesloaded.pkgd.min.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/isotope.pkgd.min.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/owl.carousel.min.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/magnific-popup.min.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/main.js"></script>
	</body>
</html>
<%out.flush();%>