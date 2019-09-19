<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>消息发送界面</title>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/jquery/jquery.js"></script>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<style type="text/css">
			body {
				padding: 0px;
				margin: 0px;
			}
			
			.bottom101 {
				height: 700px;
				width: 100%;
				/*background-color: salmon;*/
			}
			
			.base100 {
				width: 1000px;
				/*height: 700px;*/
				/*background-color: darkblue;*/
			}
			
			.base200 {
				width: 999px;
				/*height: 600px;*/
				/*background-color: saddlebrown;*/
				float: left;
				margin-top: 130px;
				/*border: 1px solid #E3E4E5;*/
			}
			
			.head {
				width: 999px;
				height: 80px;
				float: left;
				/*background-color: bisque;*/
			}
			
			.head1 {
				width: 999px;
				height: 180px;
				margin-top: 20px;
				float: left;
				/*background-color: bisque;*/
			}
			
			.head1 textarea {
				width: 992px;
				height: 125px;
				/*background-color: cadetblue;*/
			}
			
			.head1 button {
				width: 70px;
				height: 30px;
				float: right;
				line-height: 10px;
				font-size: 16px;
				border-radius: 12px;
				background-color: #1995E4;
				margin-top: 5px;
				margin-right: 20px;
			}
		</style>
	</head>

	<body>
		<%@ include file="top.jsp" %>
		<center>
		<form action="${pageContext.servletContext.contextPath}/SendServlet_outSendMessage.do" method="post">
			<div class="bottom101">
				<div class="base100">
					<div class="base200">
						<div class="head"><img src="${pageContext.servletContext.contextPath}/img/无标题5.png"/></div>
						<div class="head1">
							<input name="deid" value="${receive}" style="display:none;"/>
							<textarea name="sendContent" placeholder="留下你独树一帜的言论吧"></textarea>
							<div class="container">
								<a data-toggle="tooltip" title="我只是为了好看，点我也没用!">
									<i class="fa fa-gitlab"></i>&nbsp;
									<i class="fa fa-tripadvisor"></i>&nbsp;
									<i class="fa fa-motorcycle"></i>&nbsp;
									<i class="fa fa-sun-o"></i>&nbsp;
									<i class="fa fa-bug"></i>&nbsp;
									<i class="fa fa-moon-o"></i>&nbsp;
									<i class="fa fa-tree"></i>&nbsp;
									<i class="fa fa-certificate"></i>&nbsp;
									<i class="fa fa-hand-grab-o"></i>&nbsp;
									<i class="fa fa-space-shuttle"></i>&nbsp;
									<i class="fa fa-credit-card"></i>&nbsp;
									<i class="fa fa-optin-monster"></i>&nbsp;
									<i class="fa fa-reddit"></i>&nbsp;
									<i class="fa fa-slack"></i>&nbsp;
									<i class="fa fa-slideshare"></i>&nbsp;
									<i class="fa fa-snapchat"></i>&nbsp;
									<i class="fa fa-simplybuilt"></i>&nbsp;
									<i class="fa fa-superpowers"></i>&nbsp;
									<i class="fa fa-themeisle"></i>&nbsp;
									<i class="fa fa-yelp"></i>&nbsp;
									<i class="fa fa-wpexplorer"></i>&nbsp;
									<i class="fa fa-shirtsinbulk"></i>&nbsp;
									<i class="fa fa-gitlab"></i>&nbsp;
									<i class="fa fa-tripadvisor"></i>&nbsp;
									<i class="fa fa-motorcycle"></i>&nbsp;
									<i class="fa fa-sun-o"></i>&nbsp;
									<i class="fa fa-bug"></i>&nbsp;
									<i class="fa fa-moon-o"></i>&nbsp;
									<i class="fa fa-tree"></i>&nbsp;
									<i class="fa fa-certificate"></i>&nbsp;
									<i class="fa fa-hand-grab-o"></i>&nbsp;
									<i class="fa fa-space-shuttle"></i>&nbsp;
									<i class="fa fa-credit-card"></i>&nbsp;
									<i class="fa fa-optin-monster"></i>&nbsp;
								</a>
								<button type="submit"><a>留言</a></button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		</center>
	</body>

</html>