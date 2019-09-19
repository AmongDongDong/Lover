<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商家订单</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/seller.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/bootstrap.min.css" />
		
	</head>
	<body>
	<% HttpSession se = request.getSession();
	String s = (String)se.getAttribute("sellerId");
	String name = (String)se.getAttribute("sellerName");
	
	if(s == null){
		request.getRequestDispatcher("/seller/sellerLogin.jsp").forward(request, response);
		return;
	}  %>
		<div class="header1">
			<div class="header1-1"><i class="fa fa-safari"></i><strong>商家管理界面</strong></div>
			<div class="header1-2">
				<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterFirst.do" style="color: #B66BFF;text-decoration: none;">
					<img src="${pageContext.servletContext.contextPath }/img/bg.jpg" width="70px" height="70px" style="margin-top:5px;border-radius: 50%;float: left;"/>
					<strong style="font-size: 30px;float: left;margin-left: 20px;"><%=name %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hi~</strong>
				</a>
			</div>
			
		</div>
		<!--左侧导航栏-->
		<div class="header2">
			<div class="header2-1">
				<a href="${pageContext.servletContext.contextPath}/SellerServlet_sellerCenter.do">
					<span>订单管理</span><i class="fa fa-bars"></i>
				</a>
			</div>
			<div class="header2-2">
				<a href="${pageContext.servletContext.contextPath}/SellerServlet_sellerUpdate.do">
					<span>商家中心</span><i class="fa fa-user-o"></i>
				</a>
			</div>
		</div>
		
		<!--右侧主体内容-->
		<div class="header3">
			<iframe style="width: 1598px;height: 830px;" src="${pageContext.servletContext.contextPath}/SellerServlet_sellerAlterDate.do"></iframe>
		</div>
		
	</body>
</html>
