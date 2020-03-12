<%@ page import="day08.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020-03-11
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%--
            1、pageContext
            2、request
            3、session
            4、application
            5、response
            6、page
            7、out
            8、config
            9、exception
--%>

<%
    User user=new User();
    user.setName("张三");
    user.setPassword("李四");
    user.setAge(15);
    user.setBirthday(new Date());
    request.setAttribute("user",user);
%>
    ${requestScope.user.name}
    ${requestScope.user.password}
    ${requestScope.user.age}
    ${requestScope.user.birStr}
</body>
</html>
