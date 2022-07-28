<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员登录</title>
<style>
        * {
            margin: 0;
            padding: 0;
        }
        
        body {
	background-color:#232323 ;
        }
        
        form {
			color: #fff;
            position: relative;
            bottom:250px;
            margin: 300px auto;
            width: 600px;
            height: 250px;
            text-align: center;
            border: 1px solid rgb(255 255 255 / 0.33);
            transition: all 0.5s;
            border-radius: 10px;
            background-color:#97CBFF;
            background:url(jpg/10.jpg);
        }
        
        form:hover {
	transform: translate(10px);
	box-shadow: 10px 10px 10px 0 rgba(0,0,0,.1);
	-webkit-box-shadow: 10px 10px 10px 0 rgba(0,0,0,.1);
	border: 2px solid #000;
        }
        
        input {
            margin-top: 25px;
            width: 200px;
            height: 40px;
            border-radius: 10px;
            outline: none;
            text-indent: 1em;
            border: 1px solid #ccc;
        }
        
        button {
            margin: 40px 10px;
            width: 80px;
            height: 40px;
            border: none;
            color: #fff;
            background-color:#30e391;
            border-radius: 10px;
            outline: none;font-weight: 600;transition: all 0.5s;cursor: pointer;
        }
        
        .content {
    position: absolute;
    right: -250px;
    height: 40px;
    width: 260px;
    text-align: center;
    line-height: 40px;
    border: 1px solid #ffffff54;
    background-color: #30e391;
    border-radius: 5px;
    opacity: 0;
    transition: all 0.9s;
}
        
        .content1 {
            top: 20px;
        }
        
        .content2 {
            top: 82px;
        }
        
        p {
            color: #fff;
            font-size: 14px;
        }
        
        i {
            position: absolute;
            left: -24px;
            top: 8px;
            display: inline-block;
            width: 0;
            height: 0;
            border: 12px solid transparent;
            border-right-color: #30e391;
        }
        
        input:focus~div {
            right: -200px;
            opacity: 1;
        }
        
        .sub {
            margin: 40px;
            width: 80px;
            height: 40px;
            border: none;
            color: #fff;
            border-radius: 10px;
            outline: none;
            text-indent: 0;
            background-color: #30e391;font-weight: 600;transition: all 0.5s;cursor: pointer;
        }
        
        .sub:hover {
            background-color: red;
        }
        
        button:hover {
            background-color: red;
        }
		body{
 		background-image: url(jpg/login.gif);    
        background-size:cover;  
     
		}
		b{
			color:black;
		}
</style>
<script type="text/javascript" src="/BooksInfoSys/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
</script>
<script type="text/javascript" src="/BooksInfoSys/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$("html,input,#DDv").hover(function() {
		//集合ID，能统一联动

				if ($("#mpassword").val() == "") {
					$("#DDv").text("");
				} else if ($("#mpassword").val().length < 6||$("#mpassword").val().length > 6) {
					$("#DDv").css("color", "red")
					$("#DDv").text("!密码位数不正确");
				} 
			})
});
</script>


</head>
<body>

	<form action="/BooksInfoSys/Login?type=manage" method="post">
		<div>
			<b>账号：</b> <input type="text" name="mname" /><br />
		<div class="content content1">
			<i></i>
			<p>请输入您的账号</p>
		</div>
		</div>
		<div>
			<b>密码：</b> <input type="password" name="mpassword" id="mpassword"/>
		<div class="content content2" >
			<i></i>
			<p>请输入您的密码</p>
			<div id="DDv" style="width: 150px;" align="left"></div>
		</div>
		</div>

			<input type="submit" value="登录" class="sub"/>
			<input type="reset" value="重置" class="sub"/>
			
		</form>
				
			
</body>
</html>