<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/BooksInfoSys/js/jquery-3.5.1.min.js"></script>
<style type="text/css">
body{
 		background-image: url(jpg/upuser.gif);    
        background-size:cover;  
     
}
a:link {color: black} /* 未被访问的链接 黑色 */
a:visited {color:black} /* 已被访问过的链接 黑色 */
a:hover {color:#00EC00} /* 鼠标悬浮在上的链接 绿色 */
</style>
<!--设置基准目标-->
<base target="frmRgt"/>
</head>
<script>
window.onload=function(){
//定时器每秒调用一次fnDate()
setInterval(function(){
	fnDate();
	},
	1000);
	}

//js 获取当前时间
function fnDate(){
	var oDiv=document.getElementById("time");
	var date=new Date();
	var year=date.getFullYear();//当前年份
	var month=date.getMonth();//当前月份
	var data=date.getDate();//天
	var hours=date.getHours();//小时
	var minute=date.getMinutes();//分
	var second=date.getSeconds();//秒
	var time=year+"-"+fnW((month+1))+"-"+fnW(data)+" "+fnW(hours)+":"+fnW(minute)+":"+fnW(second);
	oDiv.innerHTML=time;
	}
//补位 当某个字段不是两位数时补0
function fnW(str){
	var num;
	str>10?num=str:num="0"+str;
	return num;
	} 
</script> 
<body >
<div align = "center">
<a href="/BooksInfoSys/Users?type=UserLook">用户查看</a> <!--target:绑定显示窗口，通过框架别名-->
<a href="/BooksInfoSys/BroBooksServlet?method=select" >借阅信息查看</a>
<a href="/BooksInfoSys/Book?type=BookLook" >图书查看</a>
<a href="/BooksInfoSys/Login.jsp" >退出登录</a><br/>
<div id="time"></div>
</div>
</body>
</html>