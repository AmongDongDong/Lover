<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>商家界面</title>

<link href="https://fonts.googleapis.com/css?family=Droid+Sans"
	rel="stylesheet">
<!-- Animate.css -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/bootstrap.css">
<!-- Magnific Popup -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/magnific-popup.css">
<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/owl.theme.default.min.css">
<!-- Flexslider -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/flexslider.css">
<!-- Theme style  -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
<!-- Modernizr JS -->
<script
	src="${pageContext.servletContext.contextPath}/js/modernizr-2.6.2.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/top.css" />
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
		<script src="js/respond.min.js"></script>
		<![endif]-->

<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
}

.bottom {
	width: 100%;
	height: 450px;
	background-color: #525252;
	float: left;
}

.bottom1 {
	width: 100%;
	height: 106px;
	background-color: #F7F7F7;
	float: left;
	margin-top: 2px;
}

.bottom1-1 {
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

.bottom2 {
	width: 100%;
	height: 380px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 2px;
}

.bottom2-1 {
	width: 1390px;
	height: 243px;
	background-color: #F5F5F5;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
}

.bottom2-1-1 {
	width: 540px;
	height: 20px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 20px;
	font-size: 14px;
}

.bottom2-1-2 {
	width: 270px;
	height: 20px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 20px;
	font-size: 14px;
}

.bottom2-1-3 {
	width: 270px;
	height: 184px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 10px;
	font-size: 14px;
	list-style-type: none;
	line-height: 25px;
}

.bottom2-2 {
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

.bottom3 {
	width: 100%;
	height: 60px;
	background-color: #525252;
	float: left;
}

.bottom3-1 {
	width: 1400px;
	height: 60px;
	background-color: #525252;
	line-height: 60px;
	margin-left: auto;
	margin-right: auto;
}

.bottom3 li {
	display: inline-block;
	color: white;
	font-size: 14px;
}
</style>

</head>

<body>
			<%@ include file="top.jsp" %>


	<div id="gtco-hero" class="js-fullheight" data-section="home">
		<div class="flexslider js-fullheight">
			<ul class="slides">
				<li>
					<div class="overlay"></div>
					<div class="container">
						<div
							class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
							<div class="slider-text-inner">
								<h2>Welcome to the show napa stores</h2>
								<p>Follow @us</p>
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="overlay"></div>
					<div class="container">
						<div
							class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
							<div class="slider-text-inner">
								<h2>Creative. Innovative.Intuitive.</h2>
								<p>
									<a
										href="${pageContext.servletContext.contextPath}/SellerServlet_sellerLogin.do"
										class="btn btn-primary btn-lg">商家中心</a>
								</p>
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="overlay"></div>
					<div class="container">
						<div
							class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
							<div class="slider-text-inner">
								<h2>A new experience.</h2>
								<p>
									<a
										href="${pageContext.servletContext.contextPath}/SellerServlet_sellerLeague.do"
										class="btn btn-primary btn-lg">商家加盟</a>
								</p>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="gtco-section-overflow">

		<div class="gtco-section" id="gtco-services" data-section="services">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-6">
						<div class="gtco-heading">
							<h2 class="gtco-left">Services</h2>
							<p>缘分，有时就是分分钟</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="row">

							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-fort-awesome"></i>
									</span>
									<div class="feature-copy">
										<h3>线下门店全直营</h3>
										<p>打造一流品质服务</p>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-heartbeat"></i>
									</span>
									<div class="feature-copy">
										<h3>专业匹配推荐</h3>
										<p>门店相亲保安全，多彩相亲派对，安全约见场所</p>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-gg"></i>
									</span>
									<div class="feature-copy">
										<h3>到店面谈</h3>
										<p>专属人员亲自约见VIP会员，通过面谈核实会员个人基本资料，保障征婚安全。</p>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-yelp"></i>
									</span>
									<div class="feature-copy">
										<h3>百里挑一专业匹配</h3>
										<p>专属人员充分综合会员的个人情况和征婚需求，精挑细选高诚意优质会员，为会员快速锁定并推荐人选。</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 animate-box" data-animate-effect="fadeIn">
						<div class="row">
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-ge"></i>
									</span>
									<div class="feature-copy">
										<h3>全国会员可共享</h3>
										<p>1亿优质会员</p>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-stack-overflow"></i>
									</span>
									<div class="feature-copy">
										<h3>资料严格审查</h3>
										<p>安全隐私保护，会员的个人资料绝不会以任何方式、任何渠道泄露。会员征婚档案绝对私密保护。</p>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="icon-layers"></i>
									</span>
									<div class="feature-copy">
										<h3>多重认证</h3>
										<p>专属人员为每位服务会员完成身份、学历、婚育证明等多重资料验证，保证会员个人资料的真实性。</p>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="feature-left">
									<span class="icon"> <i class="fa fa-pagelines"></i>
									</span>
									<div class="feature-copy">
										<h3>服务经验</h3>
										<p>成立至今，积累数十年婚恋服务经验，精准匹配、专业甄选，婚配效率高，帮助会员在征婚途中少走弯路，朝着幸福婚姻加速度前行</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="gtco-section" id="gtco-portfolio" data-section="portfolio">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
						<h2>线下直营店</h2>
						<p>超过63家门店，遍布全国37个城市，云集了海量商界精英、成功人士、企业高管、海归人士，并且拥有50多位资深专业人员提供情感分析、婚恋指导。贴心的量身定制婚恋服务，专业的客户第一服务理念，让您在海量优秀的高诚意会员中，找到真爱。</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<a href="images/商家1.png " class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores.gif"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>
					<div class="col-md-4">
						<a href="images/商家2.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores1.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>
					<div class="col-md-4">
						<a href="images/商家3.png" class="gtco-card-item image-popup"
							title="天津小白楼">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores2.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>

					<div class="col-md-4">
						<a href="images/商家4.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/05.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>
					<div class="col-md-4">
						<a href="images/商家5.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores4.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>
					<div class="col-md-4">
						<a href="images/商家6.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores5.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>

					<div class="col-md-4">
						<a href="images/商家7.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores6.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>
					<div class="col-md-4">
						<a href="images/商家8.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores7.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>
					<div class="col-md-4">
						<a href="images/商家9.png" class="gtco-card-item image-popup"
							title="Project name here.">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img
									src="${pageContext.servletContext.contextPath}/images/stores8.jpg"
									width="350px" height="200px" alt="Image">
							</figure>
						</a>
					</div>

				</div>
			</div>
		</div>

		<div class="gtco-section" id="gtco-faq" data-section="faq">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
						<h2>Frequently Ask Questions</h2>
						<p>Dignissimos asperiores vitae velit veniam totam fuga
							molestias accusamus alias autem provident. Odit ab aliquam dolor
							eius.</p>
					</div>
				</div>
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
				<li>ICP备05068163号 湘公网安备17673130854号</li>
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

	<!-- jQuery -->
	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script
		src="${pageContext.servletContext.contextPath}/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.countTo.js"></script>
	<!-- Flexslider -->
	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.flexslider-min.js"></script>
	<!-- Magnific Popup -->
	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="${pageContext.servletContext.contextPath}/js/main2.js"></script>

</body>

</html>
<%
	out.flush();
%>