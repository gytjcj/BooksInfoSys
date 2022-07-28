<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书修改</title>
<style type="text/css">
body{
 		background-image: url(jpg/update.gif);    
        background-size:cover;
     }
input{
		width:200px;
		height:25px;
		border-radius: 10px;
        outline: none;
        text-indent: 1em;
        border: 1px solid #ccc;
        /* color:#fff; */
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
      		background:url(jpg/6.jpg);
        }
font{
		color:black;
}    
</style>
</head>
<body>
<div align="center">
<form action="/BooksInfoSys/Book?type=UpdateBook" method="post">
			<table align="center">
			<c:forEach items="${ulist}" var="book">
				<tr>
					<td align="right"><font>编号：</font><input type="text" name="uid" value="${book.id}" readonly></input>
					</td>
				</tr>
				<tr>
					<td align="right"><font>类型：</font><input type="text" name="utype" value="${book.type}"></input>
					</td>
				</tr>
				<tr>
					<td align="right"><font>书名：</font><input type="text" name="uname" value="${book.name}"></input>
					</td>
				</tr>
				<tr>
					<td align="right"><font>数量：</font><input type="text" name="ucount" value="${book.count}"></input>
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