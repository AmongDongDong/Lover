<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>qqchat</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/qqchat.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
	</head>
	<body>
		<div class="mainshell">
			<div class="topleft">
				&nbsp;&nbsp;&nbsp;<i class="fa fa-list-ul"></i>
				<span style="font-size: 26px;">消息列表</span>
			</div>
			
			<div class="topright">
				<center>
					<c:if test="${send[oneIndex][0].userid != userId }">
						<img src="${pageContext.servletContext.contextPath}/userHead/${send[oneIndex][0].phone}/${send[oneIndex][0].head}" style="margin-left: 10px;margin-top: 10px;border-radius: 50%;" width="60px" height="60px" />
						<a href="${pageContext.servletContext.contextPath}/MessageServlet_enterMessage2.do" style="float: right;font-size: 25px;color: #363E47;margin-right: 10px;">	
							<i class="fa fa-close"></i>
						</a>
						
						<a href="${pageContext.servletContext.contextPath}/MessageServlet_enterAllMessage.do?listIndex=${oneIndex}" style="float: right;font-size: 25px;color: #363E47;margin-right: 30px;">	
							<i class="fa fa-refresh"></i>
						</a>
					</c:if>
					<c:if test="${receive[oneIndex][0].userid != userId }">
						<img src="${pageContext.servletContext.contextPath}/userHead/${receive[oneIndex][0].phone}/${receive[oneIndex][0].head}" style="margin-left: 10px;margin-top: 10px;border-radius: 50%;" width="60px" height="60px" />
						<a href="${pageContext.servletContext.contextPath}/MessageServlet_enterMessage2.do" style="float: right;font-size: 25px;color: #363E47;margin-right: 10px;">	
							<i class="fa fa-close"></i>
						</a>
						
						<a href="${pageContext.servletContext.contextPath}/MessageServlet_enterAllMessage.do?listIndex=${oneIndex}" style="float: right;font-size: 25px;color: #363E47;margin-right: 30px;">	
							<i class="fa fa-refresh"></i>
						</a>
					</c:if>
				</center>
			</div>
			
			<div class="listleft">
				<div class="listleft1">
				<c:if test="${send[oneIndex][0].userid != userId }">
					<img src="${pageContext.servletContext.contextPath}/userHead/${send[oneIndex][0].phone}/${send[oneIndex][0].head}" style="float:left;margin-left: 10px;margin-top: 10px;border-radius: 50%;" width="60px" height="60px" />
					<span style="margin-left:10px;color: #EEEEEE;font-size: 20px;float: left;">${send[oneIndex][0].nickname}</span>
				</c:if>
				<c:if test="${receive[oneIndex][0].userid != userId }">
					<img src="${pageContext.servletContext.contextPath}/userHead/${receive[oneIndex][0].phone}/${receive[oneIndex][0].head}" style="float:left;margin-left: 10px;margin-top: 10px;border-radius: 50%;" width="60px" height="60px" />
					<span style="margin-left:10px;color: #EEEEEE;font-size: 20px;float: left;">${receive[oneIndex][0].nickname}</span>
				</c:if>
				</div>
			</div>
			
			<div class="listright">
				
				<div class="listrightcontent">
					<c:forEach items="${normal[oneIndex]}" var="i" varStatus="s">
					<c:if test="${normal[oneIndex][s.index].message_id == userId}">
						<div class="oneline1">
							<img src="${pageContext.servletContext.contextPath}/userHead/${send[oneIndex][s.index].phone}/${send[oneIndex][s.index].head}" />
							<div class="oneMessage1">
								${normal[oneIndex][s.index].m_content}
							</div>
						</div>
					</c:if>
					<c:if test="${normal[oneIndex][s.index].message_id != userId}">
						<div class="oneline2">
							<img src="${pageContext.servletContext.contextPath}/userHead/${send[oneIndex][s.index].phone}/${send[oneIndex][s.index].head}" />
							<div class="oneMessage2">
								${normal[oneIndex][s.index].m_content}
							</div>
						</div>
					</c:if>
					</c:forEach>
				</div>
				
				<form action="${pageContext.servletContext.contextPath}/SendServlet_qqchatSendMessage.do" method="post">
					<div class="listrightsend">
						<input name="qqchatindex" value="${oneIndex}" style="display:none;"/>
						<c:if test="${send[oneIndex][0].userid != userId }">
							<input name="qqchatreceiveid" value="${send[oneIndex][0].userid}" style="display:none;"/>
						</c:if>
						<c:if test="${receive[oneIndex][0].userid != userId }">
							<input name="qqchatreceiveid" value="${receive[oneIndex][0].userid}" style="display:none;"/>					
						</c:if>
						<textarea name="qqchatmessage"></textarea>
						<button type="submit">
							<i class="fa fa-send"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
