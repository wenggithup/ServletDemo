<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%-- if标签--%>
<c:if test="true"></c:if>
<%
    request.setAttribute("number",3);
    //存入集合
    List <String> list=new LinkedList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);

%>
<%-- choose标签--%>
<c:choose>
    <c:when test="${requestScope.number ==1}">星期一</c:when>
    <c:when test="${requestScope.number ==2}">星期二</c:when>
    <c:when test="${requestScope.number ==3}">星期三</c:when>
    <c:when test="${requestScope.number ==4}">星期四</c:when>
    <c:when test="${requestScope.number ==5}">星期五</c:when>
    <c:when test="${requestScope.number ==6}">星期六</c:when>
    <c:when test="${requestScope.number ==7}">星期日</c:when>
    <c:otherwise>数字输入有误</c:otherwise>
</c:choose>
<%-- for循环--%>
<%--1、重复操作--%>
<c:forEach begin="1" end="10" step="1" var="i" varStatus="s">
    ${i} --- ${s.index} --- ${s.count}<br>

</c:forEach>
<%--2、遍历容器--%>
<c:forEach var="str" items="${requestScope.list}" varStatus="s">
    ${str} -- ${s.index} -- ${s.count}<br>
</c:forEach>
</body>
</html>
