<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.lover.entity.Detail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--用户详细资料-->
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/detail.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/citys.js" ></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/message.js" ></script>
	</head>
	<body>
		<div class="bott">
		<div class="d1">
			<div class="d1-1">| 详细资料</div>
			<form action="${pageContext.servletContext.contextPath}/UserServlet_outdetail.do" method="post">
			<div class="d1-2">
				<div class="left">
					<div class="left-1">籍贯</div>
					<div class="left-1">体重</div>
					<div class="left-1">体型</div>
					<div class="left-1">星座</div>
					<div class="left-1">有没有孩子</div>
					<div class="left-1">是否想要孩子</div>
					<div class="left-1">何时结婚</div>
					<div class="left-1">内心独白</div>
				</div>
				<% Detail d = (Detail)request.getSession().getAttribute("detail"); %>
				<div class="detailright">
					<select name="sheng" class="sheng" onchange="changeShi()">
						<!-- <option value="">省/直辖市</option> -->
						<option value="${place[0]}">${place[0]}</option>
						<option value="${detail.sheng}">${detail.sheng}</option>
					</select>
					<select name="shi" class="shi" onchange="changexian()">
					<!-- 	<option value="">市/区</option> -->
						<option value="${place[1]}">${place[1]}</option>
						<option value="${detail.shi}">${detail.shi}</option>
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
						}
					</script>
					<!----------------体重------------->
					<select name="weight" class="weight" >
						<option value="${detail.weight}">${detail.weight}</option>
						<c:forEach begin="40" end="150" step="1" var="i">
							<option value="${i}">${i}</option>
						</c:forEach> 
					</select>(单位：KG)
				
					<select name="body" class="body">
						<!-- <option value="">选择</option> -->
						<option value="${detail.body}">${detail.body}</option>
					</select>
					<script type="text/javascript">
						//--------------------体型初始化----------------------------
						var body = document.querySelector(".body");
						var bodylist = message.BodyList;
						
						for(var i=0;i<bodylist.length;i++){
							body.innerHTML += "<option id='"+bodylist[i].BodyID+"' value='"+bodylist[i].BodyName+"'>"+
							bodylist[i].BodyName+"</option>";
						}
					</script>
					<select name="star" class="star">
						<option value="${detail.star}">${detail.star}</option>
						<!-- <option value="">选择</option> -->
					</select>
					<script type="text/javascript">
						//--------------------星座初始化----------------------------
						var star = document.querySelector(".star");
						var starlist = message.StarList;
						
						for(var i=0;i<starlist.length;i++){
							star.innerHTML += "<option id='"+starlist[i].StarID+"' value='"+starlist[i].StarName+"'>"+
							starlist[i].StarName+"</option>";
						}
					</script>
					<select name="havechild" class="havechild">
						<!-- <option value="">选择</option> -->
						<option value="${detail.hbaby}">${detail.hbaby}</option>
					</select>
					<script type="text/javascript">
						//--------------------是否有孩子初始化----------------------------
						var havechild = document.querySelector(".havechild");
						var hchildlist = message.HchildList;
						
						for(var i=0;i<hchildlist.length;i++){
							havechild.innerHTML += "<option id='"+hchildlist[i].HchildID+"' value='"+hchildlist[i].HchildName+"'>"+
							hchildlist[i].HchildName+"</option>";
						}
					</script>
					<select name="wantchild" class="wantchild">
						<!-- <option value="">选择</option> -->
						<option value="${detail.wbaby}">${detail.wbaby}</option>
					</select>
					<script type="text/javascript">
						//--------------------是否想要孩子初始化----------------------------
						var wantchild = document.querySelector(".wantchild");
						var wchildlist = message.WchildList;
						
						for(var i=0;i<wchildlist.length;i++){
							wantchild.innerHTML += "<option id='"+wchildlist[i].WchildID+"' value='"+wchildlist[i].WchildName+"'>"+
							wchildlist[i].WchildName+"</option>";
						}
					</script>
					<select name="marry" class="marry">
						<!-- <option value="">选择</option> -->
						<option value="${detail.wmarry}">${detail.wmarry}</option>
					</select>
					<script type="text/javascript">
						//--------------------何时结婚初始化----------------------------
						var marry = document.querySelector(".marry");
						var marrylist = message.MarryList;
						
						for(var i=0;i<marrylist.length;i++){
							marry.innerHTML += "<option id='"+marrylist[i].MarryID+"' value='"+marrylist[i].MarryName+"'>"+
							marrylist[i].MarryName+"</option>";
						}
					</script>
					<div class="talk">
						<input type="text" name="hearttalk" placeholder="介绍一下自己，描述一下理想的伴侣，说说你对婚姻的期望..." value="${detail.hearttalk}"/>
					</div>
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
<%out.flush(); %>