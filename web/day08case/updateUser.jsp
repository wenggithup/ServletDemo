
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    div{
        margin-left: 40%;
    }
</style>
<head>
    <title>createUser</title>
    <%--核心bootstrap css引入--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootStrap/css/bootstrap.css"/>
    <%--jquery js引入--%>
    <script src="${pageContext.request.contextPath}/bootStrap/jquery/jquery-3.3.1.js"></script>
    <%--核心bootstrap js引入--%>
    <script src="${pageContext.request.contextPath}/bootStrap/js/bootstrap.js"></script>
</head>
<body>

<h2 style="text-align: center">修改用户信息</h2>
<hr>
<form action="${pageContext.request.contextPath}/updateUserServlet?id=${USER.id}" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">姓名:</label>
        <input   type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入姓名" name="name" style="width:300px;" value="${USER.name}">
    </div>
    <div>
        <c:if test="${USER.gender=='男'}">
            性别：
            <input type="radio" name="gender" checked="checked" value="男">男
            <input type="radio"  name="gender" value="女">女
        </c:if>
        <c:if test="${USER.gender=='女'}">
            性别：
            <input type="radio" name="gender"  value="男">男
            <input type="radio"  name="gender" checked="checked" value="女">女
        </c:if>

    </div>
    <br>
    <div class="form-group">
        <label for="exampleInputPassword1">年龄:</label>
        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入年龄" name="age" style="width:300px;" value="${USER.age}">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">籍贯:</label>
        <input type="text" class="form-control" id="exampleInputPassword3" placeholder="陕西" name="address" style="width:300px;" value="${USER.address}">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">QQ:</label>
        <input type="text" class="form-control" id="exampleInputPassword4" placeholder="请输入QQ号码" name="qq" style="width:300px;" value="${USER.qq}">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Email:</label>
        <input type="text" class="form-control" id="1dsad" placeholder="请输入邮箱地址" name="email" style="width:300px;" value="${USER.email}">
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
