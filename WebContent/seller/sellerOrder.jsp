<%@page import="com.lover.entity.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家订单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/css/seller.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" />
<link href="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/css/zui.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/jquery/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/js/zui.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/bootbox/bootbox.css"/>
<script src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/bootbox/bootbox.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	<%
		HttpSession se = request.getSession();
		String s = (String) se.getAttribute("sellerId");
		String name = (String) se.getAttribute("sellerName");
		if (s == null) {
			request.getRequestDispatcher("/seller/sellerLogin.jsp").forward(request, response);
			return;
		}
	%>
	<div class="header1">
		<div class="header1-1">
			<i class="fa fa-safari"></i><strong>商家管理界面</strong>
		</div>
		<div class="header1-2">
			<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterFirst.do" style="color: #B66BFF; text-decoration: none;"> <img
				src="${pageContext.servletContext.contextPath}/img/bg.jpg"
				width="70px" height="70px"
				style="margin-top: 5px; border-radius: 50%; float: left;" /> <strong
				style="font-size: 30px; float: left; margin-left: 20px;"><%=name%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hi~</strong>
			</a>
		</div>

	</div>
	<!--左侧导航栏-->
	<div class="header2">
		<div class="header2-2">
			<a href="#"> <span>订单管理</span><i class="fa fa-bars"></i>
			</a>
		</div>
		<div class="header2-1">
			<a
				href="${pageContext.servletContext.contextPath}/SellerServlet_sellerUpdate.do">
				<span>商家中心</span><i class="fa fa-user-o"></i>
			</a>
		</div>
	</div>

	<!--右侧主体内容-->
	<div class="header3">
		<center>
			<div class="header3-1">
				<div class="header3-1-1">
					<div class="header3-1-1-title">
						<i class="fa fa-bars"></i>&nbsp;&nbsp;&nbsp;&nbsp;<strong>订单管理</strong>
						</td>
					</div>
					<table class="table">
						<thead>

							<tr class="info" style="font-size: 25px; text-align: center;">
								<td>配对id</td>
								<td>男方姓名</td>
								<td>男方电话</td>
								<td>女方姓名</td>
								<td>女方电话</td>
								<td>牵手状态</td>
								<td>反馈</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${blind}" var="b" varStatus="d">
								<tr class="active" style="font-size: 20px; text-align: center;">
									<td>${b.blind_id}</td>
									<td>${man[d.index].nickname}</td>
									<td>${man[d.index].phone}</td>
									<td>${woman[d.index].nickname}</td>
									<td>${woman[d.index].phone}</td>
									<td>${b.blind}</td>
									<td>
										<c:if test="${b.blind eq'待反馈'}">
											<button class="btn-info" style="border-radius: 10px;"
												onclick="status(${b.blind_id})">成功</button>
											<button class="btn-danger" style="border-radius: 10px;" onclick="fail(${b.blind_id})" >失败</button>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</center>

	</div>
</body>
	<script type="text/javascript">
		 function status(obj) {
			 console.log(obj);
			bootbox.confirm({
			    message: "你确定要修改吗?",
			    buttons: {
			        confirm: {
			            label: '确定',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: '取消',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {
			        if(result){
			        	location.href="${pageContext.servletContext.contextPath}/SellerServlet_changeBlind.do?id="+obj;
			        }
			    }
			});
		} 
		 </script>
		 <script type="text/javascript">
		 function fail(obj) {
			 console.log(obj);
			bootbox.confirm({
			    message: "你确定要修改吗?",
			    buttons: {
			        confirm: {
			            label: '确定',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: '取消',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {
			        if(result){
			        	location.href="${pageContext.servletContext.contextPath}/SellerServlet_changeFail.do?id="+obj;
			        }
			    }
			});
		} 
		 </script>
</html>
<%
	out.flush();
%>