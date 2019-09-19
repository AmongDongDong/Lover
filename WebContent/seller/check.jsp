<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>审核页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/check.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/apple.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
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
		<!--页面头部-->
						<%@ include file="top.jsp" %>
	
	
		
		
		<!--主体内容-->
		<div class="check2">
			<center>
				<!--中心放置文字图片部分-->
				<div class="check2-1">
					<!--提示内容-->
					<div class="check2-1-1"><strong>您的订单正在审核...</strong></div>
					<!--动图-->
					<div class="check2-1-2">
						<img src="${pageContext.servletContext.contextPath }/img/timg.gif" width="700px" height="200px"/>
					</div>
				</div>
			</center>
		</div>
		
		<!--页面底部-->
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
		<!--页面底部-->
	</body>
</html>
