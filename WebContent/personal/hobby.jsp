<%@page import="com.lover.entity.Hobby"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--兴趣爱好-->
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/detail.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/message.js" ></script>
	</head>
	<body>
		<div class="bott">
		<div class="d1">
			<div class="d1-1">| 兴趣爱好</div>
			<form action="${pageContext.servletContext.contextPath}/UserServlet_outhobby.do" method="post">
			<% Hobby h = (Hobby)request.getSession().getAttribute("hobby"); %>
			<div class="d1-2">
					<div class="like">喜欢的一道菜</div>
					<input type="text" name="greens" placeholder="一道菜名，说一道最符合你口味的菜？" value="${hobby.greens}"/>
					<div class="like">欣赏的一个名人</div>
					<input type="text" name="famous" placeholder="一个名字，最让你欣赏的人是谁？" value="${hobby.famous}"/>
					<div class="like">喜欢的一首歌</div>
					<input type="text" name="song" placeholder="一首歌名，哪首歌最让你感动？" value="${hobby.song}"/>
					<div class="like">喜欢的一本书</div>
					<input type="text" name="book" placeholder="一本书名，让你印象最深的书是哪一本？"  value="${hobby.book}"/>
					<div class="like">喜欢做的事</div>
					<input type="text" name="thing" placeholder="还有什么是你喜欢做的呢？"  value="${hobby.thing}"/>
			</div>
			<div class="d1-3">
				<button class="btn" type="submit">保存并继续</button>
				<button class="btn" type="submit">跳过</button>
			</div>
			</form>
		</div>
		</div>
	</body>
</html>
