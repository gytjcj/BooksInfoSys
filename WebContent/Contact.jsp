<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Tam - Creative Portfolio Template" />
	<meta name="keywords" content="blog, business card, creative, creative portfolio, cv theme, online resume, personal, portfolio, professional cv, responsive portfolio, resume, resume theme, vcard" />
	<meta name="author" content="beingeorge" />
	<meta name="theme-color" content="#2a2d35">

	<!-- Vendor Css-->
	<link rel="stylesheet" href="assets/css/vendor.css" />
	<link rel="stylesheet" href="assets/css/LineIcons.min.css" />	

	<!-- TamTemplate style Css -->
	<link href="assets/css/tam.css" rel="stylesheet">

<title>说明书</title>
</head>
<body data-spy="scroll" data-target=".navbar">
     <!-- START: Preloader -->
	<div id="preloader" class="preloader">
		<div class="spinner-grow text-dark" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<div class="page-overlay">
    	<span class="overlay-1"></span>
    	<span class="overlay-2"></span>
    </div>

    <div class="page-wrapper">

		<!-- START: CONTACT -->
		<section class="section section-light section-contact" id="contact">
			<div class="container">
				<div class="section-head">
					<span>小提示</span>
					<h2>介绍 </h2>
				</div>

				<div>

	<h1 align="center">编外图书管理系统说明书</h1>
	<h2>一、编写目的</h2>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本文档为图书馆的系统说明书，向阅读人员介绍本图书管理系统的框架和设计。
	
	<h2>二、背景</h2>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.项目名称：编外图书;<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.开发人员：编外人员;<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.用户：图书管理系统管理员，读者.<br/>

	
	<h2>三、概述</h2>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图书馆管理系统主要的 目的是实现图书馆的信息化管理。
	图书馆的主要业务就是新书的借阅和归还，因此系统最核心的功能便是实现图书的借阅和归还。
	此外，还需要提供图书的信息查询、读者图书借阅情况的查询等功能。
	此项目，能够提高图书馆的图书借阅、归还流程，提高工作效率。

	<h2>四、概念设计</h2>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户分为两类：读者、图书馆管理员。图书馆管理员可以修改读者信息，修改图书信息，查看所有借还日志等；
	读者仅可以注册个人信息、借阅或归还书籍和查看自己的借还日志。<br/>
	
	<h2>五、系统组织结构</h2>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.系统框架：本系统包含客户层、中间层、管理层，其中客户层用于用户与客户端的交互，例如，显示信息
	、查询信息、提交信息、输入数据等。中间层就是服务器部分，主要用来实现数据的接受与发送，并作为一座桥梁，连接客户与数据库。管理层主要实现数据的处理功能。<br/><br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.系统安全性：中间层的引入能有效地对系统与数据进行保护，用户无法直接修改、删除信息。使系统安全性
	得到了保障，有效地避免了数据丢失等问题。<br/><br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.系统功能模块：（1）注册、登录:不同的登陆者有不同的系统权限；<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（2）用户登录：只有注册过，有密码的用户才能登录；<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（3）图书信息查询、预览；<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（4）图书借阅：读者登录后查找自己喜欢的图书进行借阅；<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（5）图书归还：登录后读者根据自己的账号，进行对借阅的图书以归还，消除借阅记录。<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（6）借阅查询：登录后读者可以查询自己的借书情况；<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（7）个人信息查询：查询自己的个人信息；<br/>
	</div>
</div>
</section>
</div>

	<!-- JAVASCRIPTS -->

	<script src="https://www.jq22.com/jquery/jquery-3.3.1.js"></script>
<script src="assets/js/vendor.js"></script>

	<!-- Map -->
	<script src="assets/js/map.js"></script>
	<script src="https://ditu.google.cn/maps/api/js?key=AIzaSyD79MY72taVRlZVX2DU6L5PXOh3ezUUKMc&amp;callback=initMap" async="" defer=""></script>
	
	<!-- Custom Js -->
	<script src="assets/js/custom.js"></script>
</body>
</html>