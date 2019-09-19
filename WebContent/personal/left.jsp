<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--个人中心左侧菜单栏-->
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/left.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css"/>
	</head>
	<body>
		<div class="c0">
			<div class="c1">
				<div class="c1-1">
					<div class="c1-1-1">
						<img width="100px" height="100px" alt="" src="${pageContext.servletContext.contextPath}/userHead/${userBasic.phone}/${userBasic.head}">
					</div>
					<div class="c1-1-2">会员ID: ${userId} </div>
					<div class="c1-1-3">
						<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
						<i class="fa fa-ge"></i>&nbsp;
						<i class="fa fa-first-order" style="color: #2E3B84;"></i>
					</div>
					<div class="c1-1-4">
						<a href="#" >预览资料</a>
					</div>
				</div>
			</div>
			<div class="c2">
				<a href="basic.jsp" target="mainframe">基本资料
					<i class="fa fa-angle-right"></i>
				</a>
				<a href="${pageContext.servletContext.contextPath}/UserServlet_enterdetail.do" target="mainframe">详细资料
					<i class="fa fa-angle-right"></i>
				</a>
				<a href="${pageContext.servletContext.contextPath}/UserServlet_enterworklife.do" target="mainframe">工作生活
					<i class="fa fa-angle-right"></i>
				</a>
				<a href="${pageContext.servletContext.contextPath}/UserServlet_entercouple.do" target="mainframe">择偶条件
					<i class="fa fa-angle-right"></i>
				</a>
				<a href="${pageContext.servletContext.contextPath}/UserServlet_enterhobby.do" target="mainframe">兴趣爱好
					<i class="fa fa-angle-right"></i>
				</a>
				<a href="${pageContext.servletContext.contextPath}/personal/changehead.jsp" target="mainframe">修改头像
					<i class="fa fa-angle-right"></i>
				</a>
				<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterFirst.do" target="_top">返回首页
					<i class="fa fa-angle-right"></i>
				</a>
			</div>
		</div>
	</body>
</html>
