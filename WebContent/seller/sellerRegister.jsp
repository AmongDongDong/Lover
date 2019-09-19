<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/sellerRegister.css" />
<script src="${pageContext.servletContext.contextPath}/js/citys.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/js/workTime.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/js/question.js"></script>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/apple.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/top.css" />
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
}

.bottom {
	width: 100%;
	height: 450px;
	background-color: #525252;
	float: left;
}

.bottom1 {
	width: 100%;
	height: 106px;
	background-color: #F7F7F7;
	float: left;
	margin-top: 2px;
}

.bottom1-1 {
	width: 1200px;
	height: 64px;
	background-color: #F7F7F7;
	color: black;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
	font-size: 5px;
	list-style-type: none;
}

.bottom2 {
	width: 100%;
	height: 380px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 2px;
}

.bottom2-1 {
	width: 1390px;
	height: 243px;
	background-color: #F5F5F5;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
}

.bottom2-1-1 {
	width: 540px;
	height: 20px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 20px;
	font-size: 14px;
}

.bottom2-1-2 {
	width: 270px;
	height: 20px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 20px;
	font-size: 14px;
}

.bottom2-1-3 {
	width: 270px;
	height: 184px;
	background-color: #F5F5F5;
	float: left;
	margin-top: 10px;
	font-size: 14px;
	list-style-type: none;
	line-height: 25px;
}

.bottom2-2 {
	width: 1390px;
	height: 98px;
	background-color: #F5F5F5;
	color: black;
	font-size: 5px;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
	list-style-type: none;
}

.bottom3 {
	width: 100%;
	height: 60px;
	background-color: #525252;
	float: left;
}

.bottom3-1 {
	width: 1400px;
	height: 60px;
	background-color: #525252;
	line-height: 60px;
	margin-left: auto;
	margin-right: auto;
}

.bottom3 li {
	display: inline-block;
	color: white;
	font-size: 14px;
}
</style>
<!-- Ajax异步请求刷新 -->
<script type="text/javascript">
	/* 创建xmlhttpRequest对象 */
	function getxmlhttpRequest() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}

	function checkName(obj) {
		//获得xmlhttpRequest对象
		var xmlhttp = getxmlhttpRequest();
		//类似监听器有数据时才显示
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//接收数据
				var str = xmlhttp.responseText;
				console.log(str);
				if(str=="商家名称已存在!"){
					obj.value="";
				}
				document.querySelector(".sp1").innerText = str;
			}
		}
 		var name = obj.value;
		xmlhttp.open("POST", "SellerServlet_sellerRegisterCheck.do", true);//传参
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");//设置请求头,声明参数不在url,而在请求体中
		xmlhttp.send("name=" + name);
	}
</script>
</head>

