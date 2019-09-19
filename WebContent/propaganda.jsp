<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>宣传页面</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/apple.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css"/>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.4.1.js" ></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/top.css"/>
		<script>
			$(function(){
				$("#a2").click(function(){
						
					$(".login").toggle();
					$(".login-1").toggle();
					$(".login-1").animate({
						left:'1280px'
					},500);
				});
				$("#login").click(function(){
						
					$(".login").toggle();
					$(".login-1").toggle();
					$(".login-1").animate({
						left:'1280px'
					},500);
				});
				$(".login").click(function(){
					$(".login-1").animate({
						left:'2000px'
					},500);
					$(".login").toggle();
					$(".login-1").toggle();		
				});
				$("#a1").click(function(){
					$(".login-1").animate({
						left:'2000px'
					},500);
					$(".login").toggle();
					$(".login-1").toggle();		
				});
			});
		</script>
		<script type="text/javascript">
			function createAcount(){
				location.href = "${pageContext.servletContext.contextPath}/login-register/UserRegister.jsp";
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
					<a href="${pageContext.servletContext.contextPath}/SellerServlet_sellerStart.do">商家</a>
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
		<div class="login">
		</div>
		<div class="login-1">
			<!--登录模块-->
			<div class="login-1-1">
				<div class="login-1-1-1"><strong><%=request.getAttribute("error")==null?"用户登录":request.getAttribute("error") %></strong></div>
				<div class="login-1-1-2"><a id="a1" href="#" style="text-decoration: none;color: black;">x</a></div>
				<form id="form" action="${pageContext.servletContext.contextPath}/LoginServlet_login.do" method="post">
					<div class="login-1-1-3">用户名(电话号码)*</div>
					<div class="login-1-1-4">
						<input id="name" name="username" type="text" placeholder="    /手机号" />
						<span></span>
					</div>
					<div class="login-1-1-5">密码*</div>
					<div class="login-1-1-6">
						<input id="pwd" name="password" type="password" />
						<span></span>
					</div>
					
					<div class="login-1-1-7">
						<a href="${pageContext.servletContext.contextPath}/login-register/forget1.jsp" style="color: black;">忘记密码</a>						
					</div>
					<div class="login-1-1-8">
						<button type="button" onclick="login()">登录</button>
					</div>
				</form>
				
				<script type="text/javascript">
					/* 登陆校验 */
					function login(){
						var name = document.querySelector("#name");
						var pwd = document.querySelector("#pwd");
						var f = document.querySelector("#form");
						
						if(name.value == ""){
							alert("用户名不能为空!");
							return;
						}else{
						}
						
						if(pwd.value == ""){
							alert("密码不能为空!");
							return;
						}else{
						}
						
						f.submit();
					}
				</script>
			</div>
			<!--注册-->
			<div class="login-1-2">
				<div class="login-1-1-1" style="margin-bottom: 50px;"><strong>创建一个新的帐户</strong></div>
				<div class="login-1-2-1">
					<p>创建你的Lover账户之后，可以通过任意的设备</p>
					<li>查询网上账户，及历史查询记录</li>
					<li>管理你的个人信息</li> 
					<li>获取最新的Lover简报</li>
					<li>存储你的理想型</li>
				</div>
				<div class="login-1-2-2">
						<button type="button" onclick="createAcount()" >创建一个帐户</button>
				</div>
			</div>
		</div>
		<div class="ptc1">
			<div class="ptc1-1">Lover</div>
			<div class="ptc1-2">缘分不再注定</div>
			<div class="ptc1-3">
				<a class="a0" href="#">成为会员&nbsp;&nbsp;&nbsp;<i class="fa fa-angle-right"></i></a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="a2" href="#" id="a2">登录&nbsp;&nbsp;&nbsp;<i class="fa fa-angle-right"></i></a>
			</div>
		</div>
		<div class="ptc2">
			<div class="ptc2-1">阳光下的玻璃房，这世上没有第二个你，也没有第二个我，我们就是唯一~</div>
			<div class="ptc2-2">两种方式轻松加入琉璃之恋</div>
			<div class="ptc1-3">
				<a class="a3" href="#">购买会员季卡&nbsp;&nbsp;<i class="fa fa-angle-right"></i></a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="a4" href="#">免费申请&nbsp;&nbsp;<i class="fa fa-angle-right"></i></a>
			</div>
		</div>
		<div class="ptc3"></div>
		<div class="ptc4"></div>
		<div class="ptc5"></div>
		<div class="ptc6"></div>
		<div class="ptc7">
			<div class="ptc7-1">
				<img src="${pageContext.servletContext.contextPath}/img/pp3.jpg" width="931px" height="580px"/>
			</div>
			<div class="ptc7-2">
				<img src="${pageContext.servletContext.contextPath}/img/pp2.jpg" width="931px" height="580px"/>
			</div>
		</div>
		
		<div class="ptc7">
			<div class="ptc7-1">
				<img src="${pageContext.servletContext.contextPath}/img/pp5.jpg" width="931px" height="580px"/>
			</div>
			<div class="ptc7-2">
				<img src="${pageContext.servletContext.contextPath}/img/pp6.jpg" width="931px" height="580px"/>
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
