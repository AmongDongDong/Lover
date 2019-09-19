<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>页面头部</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
		<style type="text/css">
			.deferent{
				width: 45px;
				height: 57px;
				/*background-color: #313131;*/
				background-color: white;
				float: left;
				margin-left: 85px;
				border-bottom: 5px solid #000000;
				text-align: center;
				line-height: 60px;
			}
			.deferent a{
				font-weight: 300;
				color: black;
				text-decoration: none;
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
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterFirst.do" target="_top">首页</a>
				</div>
				<div class="deferent">
					<a href="${pageContext.servletContext.contextPath}/UserServlet_enterbasic.do" target="_top">个人</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/UserServlet_list.do" target="_top">搜索</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/SellerServlet_sellerStart.do" target="_top">商家</a>
				</div>
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/vip/vip.jsp" target="_top">Viper</a>
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
		
			
			</div>
		</div>
		<div style="width:100%;height:100px;"></div>
	
	</body>
</html>
