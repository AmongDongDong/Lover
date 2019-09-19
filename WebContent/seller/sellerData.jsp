<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/sellerRegisterAndData.css" />
		<script src="../js/citys.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/workTime.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/question.js" ></script>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/bootstrapweb/bootstrap/css/bootstrap.min.css"/>
		
	</head>

	<body>
		<div class="base">
			<div class="d1">
				<div class="d2">
					<div class="top1">
						基本资料
					</div>
					<div class="input1">
						<h3>商家名称:<span>天津小白楼</span></h3>
					</div>
					<div class="input2">
						商家简介 :<span>love网天津VIP服务中心来到您身边，我们拥有幽雅的服务环境，私密的约会包间，贴心的红娘团队。让每个单身人士来到这里，如在家一般的放松自在。服务中心拥有庞大的数据库，云集了海量商界精英、成功人士、企业高管、海归人士，并且拥有50多位资深专业红娘提供情感分析、婚恋指导。贴心的量身定制婚恋服务，专业的客户第一服务理念，让您在海量优秀的高诚意会员中，找到真爱。助天下有情人终成眷属。</span>
					</div>
					<div class="input1">
						商家地址:<span>天津市河西区南京路39号天津国际贸易中心第30层01-08单元</span>
					</div>
					<div class="input1">
						服务时间 :<span> 周三~周日 （10:30~21:00）</span>
					</div>
					<div class="input1">
						服务电话 :<span>4008-520520</span>
					</div>
					<div class="input1">
						<button style="height: 55px; width: 200px; background-color: black; color: white;" onclick="gx()">修改</button>
					</div>
					<script type="text/javascript">
						function gx(){
							location.href = "商家修改资料.html";
						}
					</script>
				</div>
			</div>
		</div>
	</body>

</html>