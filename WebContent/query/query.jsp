<%@page import="com.lover.entity.Basic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询界面</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/query.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/apple.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/css/top.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.css" />
<script
	src="${pageContext.servletContext.contextPath}/bootstrap/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.deferent {
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

.deferent a {
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
				<div class="navi-1-2">
					<a href="${pageContext.servletContext.contextPath}/UserServlet_enterbasic.do" target="_top">个人</a>
				</div>
				<div class="deferent">
					<a href="${pageContext.servletContext.contextPath}/UserServlet_list.do">搜索</a>
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
		<div style="width:100%;height:100px;"></div>
	
	<div class="query2">
		<center>
			<div class="query2-1">
				<div class="querytitle">在此搜索更多信息</div>
				<div class="queryin">
					<input type="text" /> <i class="fa fa-search"
						style="font-size: 25px; font-weight: 100;"></i>
				</div>
				<form
					action="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do"
					method="post">
					<div class="querycondition">
						<strong style="float: left; line-height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：</strong>
						<select name="sex" class="form-control" style="width: 100px;">
							<option value="选择">选择</option>
							<option value="女">女</option>
							<option value="男">男</option>
						</select> <strong style="float: left; line-height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学历：</strong>
						<select style="width: 160px;" name="eduRange" class="form-control">
							<option value="选择">请选择</option>
							<option value="高中及以下">高中及以下</option>
							<option value="中专">中专</option>
							<option value="大专">大专</option>
							<option value="大学本科">大学本科</option>
							<option value="硕士">硕士</option>
							<option value="博士">博士</option>
						</select> <strong style="float: left; line-height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身高：</strong>
						<select name="height" class="form-control" style="width: 200px;">
							<option value="选择">选择</option>
							<option value="height<150">150以下</option>
							<option value="150 AND 160">150cm至160cm</option>
							<option value="160 AND 170">160cm至170cm</option>
							<option value="170 AND 175">170cm至175cm</option>
							<option value="175 AND 180">175cm至180cm</option>
							<option value="180 AND 190">180cm至190cm</option>
							<option value="190 AND 210">190cm至210cm</option>
						</select> <strong style="float: left; line-height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收入：</strong>
						<select name="salary" class="form-control" style="width: 200px;">
							<option value="选择">选择</option>
							<option value="salary<1500">1500以下</option>
							<option value="salary>=1500&&salary<3000">1500至3000</option>
							<option value="salary>=3000&&salary<5000">3000至5000</option>
							<option value="salary>=5000&&salary<8000">5000至8000</option>
							<option value="salary>=8000&&salary<12000">8000至12000</option>
							<option value="salary>=12000&&salary<20000">12000至20000</option>
							<option value="salary>=20000">20000以上</option>
						</select>


					</div>

					<div class="querybutton">

						<button type="submit">查询</button>

					</div>
				</form>
			</div>
		</center>
	</div>
	<div class="query3">
		<div class="query3-1">
		<c:if test="${list!=null}">
			<c:forEach items="${list}" var="b" varStatus="d">
				<div class="query3-1-1">
					<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${b.userid}"> <img src="${pageContext.servletContext.contextPath}/userHead/${b.phone}/${b.head}" />
					</a>
					<div class="nick">
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${b.userid}"
							style="margin-left: 5px; color: black; text-decoration: none;">${b.nickname}</a>
					</div>
					<div class="label">
						<div class="label-1">${b.sex}</div>
						<div class="label-1">${b.education}</div>
						<div class="label-1">${b.birthday}</div>
						<div class="label-1">${b.height}</div>
						<div class="label-1">${b.marry}</div>
						<div class="label-1">${listd[d.index].body}</div>
					</div>
					<div class="word">
						<a href="#" style="color: black; text-decoration: none;">
							${listd[d.index].hearttalk} </a>
					</div>
				</div>

			</c:forEach>
			</c:if>
		<c:if test="${findlist!=null}">
				<c:forEach items="${findlist}" var="b" varStatus="d">
				<div class="query3-1-1">
					<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${b.userid}"> <img src="${pageContext.servletContext.contextPath}/userHead/${b.phone}/${b.head}" />
					</a>
					<div class="nick">
						<a href="${pageContext.servletContext.contextPath}/FirstServlet_enterDetailPersonal.do?deid=${b.userid}"
							style="margin-left: 5px; color: black; text-decoration: none;">${b.nickname}</a>
					</div>
					<div class="label">
						<div class="label-1">${b.sex}</div>
						<div class="label-1">${b.education}</div>
						<div class="label-1">${b.birthday}</div>
						<div class="label-1">${b.height}</div>
						<div class="label-1">${b.marry}</div>
						<div class="label-1">${findlistd[d.index].body}</div>
					</div>
					<div class="word">
						<a href="#" style="color: black; text-decoration: none;">
							${findlistd[d.index].hearttalk} </a>
					</div>
				</div>

			</c:forEach>
			</c:if>
		</div>
			<!-- 放分页按钮 -->
			<c:if test="${list!=null}">
		<div style="width: 420px; height: 50px; margin: 0px auto;">
			<!-- 分页按钮 -->
			<div style="float: left;">
				<ul class="pagination">
					<li><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=1">&laquo;</a></li>
					<li <c:if test="${pagen<=1}">class="disabled"</c:if>><a
						<c:if test="${pagen>1}"> href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pagen-1}"</c:if>><</a></li>

					<c:choose>
						<c:when test="${totalpageno<=5}">
							<c:forEach begin="1" end="${totalpageno}" step="1" var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:when>

						<c:when test="${totalpageno>5 && pagen<=3}">
							<c:forEach begin="1" end="5" step="1" var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:when>

						<c:when test="${totalpageno>5 && totalpageno-pagen<=2}">
							<c:forEach begin="${totalpageno-4}" end="${totalpageno}" step="1"
								var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:when>
						
						 <c:otherwise>
							<c:forEach begin="${pagen-2<1?1:pagen-2}" end="${pagen+2}" step="1" var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:otherwise> 
					</c:choose>
					
					<li <c:if test="${pagen>=totalpageno}">class="disabled"</c:if>><a
						<c:if test="${pagen<totalpageno}">href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${pagen+1}"</c:if>>></a></li>
					<li><a href="${pageContext.servletContext.contextPath}/UserServlet_list.do?pageno=${totalpageno}">&raquo;</a></li>
				</ul>
			<!-- 页面跳转 -->
			<div style="float: right;padding-top: 25px">
				
				<form action="${pageContext.servletContext.contextPath}/UserServlet_list.do" method="post">
				【${pagen}/${totalpageno}】
					<select name="pageno">
						<c:forEach begin="1" end="${totalpageno}" var="op" step="1">
							<c:choose>
								<c:when test="${pagen == op}">
									<option selected="selected" value="${op}">${op}</option>
								</c:when>
								<c:otherwise>
									<option value="${op}">${op}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					<input type="submit" value="go">
				</form>
			</div>
			</div>
		</div>
		</c:if>
		<!-- 放分页按钮 -->
			<c:if test="${findlist!=null}">
		<div style="width: 420px; height: 50px; margin: 0px auto;">
			<!-- 分页按钮 -->
			<div style="float: left;">
				<ul class="pagination">
					<li><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=1">&laquo;</a></li>
					<li <c:if test="${pagen<=1}">class="disabled"</c:if>><a
						<c:if test="${pagen>1}"> href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pagen-1}"</c:if>><</a></li>

					<c:choose>
						<c:when test="${totalpageno<=5}">
							<c:forEach begin="1" end="${totalpageno}" step="1" var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:when>

						<c:when test="${totalpageno>5 && pagen<=3}">
							<c:forEach begin="1" end="5" step="1" var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:when>

						<c:when test="${totalpageno>5 && totalpageno-pagen<=2}">
							<c:forEach begin="${totalpageno-4}" end="${totalpageno}" step="1"
								var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:when>
						
						 <c:otherwise>
							<c:forEach begin="${pagen-2<1?1:pagen-2}" end="${pagen+2}" step="1" var="pn">
								<c:if test="${pagen == pn}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
								<c:if test="${pagen !=pn}">
									<li><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pn}">${pn}</a></li>
								</c:if>
							</c:forEach>
						</c:otherwise> 
					</c:choose>
					
					<li <c:if test="${pagen>=totalpageno}">class="disabled"</c:if>><a
						<c:if test="${pagen<totalpageno}">href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${pagen+1}"</c:if>>></a></li>
					<li><a href="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do?pageno=${totalpageno}">&raquo;</a></li>
				</ul>
			<!-- 页面跳转 -->
			<div style="float: right;padding-top: 25px">
				
				<form action="${pageContext.servletContext.contextPath}/UserServlet_findConditions.do" method="post">
				【${pagen}/${totalpageno}】
					<select name="pageno">
						<c:forEach begin="1" end="${totalpageno}" var="op" step="1">
							<c:choose>
								<c:when test="${pagen == op}">
									<option selected="selected" value="${op}">${op}</option>
								</c:when>
								<c:otherwise>
									<option value="${op}">${op}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					<input type="submit" value="go">
				</form>
			</div>
			</div>
		</div>
		</c:if>
	</div>



</body>
</html>
<%out.flush();%>