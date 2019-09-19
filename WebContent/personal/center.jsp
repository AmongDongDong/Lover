<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人中心页面</title>
	</head>
	<frameset rows="120,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.servletContext.contextPath}/personal/top.jsp" />
		<frameset rows="*" cols="450,*" frameborder="no" border="0" framespacing="0">
			<frame src="${pageContext.servletContext.contextPath}/personal/left.jsp" />
			<frame name="mainframe" id="mainframe" src="${pageContext.servletContext.contextPath}/personal/basic.jsp"/>
		</frameset>
	</frameset>
</html>
