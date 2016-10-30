<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>url</title>

<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
html {
	height: auto;
}
body {
	text-align: center;
	font-family: "Microsoft YaHei";
	z-index: 0;
}
ul {
	width: 75%;
	height: auto;
	border: red solid 1px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}
li {
	float: left;
	list-style: none;
	margin: 10px;
}
a {
		width: 230px; 
		height: 130px; 
		border: 1px black solid; 
		cursor: pointer; 
		display: block;
}
input {
	margin-left: auto;
	margin-right: auto;
	display: block;
	width: 450px;
	height: 40px;
	font-weight: bolder;
	font-size: 18px;
}
#screen {
	width: 100%;
	height: 100%;
	background-color: #DFDFDF;    /* 遮蔽层背景颜色  */
	display: none;
	z-index: 98;
	position: absolute;
	top: 0;
	filter: alpha(opacity=50);
	-moz-opacity: 0.5;
	opacity: 0.5;
	left: 0;
}
.shadow {
	box-shadow: 0 4px 23px 8px #9E9E9E;   /* 阴影关键字 */
	display: none;
	background-color: #fff;   /* 弹出窗体背景颜色   */
}
#shadow-box {
	position: absolute;
	top: 25%;
	left: 30%;
	width: 40%;
	height: 400px;
	margin-left: auto;
	margin-right: auto;
	z-index: 100;
	border-radius: 7px;
}
.append_element {
	background-color: #E8E8E8;
}		
.close-box {
	width: 15px;
	height: 15px;
	position: absolute;
	right: 10px;
	top: 10px;
	border-radius:10px;
}
.upload-box {
	width: 100%;
	height: 100%;
	margin-top: 85px;
}
.text {
	color: #ccc;
}


</style>

</head>
<body>

<!-- 遮蔽层 -->
<div id="screen"></div>
	<div class="shadow" id="shadow-box">
		<div class="close-box">
			<img class="close" alt="" title="close" src="${pageContext.request.contextPath}/lib/img/IDR_CLOSE_DIALOG.png" />
		</div>
	
	<div class="upload-box">
		<form id="upload-form" action="upload" method="post" enctype="multipart/form-data">
			  <input type="text" class="text url" name="urlName" value="请输入网址名称 如：百度"><br/>
			  <input type="text" class="text urlName" name="url"  value="请输入网址 如：www.baidu.com  建议复制粘贴"><br/>
			  <input id="fileupload" name="file" type="file"><br/>
			  <input value="添加书签" type="submit"><br/>
		</form>
	</div>
</div>


listSize:   
<br/><br/>

<hr><br>

<div class="c_container">
	<div class="c_sub_container">
		<ul>
			<c:forEach items="${list }" var="url">
					<li title="${url.urlName }">
						<a href="${url.url }" title="${url.urlName }" target="_blank">
							<img width="230" height="130" alt="${url.urlName }" title="${url.urlName }" src="${pageContext.request.contextPath}/lib/img/${url.imgName}">
						</a><br/><br/>
					</li>
			</c:forEach>
		
			<c:forEach items="${list1 }" var="url">
						<li title="${url.urlName }">
							<a href="${url.url }" title="${url.urlName }" target="_blank">
								<img width="230" height="130" alt="${url.urlName }" title="${url.urlName }" src="${pageContext.request.contextPath}/lib/img/${url.imgName}">
							</a><br/><br/>
						</li>
			</c:forEach>
		
			<li>
				<a class="append_element"></a>
			</li>
		</ul>
	</div>
</div>



<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
var ipt_urlName_count=0, ipt_url_count=0;
	$(function(){
		
		//遮蔽层开启
		$(".append_element").click(function(){
			$("#shadow-box").fadeToggle("slow");
			$("#screen").show();
			$(".close").show();
		});
		
		//遮蔽层关闭
		$(".close-box ").unbind("click").unbind("mouseover").unbind("mouseout");
		$(".close-box ").bind("click",function(){
			$(this).parent().fadeToggle("slow");
			$("#screen").hide();
			ipt_urlName_count=0;
			ipt_url_count=0;
			$(".text[name=url]").css("color", "#ccc").val("请输入网址 如：www.baidu.com  建议复制粘贴");
			$(".text[name=urlName]").css("color", "#ccc").val("请输入网址名称 如：百度");
		}).bind("mouseover",function(){
			$(this).children().attr("src","../lib/img/IDR_CLOSE_DIALOG_H.png");
			//$(this).css("background-color","#ccc");  如果不是转换图片
		}).bind("mouseout",function(){
			$(this).children().attr("src","../lib/img/IDR_CLOSE_DIALOG.png");
			//$(this).css("background-color","#fff");  如果不是转换图片
		});
		
		//文本框清空
		$(".text").focus(function(){
			$(this).css("color", "black");
			if($(this).attr("name")=="url"){
				if(ipt_url_count<1){
					$(this).val("");
					ipt_url_count+=1;
				}else{
					ipt_url_count+=1;
				}
// 				console.log(ipt_url_count);
			}
			if($(this).attr("name")=="urlName"){
				if(ipt_urlName_count<1){
					$(this).val("");
					ipt_urlName_count+=1;
				}else{
					ipt_urlName_count+=1;
				}
// 				console.log(ipt_urlName_count);
			}
		});
		
		//过滤上传文件格式
		$("#fileupload").unbind("change");
		$("#fileupload").bind("change", function(){
			var val = $(this).val();
			if(""!=val&&val.length>0){
				var sufIndex = val.lastIndexOf(".");
				if(sufIndex>0&&sufIndex<val.length-1) {
					var suffix = val.substring(sufIndex+1);
					suffix=suffix.toLowerCase();
					if(suffix=="png"||suffix=="jpg"||suffix=="jpeg"||suffix=="bmp"||suffix=="gif"){
						console.log("file_suffix ===> "+suffix);
					}else{
						$(this).val("");
						alert("请选择图片文件  !\n\n支持png   jpg   jpeg   bmp   gif格式  !");
					}
				}
			}
		});
		
		
		
	});
</script>
</body>
</html>
