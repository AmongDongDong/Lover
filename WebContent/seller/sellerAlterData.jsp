<%@page import="java.util.ArrayList"%>
<%@page import="com.lover.entity.Seller"%>
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

</head>

<body>
	<div class="base">
		<div class="d1">
			<div class="d2">
				<div class="top1">基本资料</div>
				<%
					Seller s = (Seller) request.getAttribute("sellerData");
					String address[] = (String[]) request.getAttribute("address");
					String time[] = (String[])request.getAttribute("time");%>
				
				<form action="${pageContext.servletContext.contextPath}/SellerServlet_sellerUpdateData.do" method="post">
					<div class="input1">
						<h3>商家名称:${sellerData.sname}</h3>
					</div>
					<div class="input1">
						商家简介 :
						<textarea name="summary"
							style="font-size: 14px; width: 600px; height: 80px; float: right; margin-right: 85px;"
							placeholder="介绍一下吧" value="${sellerData.summary}">${sellerData.summary}</textarea>
					</div>
					<div class="input1">
						商家地址 : <select name="sheng" class="sheng" onchange="changeShi()">
							<option value="${address[0]}">${address[0]}</option>
						</select> 省 <select name="shi" class="shi" onchange="changexian()">
							<option value="${address[1]}">${address[1]}</option>
						</select> 市 <select name="xian" class="xian">
							<option value="${address[2]}">${address[2]}</option>
						</select> 区/县
						<script type="text/javascript">
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
												+ cityList[i].CityName
												+ "</option>";
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
												+ countyList[i].DisName
												+ "</option>";
									}
								}
							}
						</script>
					</div>
					<div class="input1">
						服务时间 : <select name="week" class="week">
							<option value="${time[0]}">${time[0]}</option>
						</select> <select name="time" class="time">
							<option value="${time[1]}">${time[1]}</option>
						</select>
						<script type="text/javascript">
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
					</div>
					<div class="input1">
						服务电话 :<input type="text" name="phone" value="${sellerData.sphone}" />
					</div>
					<%-- <div class="input1">
						商家密码* :<input type="password" name="password" />
					</div>
					<div class="input1 d3">
						密保问题*:
						<select name="q" class="question">
							<option value="${sellerData.squestion }">选择</option>
						</select>
						<script type="text/javascript">
							var q = document.querySelector(".question");
							var QuestionList = question.QuestionList;
							
							for(var i = 0; i < QuestionList.length; i++) {
								q.innerHTML += "<option id='" + QuestionList[i].QuestionID + "' value='" + QuestionList[i].QuestionName + "'>" +
									QuestionList[i].QuestionName + "</option>";
							}
						</script>
					</div>
					<div class="input1">
						密保答案 *:<input type="text" name="answer" value="${sellerData.sanswer }"/>
					</div> --%>
					<div class="input1">
						<input type="submit" value="修改"
							style="height: 55px; width: 200px; margin-left: 160px; background-color: black; color: white;" />
						<!-- <button style="height: 55px; width: 200px;margin-left: 10px; background-color: black; color: white;" oncick="gx()">返回</button> -->
					</div>
				</form>
				<!-- <script type="text/javascript">
						function gx(){
							location.href = ""
						}
					</script> -->
			</div>
		</div>
	</div>
</body>

</html>