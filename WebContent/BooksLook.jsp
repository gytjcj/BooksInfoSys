<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1utf-8">
<title>图书查看</title>
 <script type="text/javascript" src="js/jquery.min.js"></script>
  <link rel="stylesheet" href="https://www.jq22.com/jquery/bootstrap-4.2.1.css">
  <style>
 
  
  body{
 		background-image: url(jpg/upuser.gif);    
        background-size:cover;  
     
}
 a:hover {color:black}  /* 鼠标悬浮在上的链接 黑色 */ 
  
    .content1 {
      
      width: 100%;
      height: 600px;

      display: inline-block;
      margin-top: 0px;
      margin-left: 0px;
      
      
    }

   


    #lin {
    
      margin: 20px 0;
      height: 30px;
      padding: 5px;
      box-sizing: border-box;
    }

    .names {
      width: 300px;
      margin-bottom: 30px;
    }
    
   
    table tr:nth-child(even){
        background: #E0E0E0;
    }
    
    table tr:nth-child(odd){
        background: #F0F0F0;
    }
    
    .table>tbody>tr:hover {
        background-color:#FFFACD;
    }
    
    
    td {

    text-align:center;

}
tr {

    text-align:center;

}
    
   
  </style>

</head>
<body>

<div class="content1"  align="center">
    <!-- <input type="text" id="lin" placeholder="请输入需要搜索的内容"> -->
    <input type="text" class="form-control names" id="lin" placeholder="请输入需要搜索的内容"  >
    <a href="/BooksInfoSys/AddBook.jsp">添加</a>
    <table class="table table-striped=true    table-bordered" id="table-1"   >
      <thead class="thead-light">
        <tr>
        <th style="color: blue;">编号</th>
		<th style="color: blue;">类型</th>
		<th style="color: blue;">书名</th>
		<th style="color: blue;">数量</th>
		<th style="color: blue;">操作</th>
        
        </tr>
      </thead>

      <tbody>
<c:forEach items="${list}" var="book">
        <tr>
        <td>${book.id}</td>
		<td>${book.type}</td>
		<td>${book.name}</td>
		<td>${book.count}</td>
		<td>
		<a id="del" href="/BooksInfoSys/Book?type=DelBook&did=${book.id}">下架</a>
		<a href="/BooksInfoSys/Book?type=UpdateBook&uid=${book.id}">修改</a>
		</td>
        </tr>
 </c:forEach>      
      </tbody>
    </table>
  </div>

  


  <script src="js/lin_search.js"></script>
  <script>
    //  表1


    $("#lin").on('keyup', function () {
      var table1 = $("#table-1");
      var input = $(this);
      new Search(table1, input)

    })


  

  </script>

</body>
</html>