
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <%--核心bootstrap css引入--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootStrap/css/bootstrap.css"/>
    <%--核心bootstrap js引入--%>
    <script src="${pageContext.request.contextPath}/bootStrap/jquery/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/bootStrap/js/bootstrap.js"></script>
    <%-- 用户名密码提示错误 --%>
    <style>
        .user-error{
            color: red;
            font-size: larger;
        }
    </style>
</head>
<body>
<%--表单--%>
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/findUserByServlet">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="username" placeholder="请输入用户名" width="100px"  >
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码 " width="100px" >
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> 记住密码
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
</form>
<div class="user-error">
    <%
        String user_error =(String) request.getAttribute("user_error");
        if(user_error!=null){
            out.write(user_error);
            request.getSession().removeAttribute("user_error");
        }else {
            out.write("");
        }
    %>
</div>
</body>
</html>
