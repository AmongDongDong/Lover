<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
  <%@page import="com.lover.entity.Basic"%>
<!DOCTYPE html>
<!--用户基本资料-->
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/basic.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/citys.js" ></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/message.js" ></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/jquery/jquery.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	</head>
	<body>
		<div class="bott">
		<div class="b1">
			<div class="b1-1">| 基本资料</div>
			<div class="b1-2">
			<% Basic b = (Basic)request.getSession().getAttribute("basic");%> 
				<form action="${pageContext.servletContext.contextPath}/UserServlet_outbasic.do" method="post">
				<div class="b1-2-1">
					<div class="b1-2-1-1">你的固定资料:</div>
					<div class="b1-2-1-2">你是一位<%=b.getSex()%>士 |${basic.birthday}| ${basic.marry}|${basic.education}</div>
				</div>
				<div class="b1-2-2">
					昵称
					<input type="text" class="t1" name="nickname" value="${basic.nickname}"/><br>
					<div class="b1-2-2-1">认真填写你的昵称</div>
					手机
					<input readonly="readonly" type="text" class="t1" name="phone" value="${basic.phone}"><br>
					<div class="b1-2-2-1">让你可免费获得网站的征婚进展提醒短信 </div>
					工作地区 
					<select name="sheng" class="sheng" onchange="changeShi()">
						<option value="${basicplace[0]}">${basicplace[0]}</option>
						<option value="${basic.sheng}">${basic.sheng}</option>
						<%-- <option value="${u.getaddress}">省</option> --%>
					</select>
					<select name="shi" class="shi" onchange="changexian()">
						<option value="${basicplace[1]}">${basicplace[1]}</option>
						<option value="${basic.shi}">${basic.shi}</option>
					</select>
					<select name="xian" class="xian">
						<option value="${basicplace[2]}">${basicplace[2]}</option>
						<option value="${basic.xian}">${basic.xian}</option>
					</select>
					<script type="text/javascript">
						//--------------------省级初始化----------------------------
						var sheng = document.querySelector(".sheng");
						var provinceList = citys.provinceList;
						
						for(var i=0;i<provinceList.length;i++){
							sheng.innerHTML += "<option id='"+provinceList[i].ProID+"' value='"+provinceList[i].ProName+"'>"+
							provinceList[i].ProName+"</option>";
						}
						
						//---------------------市级初始化----------------------------
						var cityList = citys.cityList;
						var shi = document.querySelector(".shi");
						function changeShi(){
							var shengid = sheng.options[sheng.selectedIndex].id;
							shi.innerHTML = "<option value='xz'>选择</option>";
							for(var i=0;i<cityList.length;i++){
								if(cityList[i].ProID == shengid){
									shi.innerHTML += "<option id='"+cityList[i].CityID+"' value='"+cityList[i].CityName+"'>"+
							cityList[i].CityName+"</option>";
								}
							}
							
							changexian();
						}
						
						//-------------------县级初始化---------------------
						var xian = document.querySelector(".xian");
						var countyList = citys.countyList;
						function changexian(){
							var cityid = shi.options[shi.selectedIndex].id;
							xian.innerHTML = "<option value='xz'>选择</option>";
							for(var i=0;i<countyList.length;i++){
								if(countyList[i].CityID == cityid){
									xian.innerHTML +="<option id='"+countyList[i].Id+"' value='"+countyList[i].DisName+"'>"+
							countyList[i].DisName+"</option>";
								}
							}
						}
					</script>
					<div class="b1-2-2-1">工作地不要随意更改</div>
					我的月收入
					<select name="salary" class="salary">
						<!-- <option value="">选择</option> -->
						<option value="${basic.salary}">${basic.salary}</option>
					</select>
					<script type="text/javascript">
						//--------------------月收入初始化----------------------------
						var salary = document.querySelector(".salary");
						var salarylist = message.SalaryList;
						
						for(var i=0;i<salarylist.length;i++){
							salary.innerHTML += "<option id='"+salarylist[i].SalaryID+"' value='"+salarylist[i].SalaryName+"'>"+
							salarylist[i].SalaryName+"</option>";
						}
					</script>
					<div class="b1-2-2-1">请如实填写收入情况</div>
					我的身高
					<select name="height" class="height">
						<!-- <option value="">选择</option> -->
						<option value="${basic.height}">${basic.height}</option>
					</select>
					<script type="text/javascript">
						//--------------------身高初始化----------------------------
						var height = document.querySelector(".height");
						var heightlist = message.HeightList;
						
						for(var i=0;i<heightlist.length;i++){
							height.innerHTML += "<option id='"+heightlist[i].HeightID+"' value='"+heightlist[i].HeightName+"'>"+
							heightlist[i].HeightName+"</option>";
						}
					</script>
					<!-- <div class="b1-2-2-1">身高只能修改一次</div> -->
				</div>
				<div class="b1-2-3">
					<button class="btn" type="submit">保存并继续</button>
					<button class="btn" type="submit">跳过</button>
				</div>
				</form>
			</div>
			
		</div>
		</div>
	</body>
</html>
