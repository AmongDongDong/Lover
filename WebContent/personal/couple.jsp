<%@page import="com.lover.entity.Couple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--择偶条件-->
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/couple.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/citys.js" ></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/message.js" ></script>
	</head>
	<body>
		<div class="bott">
		<div class="d1">
			<div class="d1-1">| 择偶条件</div>
			<form action="${pageContext.servletContext.contextPath}/UserServlet_outcouple.do" method="post">
			<div class="d1-2">
				<div class="left">
					<div class="left-1">年龄</div>
					<div class="left-1">身高</div>
					<div class="left-1">月收入</div>
					<div class="left-1">学历</div>
					<div class="left-1">婚姻状况</div>
					<div class="left-1">体型</div>
					<div class="left-1">工作地区</div>
					<div class="left-1">有没有孩子</div>
					<div class="left-1">是否想要孩子</div>
					<div class="left-1">是否吸烟</div>
					<div class="left-1">是否喝酒</div>
					<div class="left-1">有无照片</div>
				</div>
				<% Couple c = (Couple)request.getSession().getAttribute("couple"); %>
				<div class="right">
					<select name="age" class="age" onclick="">
						<option value="${couple.age}">${couple.age}</option>
						<option value="1">20岁至25岁</option>
						<option value="2">25岁至30岁</option>
						<option value="3">35岁至40岁</option>
						<option value="4">40岁至45岁</option>
						<option value="5">50岁至55岁</option>
						<option value="6">55岁至60岁</option>
						<option value="7">60岁至65岁</option>
						<option value="8">65岁至70岁</option>
						<option value="9">70岁至80岁</option>
						<option value="10">不限</option>
					</select>
					<select name="height" class="height">
						<option value="${couple.height}">${couple.height}</option>
						<option value="不限">不限</option>
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
					<select name="salary" class="salary">
						<option value="${couple.salary}">${couple.salary}</option>
						<option value="不限">不限</option>
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
					<select name="edu" class="edu">
						<option value="${couple.education}">${couple.education}</option>
						<option value="不限">不限</option>
					</select>
					<script type="text/javascript">
						//--------------------学历初始化----------------------------
						var edu = document.querySelector(".edu");
						var EduList = message.EduList;
						
						for(var i=0;i<EduList.length;i++){
							edu.innerHTML += "<option id='"+EduList[i].EduID+"' value='"+EduList[i].EduName+"'>"+
							EduList[i].EduName+"</option>";
						}
					</script>
					<select name="marry" class="marry">
						<option value="${couple.marry}">${couple.marry}</option>
						<option value="不限">不限</option>
					</select>
					<script type="text/javascript">
						//--------------------婚姻状态初始化----------------------------
						var marry = document.querySelector(".marry");
						var MarryList = message.MarryList;
						
						for(var i=0;i<MarryList.length;i++){
							marry.innerHTML += "<option id='"+MarryList[i].MarryID+"' value='"+MarryList[i].MarryName+"'>"+
							MarryList[i].MarryName+"</option>";
						}
					</script>
					<select name="body" class="body">
						<option value="${couple.body}">${couple.body}</option>
						<option value="不限">不限</option>
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
					<select name="sheng" class="sheng" onchange="changeShi()">
					    <option value="${place[0]}">${place[0]}</option>
					    <option value="${couple.sheng}">${couple.sheng}</option>
						<option value="">省/直辖市</option>
						<option value="不限">不限</option>
					</select>
					<select name="shi" class="shi" onchange="changexian()">
						<option value="${place[1]}">${place[1]}</option>
						<option value="${couple.shi}">${couple.shi}</option>
						<option value="">市/区</option>
						<option value="不限">不限</option>
					</select>
					<select name="xian" class="xian">
						<option value="${place[2]}">${place[2]}</option>
						<option value="${couple.xian}">${couple.xian}</option>
						<option value="">县</option>
						<option value="不限">不限</option>
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
					<select name="havechild" class="havechild">
						<option value="${couple.hbaby}">${couple.hbaby}</option>
						<option value="">选择</option>
						<option value="不限">不限</option>
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
						<option value="${couple.wbaby}">${couple.wbaby}</option>
						<option value="">选择</option>
						<option value="不限">不限</option>
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
					<select name="smoke" class="smoke">
						<option value="${couple.smoke}">${couple.smoke}</option>
						<option value="">选择</option>
						<option value="不限">不限</option>
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
						<option value="${couple.drink}">${couple.drink}</option>
						<option value="">选择</option>
						<option value="不限">不限</option>
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
					<select name="photo" class="photo">
						<option value="${couple.photo}">${couple.photo}</option>
						<option value="">选择</option>
						<option value="1">不限</option>
						<option value="2">有照片</option>
						<option value="3">无照片</option>
					</select>
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
