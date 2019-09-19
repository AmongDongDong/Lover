<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="utf-8" />
		<title></title>
		<script type="text/javascript" src="../js/question.js" ></script>
		<link rel="stylesheet" href="../css/love.css" />
		<script src="../js/message.js" type="text/javascript" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/citys.js" ></script>
		<script type="text/javascript" src="../laydate/js/laydate.js" ></script>
		<link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="../css/top.css"/>
		<style type="text/css">	
			body{
				padding: 0px;
				margin: 0px;
			}				
			.bottom{
				width: 100%;
				height: 450px;
				background-color: #525252;
				float: left;
			}
			.bottom1{
				width: 100%;
				height: 106px;
				background-color: #F7F7F7;
				float: left;
				margin-top: 2px;
			}
			.bottom1-1{
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
			.bottom2{
				width: 100%;
				height: 380px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 2px;
			}
			.bottom2-1{
				width: 1390px;
				height: 243px;
				background-color: #F5F5F5;
				margin-top: 20px;
				margin-left: auto;
				margin-right: auto;
			}
			.bottom2-1-1{
				width: 540px;
				height: 20px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 20px;
				font-size: 14px;
			}
			.bottom2-1-2{
				width: 270px;
				height: 20px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 20px;
				font-size: 14px;
			}
			.bottom2-1-3{
				width: 270px;
				height: 184px;
				background-color: #F5F5F5;
				float: left;
				margin-top: 10px;
				font-size: 14px;
				list-style-type: none;
				line-height: 25px;
			}
			.bottom2-2{
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
			.bottom3{
				width: 100%;
				height: 60px;
				background-color: #525252;
				float: left;
			}
			.bottom3-1{
				width: 1400px;
				height: 60px;
				background-color: #525252;
				line-height: 60px;
				margin-left: auto;
				margin-right: auto;
			}
			.bottom3 li{
				display: inline-block;
				color: white;
				font-size: 14px;
			}

		</style>
		
		
		<script type="text/javascript">
				//-----------跳转-----------------
				function enterPro(){
					location.href="../propaganda.jsp";
				}
				/**
				 * 该方法创建一个xmlhttpRequest对象
				 */
				function getXMLHTTPRequest(){
					var xmlhttp;
					if (window.XMLHttpRequest){
				    	//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
				    	xmlhttp=new XMLHttpRequest();
					}else{
				   		// IE6, IE5 浏览器执行代码
				    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
					return xmlhttp;
				}
				
				/**
				 * 检查名字是否存在POST请求方式
				 */
				function exitPhone(obj){
					//获得xmlhttpRequest对象
					var xmlhttp = getXMLHTTPRequest();
					//使用xmlhttpRequest中类似于监听器的方法，响应数据
					xmlhttp.onreadystatechange=function(){
					    if (xmlhttp.readyState==4 && xmlhttp.status==200){
					    //接收数据
					    var str = xmlhttp.responseText;
					    console.log(str);
					    /* obj.nextElementSibling.innerText = str; *//* 
					    var arrli =(new Function("","return"+str))(); */
					    if(str=="该号码已被注册"){
					    	obj.value="";
					    }
			      		obj.nextElementSibling.innerText = str;
					    
			    		}
					}
					var name = obj.value;
					//发送数据
					xmlhttp.open("POST","${pageContext.servletContext.contextPath}/LoginServlet_existPhone.do",true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send("phone="+name);
				}
				
				//手机号码
				function checkPhone(obj){ 
				    if(!(/^1[3456789]\d{9}$/.test(obj.value))){ 
				    	obj.value="";
				        alert("手机号码有误，请重填");  
				        return false; 
				    } 
				}
		</script>
	</head>
	<body>
	
		<div class="top"></div>
		<div class="navi">
			<div class="navi-1">
				<div class="navi-1-1">
					<i class="fa fa-xing"></i>
				</div>
				<div class="navi-1-2">
					<a href="#">首页</a>
				</div>
				<div class="navi-1-2">
					<a href="#">个人</a>
				</div>
				<div class="navi-1-2">
					<a href="#">搜索</a>
				</div>
				<div class="navi-1-2">
					<a href="#">商家</a>
				</div>
				<div class="navi-1-2">
					<a href="#">Viper</a>
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
	
	
	
	<div class="ttt"></div>
	<form action="${pageContext.servletContext.contextPath}/LoginServlet_register.do" method="post">
	<div class="bottomr">
			<div class="d1">
				<div class="d1-1">
					<div class="d1-1-1">
						<div class="title">创建一个我的LOVER账户</div>
						<button type="button" onclick="enterPro()">已有账户请登录</button>
					</div>
					
					<div class="d1-1-2">必填项目*</div>
					<div class="d1-1-3">创建个人账户，以获取更多专属资讯和丰富体验。</div>
					<div class="d1-2">
						<div class="d1-2-1">个人信息</div>
						<div class="d1-2-3">
							我的性别:
							<select name="sex" class="sex">
								<option value="0">选择</option>
							</select>
							<script type="text/javascript">
								//-----------性别初始化-----------------
								var sex = document.querySelector(".sex");
								var SexList = message.SexList;
								for (var i=0; i<SexList.length; i++) {
									sex.innerHTML += "<option id ='"+SexList[i].SexID+"' value = '"+SexList[i].SexName+"'>"
									+SexList[i].SexName+"</option>"
								}
							</script>
						</div>
						<div class="d1-2-3">
							我的生日: <input type="date" id="date" name="date"/>
						</div>
						<div class="d1-2-3">
							工作地区:
							省
							<select name="sheng" class="sheng" onchange="changeShi()">
								<option value="0">选择</option>
							</select>
							市
							<select name="shi" class="shi" onchange="changexian()">
								<option value="0">选择</option>
							</select>
							县
							<select name="xian" class="xian">
								<option value="0">选择</option>
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
						</div>
						<div class="d1-2-3">
							婚姻状态:
							<select name="marry" class="marry">
								<option value="0">选择</option>
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
						</div>
						<div class="d1-2-3">
							我的学历:
							<select name="edu" class="edu">
								<option value="">选择</option>
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
						</div>
						<div class="d1-2-3">
							我的月收入:
							<select name="salary" class="salary">
								<option value="0">选择</option>
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
						</div>
					</div>
					<div class="d1-2-1">注册账户</div>
						我的手机: <input id="phone" name="phone" type="text" class="t1" onblur="exitPhone(this);checkPhone(this)" /><span></span><br>
						创建密码: <input id="password" name="password" type="password" class="t1"/><br>
								密保问题*:
								<select name="question" class="question">
									<option value="">选择</option>
								</select>
								<script type="text/javascript">
									var q = document.querySelector(".question");
									var QuestionList = question.QuestionList;
									
									for(var i = 0; i < QuestionList.length; i++) {
										q.innerHTML += "<option id='" + QuestionList[i].QuestionID + "' value='" + QuestionList[i].QuestionName + "'>" +
											QuestionList[i].QuestionName + "</option>";
									}
								</script>
						密保答案 *:<input type="text" name="answer" />
						<button type="submit">创建账户</button>
				</div>
				<div class="right">
					<div class="d3">
						<div class="d3-1">顾客服务中心</div>
						<ul>
							<li>400 6588 888</li>
							<li>通过Email联系我们</li>
						</ul>
					</div>
					<div class="d4">
						<div class="d4-1">关于您的Lover账户</div>
						<ul>
							<li>查询您的历史浏览记录</li>
							<li>管理您的个人信息</li>
							<li>发布您的个人动态</li>
							<li>寻找您未来的另一半</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		</form>
	
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
					<li>ICP备05068163号  湘公网安备17673130854号</li>
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
		
	</body>
</html>
