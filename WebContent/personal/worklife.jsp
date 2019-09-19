<%@page import="com.lover.entity.Worklife"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--工作生活-->
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
			<div class="d1-1">| 工作生活</div>
			<form action="${pageContext.servletContext.contextPath}/UserServlet_outworklife.do" method="post">
			<div class="d1-2">
				<div class="left">
					<div class="left-1">职业类别</div>
					<div class="left-1">买房情况</div>
					<div class="left-1">买车情况</div>
					<div class="left-1">是否吸烟</div>
					<div class="left-1">是否喝酒</div>
				</div>
				<% Worklife w = (Worklife)request.getSession().getAttribute("worklife"); %>
				<div class="right">
					<select name="work" class="work" >
						<option value="${worklife.type}">${worklife.type}</option>
					</select>
					<script type="text/javascript">
						//--------------------职业初始化----------------------------
						var work = document.querySelector(".work");
						var worklist = message.WorkList;
						for(var i=0;i<worklist.length;i++){
							work.innerHTML += "<option id='"+worklist[i].WorkID+"' value='"+worklist[i].WorkName+"'>"+
							worklist[i].WorkName+"</option>";
						}
					</script>
					<select name="house" class="house">
						<option value="${worklife.house}">${worklife.house}</option>
					</select>
					<script type="text/javascript">
						//--------------------买房初始化----------------------------
						var house = document.querySelector(".house");
						var houselist = message.HouseList;
						
						for(var i=0;i<houselist.length;i++){
							house.innerHTML += "<option id='"+houselist[i].HouseID+"' value='"+houselist[i].HouseName+"'>"+
							houselist[i].HouseName+"</option>";
						}
					</script>
					<select name="car" class="car">
						<option value="${worklife.car}">${worklife.car}</option>
					</select>
					<script type="text/javascript">
						//--------------------买车初始化----------------------------
						var car = document.querySelector(".car");
						var carlist = message.CarList;
						
						for(var i=0;i<carlist.length;i++){
							car.innerHTML += "<option id='"+carlist[i].CarID+"' value='"+carlist[i].CarName+"'>"+
							carlist[i].CarName+"</option>";
						}
					</script>
					<select name="smoke" class="smoke">
						<option value="${worklife.smoke}">${worklife.smoke}</option>
					</select>
					<script type="text/javascript">
						//--------------------是否吸烟初始化----------------------------
						var smoke = document.querySelector(".smoke");
						var smokelist = message.SmokeList;
						
						for(var i=0;i<smokelist.length;i++){
							smoke.innerHTML += "<option id='"+smokelist[i].SmokeID+"' value='"+smokelist[i].SmokeName+"'>"+
							smokelist[i].SmokeName+"</option>";
						}
					</script>
					<select name="drink" class="drink">
						<option value="${worklife.drink}">${worklife.drink}</option>
					</select>
					<script type="text/javascript">
						//--------------------是否喝酒初始化----------------------------
						var drink = document.querySelector(".drink");
						var drinklist = message.DrinkList;
						
						for(var i=0;i<drinklist.length;i++){
							drink.innerHTML += "<option id='"+drinklist[i].DrinkID+"' value='"+drinklist[i].DrinkName+"'>"+
							drinklist[i].DrinkName+"</option>";
						}
					</script>
				</div>
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
