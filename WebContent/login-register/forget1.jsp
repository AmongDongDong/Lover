<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>忘记密码1</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/forget.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/apple.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
		<script type="text/javascript">
			function question(){
				location.href="forget2.jsp"
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
			function checkPhone(){
				//获得xmlhttpRequest对象
				var xmlhttp = getXMLHTTPRequest();
				var phone = document.querySelector("#bti").value;
				//使用xmlhttpRequest中类似于监听器的方法，响应数据
				xmlhttp.onreadystatechange=function(){
				    if (xmlhttp.readyState==4 && xmlhttp.status==200){
				    //接收数据
				    var str = xmlhttp.responseText;
				    console.log(str);
				    document.querySelector("#btr").value=str;
		    		}
				}
				//发送数据
				xmlhttp.open("POST","${pageContext.servletContext.contextPath}/ForgetServlet_ajaxEnter.do",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("phone="+phone);
			}
			function valida(){
				var name = document.querySelector("#bti");
				var pwd = document.querySelector("#btv");
				var f = document.querySelector("#form");
				var yzm = document.querySelector("#btr");		
				if(name.value == ""){
					alert("手机号码不能为空!");
					return;
				}else{
				}
						
				if(pwd.value == ""){
					alert("验证码不能为空!");
					return;
				}else{
				}
				
				if(pwd.value != yzm.value){
					alert("验证码错误!");
					return;
				}
				
						
				f.submit();
			}
		</script>
		
		
	</head>
	<body>
		<!--头部-->
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
		<!--头部-->
		
		<div class="forget1">
			<!--标题-->
			<div class="title">
				<strong>如果你忘记了密码?那么请看下面</strong>
			</div>
			<!--固定的信息-->
			<div class="forget1-1">
				<div class="forget1-1-1">
					<p>你可以通过你的手机号码来重置你的密码</p>
				</div>
				
				<div class="forget1-1-4">
					<li>2019 饼干罐(中国)工作室 版权所有</li>
					<li>忘记密码会让网站工作人员很累</li>
					<li>如果可以，将密码用记事本记录下来</li>
					<li>每一次登录，可以让你更快的记住密码</li>
					<li>下次一定不要忘记密码了</li>
				</div>
				
				<!--form表单用来提交手机号码等信息-->
				<form id="form" action="${pageContext.servletContext.contextPath}/ForgetServlet_enterReset.do">
					<div class="forget1-1-2">
						<input id="bti" name="phone" type="text" placeholder="   /手机号码" />
					</div>
					
					
					<div class="forget1-1-3">
						<input id="btv" name="vali" type="text" placeholder="   /输入发送到你手机的验证码" />
						<button type="button"  id="btx" onclick="sendMsg();checkPhone()">发送验证码</button>
						<input style="display:none;" id="btr" name="yzm" type="text" />
					</div>
			
					<script type="text/javascript">
						var butt = document.querySelector("#btx");
						var i = 10;
						var timexs ;
						function sendMsg(){
							butt.style.backgroundColor = "gray";
							butt.disabled = "disabled";
							timexs = setInterval("timeBack()",1000);
						}
						function timeBack(){
							butt.innerText = i;
							i--;
							if(i < 0){
								butt.style.backgroundColor = "black";
								butt.disabled = false;
								clearInterval(timexs);
								butt.innerText = "重新发送验证码";
								i = 10;
							}
						}
						
					</script>
					<div class="forget1-1-5">
						<button type="button" onclick="valida()">验证</button>
					</div>
					<div class="forget1-1-5">
						<button type="button" onclick="question()">换种方式验证</button>
					</div>
				</form>
			</div>
			<!--右边工作室图标-->
			<div class="forget1-2">
				<div class="forget1-2-1">
					<img src="../img/饼干罐工作室图标.png" width="350px" height="350px"/>
				</div>
			</div>
		</div>
		
		<!--底部-->
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
		<!--底部-->
	</body>
</html>
