<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--用户修改头像-->
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/head.css" />
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/message.js" ></script>
	</head>
	<body>
		<div class="bott">
		<div class="d1">
			<div class="d1-1">| 我的头像</div>
			<form action="${pageContext.servletContext.contextPath}/UserServlet_enterhead.do" method="post" enctype="multipart/form-data">
			<div class="d1-2">
					<div class="h1">
						<!--<i class="fa fa-camera-retro"></i>-->
						<div id="imgContainer" style="margin-top: 7px;"></div>
					</div>
			</div>
			<div class="d1-3">
				<button type="button"  class="btn">
					<div style="position: relative;">
						<input id="upload-input" style="position: absolute; top: 0; bottom: 0; left: 0;right: 0; opacity: 0;" type="file" name="head" onchange="showImg(this)" multiple />
						<div style="text-align: top">
							<span style="font-size: 20px;">选择图片</span>
							<!--<i class="fa fa-photo" id="upload" src="./upload.png"></i>-->
						</div>
					</div>
				</button>
				<button class="btn" style="font-size: 20px;" type="submit">上传图片</button>
			</div>
			</form>
		</div>
		</div>
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
				img.setAttribute('style', 'width: 470px; height: 350px; vertical-align: middle; margin-left: 230px;')
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