<body>
<%-- <% HttpSession se = request.getSession();
	String s = (String)se.getAttribute("sellerId");
	if(s == null){
		request.getRequestDispatcher("/seller/sellerLogin.jsp").forward(request, response);
		return;
	}  %> --%>
	<%@ include file="top.jsp" %>


	<div class="ttt"></div>
	<div class="base">
		<div class="d1">
			<div class="d2">
				<div class="top1">
					注册一个商家账户
					<button>已有账户请登录</button>
				</div>
				<form id="form"
					action="${pageContext.servletContext.contextPath}/SellerServlet_sellerRegister.do"
					method="post">
					<div class="input1">
						商家名称*:<input type="text" name="name" id="name"
							onblur="checkName(this)" /><span class="sp1"></span>
							<p><%=request.getAttribute("errorMsg") == null? "" : request.getAttribute("errorMsg")%></p>
					</div>
					<div class="input1">
						商家简介 :<input type="text" name="summary" />
					</div>
					<div class="input1">
						商家地址* : <select name="sheng" class="sheng" onchange="changeShi()">
							<option value="">选择</option>
						</select> 省 <select name="shi" class="shi" onchange="changexian()">
							<option value="">选择</option>
						</select> 市 <select name="xian" class="xian">
							<option value="">选择</option>
						</select> 区/县

					</div>
					<div class="input1">
						服务时间 *: <select name="week" class="week">
							<option value="">选择</option>
						</select> <select name="time" class="time">
							<option value="">选择</option>
						</select>

					</div>
					<div class="input1">
						服务电话 *:<input type="text" name="phone" id="phone" /><span></span>
					</div>
					<div class="input1">
						商家密码* :<input type="password" name="password" id="password" /><span></span>
					</div>
					<div class="input1 d3">
						密保问题*: <select name="q" class="question">
							<option value="">选择</option>
						</select>

					</div>
					<div class="input1">
						密保答案 *:<input type="text" name="answer" id="answer" /><span></span>
					</div>
					<div class="input1">
						<button type="button" onclick="register()"
							style="height: 55px; width: 400px; margin-left: 160px; background-color: black; color: white;">提交</button>
					</div>
				</form>
			</div>
			<div class="right1">
				<h3>顾客服务中心</h3>
				<ul>
					<li>400 3456 888</li>
					<li>网页解决不了的请联系上面的电话</li>
				</ul>
			</div>
			<div class="right2">
				<h3>关于您的账户</h3>
				<ul>
					<li>管理您的个人信息</li>
					<li>每天都会在lover等您</li>
					<li>说不定有您意想不到的 惊喜</li>
					<li>惊喜是什么？我也不知道</li>
				</ul>
			</div>
		</div>
	</div>


	<div class="bottom">
		<div class="bottom1">
			<div class="bottom1-1">
				<li>*页面中的图片为模拟图片，仅为说明之目的，是否真实，自行判断。</li>
				<li>*页面中的广告，我方仅提供宣传途径，产品是否真实可靠，自行判断，本网站概不负责广告产品的真实性，请谨慎点击广告</li>
				<li>*本网站提供的屏幕和图像内容，是仅为说明目的而展示的模拟画面。宣传图片以及
					图片中的人物、用户界面和其他产品信息等仅供参考，饼干罐工作室对其有最终解释说明权
					除非经特殊说明，本网站中所涉及的数据均为饼干罐工作室亲自测试，如有疑惑，请联系客服，或拨打联系电话</li>
			</div>
		</div>
		<div class="bottom2">
			<div class="bottom2-1">
				<div class="bottom2-1-1">
					<strong>产品与服务</strong>
				</div>
				<div class="bottom2-1-2">
					<strong>购买渠道</strong>
				</div>
				<div class="bottom2-1-2">
					<strong>服务支持</strong>
				</div>
				<div class="bottom2-1-2">
					<strong>关于我们</strong>
				</div>
				<div class="bottom2-1-3">
					<li>迅速匹配</li>
					<li>精准查询</li>
					<li>红娘牵线</li>
					<li>线下支持</li>
					<li>完美相遇</li>
					<li>创造缘分</li>
					<li>琉璃之恋</li>
				</div>
				<div class="bottom2-1-3">
					<li>认同闪婚</li>
					<li>全面个人资料</li>
					<li>资料真实</li>
					<li>海量用户在线</li>
					<li>实名认证</li>
					<li>南岛之恋</li>
				</div>
				<div class="bottom2-1-3">
					<li>最新活动</li>
					<li>网上实时相亲</li>
					<li>额外的旅游服务</li>
					<li>全门店查询</li>
					<li>线上商城</li>
					<li>合作企业</li>
					<li>成功案例</li>
				</div>
				<div class="bottom2-1-3">
					<li>在线服务</li>
					<li>邮件咨询</li>
					<li>联系我们</li>
					<li>服务中心</li>
					<li>服务热线</li>
				</div>
				<div class="bottom2-1-3">
					<li>关于饼干罐</li>
					<li>投资者关联</li>
					<li>新闻中心</li>
					<li>人才招聘</li>
					<li>饼干罐开发者网站</li>
					<li>成为技术服务商</li>
				</div>
			</div>
			<div class="bottom2-2">
				<li>© 2019 饼干罐（中国）工作室 版权所有</li>
				<li>此网页最好使用IE9 浏览器、谷歌浏览器、苹果浏览器和其他新式浏览器进行浏览。</li>
				<li>ICP备05068163号 湘公网安备17673130854号</li>
			</div>
		</div>
		<div class="bottom3">
			<div class="bottom3-1">
				<li><strong>中国/中文&nbsp;&nbsp;&nbsp;</strong></li>
				<li><strong>网站地图&nbsp;&nbsp;&nbsp;</strong></li>
				<li><strong>服务条款&nbsp;&nbsp;&nbsp;</strong></li>
				<li><strong>隐私政策&nbsp;&nbsp;&nbsp;</strong></li>
				<li><strong>重要声明&nbsp;&nbsp;&nbsp;</strong></li>
			</div>
		</div>
	</div>


	<script type="text/javascript">
	/*省市县下拉项*/
		var sheng = document.querySelector(".sheng");
		var provinceList = citys.provinceList;

		for (var i = 0; i < provinceList.length; i++) {
			sheng.innerHTML += "<option id='" + provinceList[i].ProID + "' value='" + provinceList[i].ProName + "'>"
					+ provinceList[i].ProName + "</option>";
		}
		var cityList = citys.cityList;
		var shi = document.querySelector(".shi");

		function changeShi() {
			var shengid = sheng.options[sheng.selectedIndex].id;
			shi.innerHTML = "<option value='xz'>选择</option>";
			for (var i = 0; i < cityList.length; i++) {
				if (cityList[i].ProID == shengid) {
					shi.innerHTML += "<option id='" + cityList[i].CityID + "' value='" + cityList[i].CityName + "'>"
							+ cityList[i].CityName + "</option>";
				}
			}
			changexian();
		}
		var xian = document.querySelector(".xian");
		var countyList = citys.countyList;

		function changexian() {
			var cityid = shi.options[shi.selectedIndex].id;
			xian.innerHTML = "<option value='xz'>选择</option>";
			for (var i = 0; i < countyList.length; i++) {
				if (countyList[i].CityID == cityid) {
					xian.innerHTML += "<option id='" + countyList[i].Id + "' value='" + countyList[i].DisName + "'>"
							+ countyList[i].DisName + "</option>";
				}
			}
		}
	</script>

	<script type="text/javascript">
	/*服务时间下拉项*/
		var week = document.querySelector(".week");
		var weekList = worktime.WeekList;

		for (var i = 0; i < weekList.length; i++) {
			week.innerHTML += "<option id='" + weekList[i].WeekID + "' value='" + weekList[i].WeekName + "'>"
					+ weekList[i].WeekName + "</option>";
		}

		var time = document.querySelector(".time");
		var timeList = worktime.TimeList;

		for (var i = 0; i < timeList.length; i++) {
			time.innerHTML += "<option id='" + timeList[i].TimeID + "' value='" + timeList[i].TimeName + "'>"
					+ timeList[i].TimeName + "</option>";
		}
	</script>

	<script type="text/javascript">
	/*密保问题下拉项*/
		var q = document.querySelector(".question");
		var QuestionList = question.QuestionList;

		for (var i = 0; i < QuestionList.length; i++) {
			q.innerHTML += "<option id='" + QuestionList[i].QuestionID + "' value='" + QuestionList[i].QuestionName + "'>"
					+ QuestionList[i].QuestionName + "</option>";
		}
	</script>
	
	<script type="text/javascript">
		/* 登陆校验 */
		function register() {
			var name = document.querySelector("#name");
			var pwd = document.querySelector("#password");
			var phone = document.querySelector("#phone");
			var answer = document.querySelector("#answer");
			var f = document.querySelector("#form");

			if (name.value == "") {
				name.nextElementSibling.innerHTML = "用户名不能为空!";
				return;
			} else {
				name.nextElementSibling.innerHTML = "";
			}

			if (pwd.value == "") {
				pwd.nextElementSibling.innerHTML = "密码不能为空!";
				return;
			} else {
				pwd.nextElementSibling.innerHTML = "";
			}

			if (phone.value == "") {
				phone.nextElementSibling.innerHTML = "手机号不能为空!";
				return;
			} else {
				phone.nextElementSibling.innerHTML = "";
			}

			if (answer.value == "") {
				answer.nextElementSibling.innerHTML = "密保答案不能为空!";
				return;
			} else {
				answer.nextElementSibling.innerHTML = "";
			}

			f.submit();
		}
	</script>
</body>

</html>
<%
	out.flush();
%>