<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>消息中心</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/whoSeeme.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/jquery/jquery.js"></script>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
	</head>

	<body>
		<%@ include file="top.jsp" %>
		<div class="b1">
			<div class="top1">
				<div class="top2">
					<nav id="nav">
						<ul>
							<li class="act" >消息中心</li>
						</ul>
					</nav>
					<!--内容部分HTML代码-->
		<div id="container">
				<c:if test="${root2!=null}">
					<c:forEach items="${root2}" var="rooti" varStatus="roots">
								<section class="tab" >
									<div class="see">
										<div class="s-head">
											<img alt="" width="100px" height="100px" src="${pageContext.servletContext.contextPath}/img/roots.jpg">
										</div>
										<div class="s-mid">
											<div class="s-mid1">
												Lover的老板&nbsp;&nbsp;
												<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
												<i class="fa fa-ge"></i>&nbsp;
												<i class="fa fa-first-order" style="color: #2E3B84;"></i>
											</div>
											<div class="s-mid2">${rooti.m_content}</div>
										</div>
											<div class="s-bott" >
												<button type="button" onclick="location.href='${pageContext.servletContext.contextPath}/MessageServlet_replyAgree.do?message=${rooti.m_content}'">
												<i class="fa fa-commenting">&nbsp;</i>十分同意
												</button type="button" onclick="location.href='${pageContext.servletContext.contextPath}/MessageServlet_replyRefuse.do?message=${rooti.m_content}'">
												<button>
												<i class="fa fa-commenting">&nbsp;</i>残忍拒绝
												</button>
											</div>
										
									</div>
								</section>
					</c:forEach>
				</c:if>
				
				<c:if test="${root1!=null}">
					<c:forEach items="${root1}" var="rooti" varStatus="roots">
								<section class="tab" >
									<div class="see">
										<div class="s-head">
											<img alt="" width="100px" height="100px" src="${pageContext.servletContext.contextPath}/img/roots.jpg">
										</div>
										<div class="s-mid">
											<div class="s-mid1">
												Lover的老板&nbsp;&nbsp;
												<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
												<i class="fa fa-ge"></i>&nbsp;
												<i class="fa fa-first-order" style="color: #2E3B84;"></i>
											</div>
											<div class="s-mid2">${rooti.m_content}</div>
										</div>
									</div>
								</section>
					</c:forEach>
				</c:if>
				
				
				
				
				<c:if test="${normal!=null}">
					<c:forEach items="${normal}" var="normali" varStatus="normals">
						<c:forEach items="${normal[normals.index]}" var="normalii" varStatus="normalss">
						<section class="tab" >
							<div class="see">
								<div class="s-head">
								<img src="${pageContext.servletContext.contextPath}/userHead/${send[normals.index][normalss.index].phone}/${send[normals.index][normalss.index].head}"  width="100px" height="100px" /></div>
								<div class="s-mid">
									<div class="s-mid1">
										${send[normals.index][normalss.index].nickname} &nbsp;&nbsp;
										<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
										<i class="fa fa-ge"></i>&nbsp;
										<i class="fa fa-first-order" style="color: #2E3B84;"></i>
										发送给
										${receive[normals.index][normalss.index].nickname}
									</div>
									<div class="s-mid2">${normalii.m_content}</div>
								</div>
								<c:if test="${normalss.last}">
									<c:if test="${userId == send[normals.index][normalss.index].userid }">
										<div class="s-bott" >
											<button type="button" onclick="loaction.href='${pageContext.servletContext.contextPath}/SendServlet_enterSendMessage.do?receiveId=${receive[normals.index][normalss.index].userid}'">
												<i class="fa fa-commenting">&nbsp;</i>回复
											</button>
										</div>
									</c:if>
									
									<c:if test="${userId != send[normals.index][normalss.index].userid }">
										<div class="s-bott" >
											<button type="button" onclick="loaction.href='${pageContext.servletContext.contextPath}/SendServlet_enterSendMessage.do?receiveId=${send[normals.index][normalss.index].userid}'">
												<i class="fa fa-commenting">&nbsp;</i>回复
											</button>
										</div>
									</c:if>
									
								</c:if>
							</div>
						</section>
						</c:forEach>
					</c:forEach>
				</c:if>
			
		
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
						<img width="100px" height="100px" src="${pageContext.servletContext.contextPath}/userHead/${userBasic.phone}/${userBasic.head}"/>
					
					</div>
					<div class="r3">会员ID: ${userBasic.userid} </div>
					<div class="r4">
						<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
						<i class="fa fa-ge"></i>&nbsp;
						<i class="fa fa-first-order" style="color: #2E3B84;"></i>
					</div>
					<div class="r5">
						<div class="r5-1"><a href="${pageContext.servletContext.contextPath}/FirstServlet_myAttention.do">我的关注</a></div>
					</div>
					<div class="r5">
						<div class="r5-1"><a href="${pageContext.servletContext.contextPath}/FirstServlet_whoSeeMe.do">谁看了我</a></div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>