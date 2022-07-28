<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
<script type="text/javascript" src="/BooksInfoSys/js/jquery-3.5.1.min.js"></script>


<style type="text/css">
body{
 		background-image: url(jpg/upuser.gif);    
        background-size:cover;
     }
input{
		width:200px;
		height:25px;
		border-radius: 10px;
        outline: none;
        text-indent: 1em;
        border: 1px solid #ccc;
        
}
form {
			color: #fff;
            position: relative;
            bottom:250px;
            margin: 300px auto;
            width: 400px;
            height: 250px;
            text-align: center;
            border: 1px solid rgb(255 255 255 / 0.33);
            transition: all 0.5s;
            border-radius: 10px;
            background-color:#97CBFF;
      		background:url(jpg/13.jpg);
        }
 font{
		color:black;
}
    
</style>
</head>

<body>
<div align="center">
	<form action="/BooksInfoSys/Users?type=UpdateUsers" method="post" >
		<table align="center">
		<c:forEach items="${ulist}" var="user">
			<tr>
					<td align="right"><font>编号：</font><input type="text" name="uid" value="${user.id}" readonly></input>
					</td>
				</tr>
			<tr>
				<td align="right"><font>姓名：</font><input type="text" name="uname" value="${user.name}"></input>
				</td>
			</tr>
			<tr>
				<td align="right"><font>性别：</font><input type="text" name="usex" value="${user.sex}"></input>
				</td>
			</tr>
			<tr>
				<td align="right"><font>电话：</font><input type="text" name="uphone" value="${user.phone}"></input>
				</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" style="width: 66px"></input>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</div>
</body>
</html>