<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书添加</title>
<style type="text/css">
body{
 		background-image: url(jpg/add.gif);    
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
<div align="center" class="add">
<%-- <%
request.setAttribute("date", new Date());
%>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss">
</fmt:formatDate><br/>
${empty date} --%>
<form action="/BooksInfoSys/Book?type=AddBook" method="post">
			<table align="center">
			<!-- 	<tr>
					<td align="right">编号：<input type="text" name="auid"></input>
					</td>
				</tr> -->
				<tr>
					<td align="right"><font>类型：</font><input type="text" name="Atype"></input>
					</td>
				</tr>
				<tr>
					<td align="right"><font>书名：</font><input type="text" name="Aname"></input>
					</td>
				</tr>
				<tr>
					<td align="right"><font>数量：</font><input type="text" name="Acount"></input>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" style="width: 66px"></input>
					
					</td>
				</tr>
			</table>
		</form>
</div>
</body>
</html>