<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020-03-14
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createUser</title>
    <%--核心bootstrap css引入--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootStrap/css/bootstrap.css"/>
    <%--jquery js引入--%>
    <script src="${pageContext.request.contextPath}/bootStrap/jquery/jquery-3.3.1.js"></script>
    <%--核心bootstrap js引入--%>
    <script src="${pageContext.request.contextPath}/bootStrap/js/bootstrap.js"></script>
    <style>
        div{
            margin-left: 40%;
        }
    </style>
</head>
<body>


<form action="${pageContext.request.contextPath}/creatUserServlet" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">姓名:</label>
        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入姓名" name="name" style="width: 300px">
    </div>
    <div>
        性别：
      <input type="radio" name="gender" checked="checked" value="男" >男
      <input type="radio"  name="gender" value="女">女

    </div>
    <br>
    <div class="form-group">
        <label for="exampleInputPassword1">年龄:</label>
        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入年龄" name="age" style="width: 300px">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">籍贯:</label>
        <input type="text" class="form-control" id="exampleInputPassword3" placeholder="陕西" name="address" style="width: 300px">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">QQ:</label>
        <input type="text" class="form-control" id="exampleInputPassword4" placeholder="请输入QQ号码" name="qq" style="width: 300px">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Email:</label>
        <input type="text" class="form-control" id="1dsad" placeholder="请输入邮箱地址" name="email" style="width: 300px">
    </div>
    <div>
        <input class="btn btn-primary" type="submit" value="提交">
        <input class="btn btn-default" type="reset" value="重置">
        <a href="${pageContext.request.contextPath}/UserListServlet">
            <input class="btn btn-default" type="button" value="返回">
        </a>


    </div>
</form>
</body>
</html>
