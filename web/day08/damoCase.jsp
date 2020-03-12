<%@ page import="day08.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<style>
    table{
        border: 1px solid black;
        text-align: center;
    }
    tr{
        border: 1px solid black;
        text-align: center;
    }
    td{
        border: 1px solid black;
        text-align: center;
    }
</style>
<body>
<%
    User user=new User();
    user.setName("张三");
    user.setPassword("zhangsan");
    user.setAge(15);
    user.setBirthday(new Date());

    User user1=new User();
    user1.setName("李四");
    user1.setPassword("lisi");
    user1.setAge(16);
    user1.setBirthday(new Date());

    User user2=new User();
    user2.setName("王二");
    user2.setPassword("wanger");
    user2.setAge(18);
    user2.setBirthday(new Date());
    List <User> list=new ArrayList<>();
    list.add(user);
    list.add(user1);
    list.add(user2);
    request.setAttribute("UserList",list);

%>
<table>
    <tr>
        <td>姓名</td>
        <td>密码</td>
        <td>年龄</td>
        <td>出生日期</td>
    </tr>
    <c:forEach var="user" items="${requestScope.UserList}">
    <tr>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>${user.age}</td>
        <td>${user.birStr}</td>
    </tr>

    </c:forEach>


</table>

</body>
</html>
