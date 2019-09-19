<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>谁看了我</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/whoSeeme.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/jquery/jquery.js"></script>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
	
	</head>

	<body>
			<%@ include file="top.jsp" %>
	
		<div class="b1">
			<div class="top1">
				<div class="top2">
					<nav id="nav">
						<ul>
							<li class="act">谁看过我</li>
						</ul>
					</nav>
					<!--内容部分HTML代码-->
		<div id="container">
			
			<section class="tab" >
			<c:forEach items="${as}" var="i" varStatus="d">
				<div class="see">
					<div class="s-head"><img width="100px" height="100px" src="${pageContext.servletContext.contextPath}/userHead/${i.phone}/${i.head}"/></div>
					<div class="s-mid">
						<div class="s-mid1">
							${i.nickname}&nbsp;&nbsp;
							<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
							<i class="fa fa-ge"></i>&nbsp;
							<i class="fa fa-first-order" style="color: #2E3B84;"></i>
						</div>
						<div class="s-mid2">出生年月:${i.birthday} | ${i.address} |月薪：${i.salary}  </div>
						<div class="s-mid3">${ab[d.index].browsedate}</div>
					</div>
					<div class="s-bott">
						<button type="button" onclick="location.href='${pageContext.servletContext.contextPath}/SendServlet_enterSayHello.do?receiveId=${i.userid}'"><i class="fa fa-commenting">&nbsp;</i>打招呼</button>
						<button type="button" onclick="location.href='${pageContext.servletContext.contextPath}/SendServlet_enterSendMessage.do?receiveId=${i.userid}'"><i class="fa fa-telegram">&nbsp;</i>发消息</button>
					</div>
				</div>
			</c:forEach>
			</section>
			
		
		</div>
		<script>
			window.onload = function() {
				var nav = document.getElementById('nav');
				var oNav = nav.getElementsByTagName('li');

				var container = document.getElementById('container');
				var oDiv = container.getElementsByClassName('tab');
				for(var i = 0; i < oNav.length; i++) {
					oNav[i].index = i;
					oNav[i].onclick = function() {
						for(var i = 0; i < oNav.length; i++) {
							oNav[i].className = '';
							oDiv[i].style.display = "none";
						}
						this.className = 'act';
						oDiv[this.index].style.display = "block"
					}
					for(var m = 1; m < oNav.length; m++) {
						oNav[m].className = '';
						oDiv[m].style.display = "none";
					}
				}
			};
		</script>
				</div>
				<div class="r1">
					<div class="r2">
						<img width="100px" height="100px" src="${pageContext.servletContext.contextPath}/userHead/${firstUser.phone}/${firstUser.head}"/>
					</div>
					<div class="r3">会员ID:${firstUser.userid}</div>
					<div class="r4">
						<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
						<i class="fa fa-ge"></i>&nbsp;
						<i class="fa fa-first-order" style="color: #2E3B84;"></i>
					</div>
					<div class="r5">
						<div class="r5-1"><a href="#">谁看了我</a></div>
						<div class="r5-2">${sz}</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>