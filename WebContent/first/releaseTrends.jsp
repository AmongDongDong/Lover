<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/zui-1.9.0-dist/dist/lib/jquery/jquery.js"></script>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
			<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/top.css" />
		
		<style type="text/css">
			body {
				padding: 0px;
				margin: 0px;
			}
			
			.bottom100 {
				/*height: 700px;*/
				width: 100%;
				/*background-color: salmon;*/
			}
			
			.base {
				width: 1000px;
				/*height: 700px;*/
				background-color: white;
			}
			
			.base1 {
				width: 999px;
				/*height: 600px;*/
				background-color: white;
				float: left;
				margin-top: 120px;
				/*border: 1px solid #E3E4E5;*/
			}
			
			.head {
				width: 777px;
				background-color: white;
				float: left;
				/*border: 1px solid #E3E4E5;*/
			}
			
			.head1 {
				width: 757px;
				height: 110px;
				/*background-color: firebrick;*/
				float: left;
				/*margin-top: 10px;
				line-height: 45px;
				text-align: left;
				padding-left: 20px;*/
			}
			
			.head2 {
				width: 777px;
				height: 140px;
				/*background-color: firebrick;*/
				float: left;
				margin-top: 10px;
			}
			
			.head2-2 {
				width: 40px;
				height: 40px;
				/*background-color: forestgreen;*/
				float: left;
				margin-top: 0px;
				text-align: left;
				padding-left: 20px;
				position: relative;
			}
			
			.i1 {
				font-size: 22px;
				line-height: 40px;
			}
			
			.hidden1 {
				width: 777px;
				height: 255px;
				float: left;
				background-color: white;
				position: absolute;
				margin-left: -40px;
				display: none;
				border: 1px solid #E3E4E5;
			}
			
			.hidden1-base {
				width: 757px;
				height: 245px;
				/*background-color: cadetblue;*/
				margin-top: 10px;
				margin-left: 10px;
			}
			
			.hidden1-mid {
				width: 747px;
				height: 200px;
				/*background-color: forestgreen;*/
				padding-left: 10px;
				margin-top: 10px;
				border: 1px solid #E3E4E5;
			}
			
			.hidden1-bottom {
				padding-left: 10px;
			}
			
			.head2-1 {
				width: 757px;
				height: 40px;
				/*background-color: honeydew;*/
				float: left;
				margin-top: 0px;
				text-align: left;
				padding-left: 20px;
				border: 1px solid #E3E4E5;
			}
			
			.head2-1 i {
				font-size: 20px;
				line-height: 40px;
			}
			
			.head2-1 button {
				width: 70px;
				height: 30px;
				float: right;
				line-height: 10px;
				font-size: 16px;
				border-radius: 12px;
				background-color: #1995E4;
				margin-top: 5px;
				margin-right: 20px;
			}
			
			.head2 textarea {
				width: 772px;
				height: 89px;
				/*border-bottom: none;
				border-right: none;
				border-left: none;*/
			}
			
			.head3 {
				width: 757px;
				/*height: 390px;*/
				float: left;
				/*background-color: red;*/
				text-align: left;
				padding-left: 20px;
			}
			
			.head3-1 {
				width: 100px;
				height: 100px;
				background-color: lightcoral;
				float: left;
				/*margin-left: 20px;*/
				margin-top: 20px;
			}
			
			.head3-2 {
				width: 635px;
				height: 360px;
				float: left;
				margin-left: 20px;
				margin-top: 20px;
				/*background-color: hotpink;*/
				/*border: 1px solid #E3E4E5;*/
			}
			
			.head3-21 {
				width: 617px;
				height: 40px;
				float: left;
				padding-left: 20px;
				line-height: 40px;
				/*background-color: saddlebrown;*/
			}
			
			.head3-22 {
				width: 317px;
				height: 260px;
				float: left;
				margin-left: 50px;
				margin-top: 1px;
				/*background-color: saddlebrown;*/
			}
			
			.head3-23 {
				width: 617px;
				height: 40px;
				float: left;
				padding-left: 20px;
				margin-top: 1px;
				line-height: 40px;
				/*background-color: saddlebrown;*/
			}
			
			.head4 {
				width: 203px;
				height: 140px;
				/*background-color: chocolate;*/
				float: left;
				margin-left: 15px;
				margin-top: 120px;
				border: 1px solid #E3E4E5;
			}
			
			.head4-1 {
				width: 100px;
				height: 100px;
				background-color: cadetblue;
				float: left;
				margin-left: 10px;
				margin-top: 20px;
			}
			
			.head4-2 {
				height: 30px;
				margin-top: 30px;
			}
		</style>
	</head>

	<body>
	<%@ include file="top.jsp" %>
	<form action="${pageContext.servletContext.contextPath}/FirstServlet_releaseTrends.do" method="post" enctype="multipart/form-data">
		<center>
			<div class="bottom100">
				<div class="base">
					<div class="base1">
						<div class="head">
							<div class="head1"><img src="${pageContext.servletContext.contextPath}/img/无标题6.png" /></div>

							<div class="head2">
								<textarea name="speak" placeholder="说点什么呢？"></textarea>
								<div class="head2-1">
									<div class="head2-2">
										<i id="i1" class="fa fa-camera"></i>&nbsp;
										<div class="hidden1">
											<div class="hidden1-base">
												<div class="hidden1-mid">
													<div style="position: relative;">
														<input id="upload-input" style="position: absolute; top: 0; bottom: 0; left: 0;right: 0; opacity: 0;" type="file" onchange="showImg(this)" name="photo" multiple />
														<div style="text-align: top">
															<span style="font-size: 12px;">上传图片：</span>
															<i class="fa fa-photo" id="upload" src="./upload.png"></i>
														</div>
													</div>
													<div id="imgContainer" style="margin-top: 10px;"></div>
												</div>
												<div class="hidden1-bottom">
													<div class="container">
														<a data-toggle="tooltip" title="我只是为了好看，点我也没用!">
															<i class="fa fa-gitlab"></i>&nbsp;
															<i class="fa fa-tripadvisor"></i>&nbsp;
															<i class="fa fa-motorcycle"></i>&nbsp;
															<i class="fa fa-sun-o"></i>&nbsp;
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
									<script>
										$(function() {
											$("#i1").click(function() {
												$(".hidden1").toggle();
											});
										});
									</script>
									<div class="container">
										<a data-toggle="tooltip" title="我只是为了好看，点我也没用!">
											<i class="fa fa-gitlab"></i>&nbsp;
											<i class="fa fa-tripadvisor"></i>&nbsp;
											<i class="fa fa-bug"></i>&nbsp;
											<i class="fa fa-moon-o"></i>&nbsp;
											<i class="fa fa-tree"></i>&nbsp;
											<i class="fa fa-certificate"></i>&nbsp;
											<i class="fa fa-hand-grab-o"></i>&nbsp;
											<i class="fa fa-space-shuttle"></i>&nbsp;
											<i class="fa fa-credit-card"></i>&nbsp;
											<i class="fa fa-optin-monster"></i>&nbsp;
											<i class="fa fa-reddit"></i>&nbsp;
											<i class="fa fa-slack"></i>&nbsp;
											<i class="fa fa-slideshare"></i>&nbsp;
											<i class="fa fa-snapchat"></i>&nbsp;
											<i class="fa fa-simplybuilt"></i>&nbsp;
											<i class="fa fa-superpowers"></i>&nbsp;
											<i class="fa fa-themeisle"></i>&nbsp;
											<i class="fa fa-yelp"></i>&nbsp;
											<i class="fa fa-wpexplorer"></i>&nbsp;
											<i class="fa fa-shirtsinbulk"></i>&nbsp;
										</a>
										<button type="submit" >发布</button>
									</div>

									<script>
										$(function() {
											$('[data-toggle="tooltip"]').tooltip();
										});
									</script>
								</div>
							</div>
						</div>
						<div class="head4">
							<div class="head4-1"><img width="100px" height="100px" src="${pageContext.servletContext.contextPath}/userHead/${userBasic.phone}/${userBasic.head}"></div>
							<div class="head4-2">
								${userBasic.nickname}<br />
								<i class="fa fa-paw" style="color: gold;"></i>&nbsp;
								<i class="fa fa-ge"></i>&nbsp;
								<i class="fa fa-first-order" style="color: #2E3B84;"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</center>
	</form>

	</body>
	<script type="text/javascript">
		function showImg(obj) {
			var files = obj.files
			// document.getElementById("imgContainer").innerHTML = getImgsByUrl(files)
			getImgsByFileReader(document.getElementById("imgContainer"), files)
		}

		function getImgsByFileReader(el, files) {
			for(var i = 0; i < files.length; i++) {
				let img = document.createElement('img')
				img.setAttribute('style', 'width: 120px; height: 100px; vertical-align: middle; margin-right: 5px;')
				el.appendChild(img)
				var reader = new FileReader()
				reader.onload = function(e) {
					img.src = e.target.result
				}
				reader.readAsDataURL(files[i])
			}
		}
	</script>

</html>