<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--核心bootstrap css引入--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootStrap/css/bootstrap.css"/>
    <%--核心bootstrap js引入--%>
    <script src="${pageContext.request.contextPath}/bootStrap/jquery/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/bootStrap/js/bootstrap.js"></script>
    <%-- 用户名密码提示错误 --%>
<style>
    .head{
        text-align: center;
        color: #7abaff;
    }
</style>
    <script>
       function deleteUser(id) {
           var b = confirm("您确定要删除此条信息吗？");
           if(b){
               location.href="${pageContext.request.contextPath}/deleteServlet?id="+id;
           }else {
               return;
           }

       }
       function updateUser(id) {
           var b = confirm("您确定要更新此条信息吗？");
           if(b){
               location.href="${pageContext.request.contextPath}/updateServlet?id="+id;
           }else {
               return;
           }

       }
       window.onload=function () {
           document.getElementById("delSelected").onclick=function () {
               document.getElementById("form").submit();
           }

       }

    </script>
</head>
<body>
<div class="head"><h3>学生信息表</h3></div>
<hr>
<div>
    <form class="form-inline" action="${pageContext.request.contextPath}/findUserByServlet" method="post">
        <div class="form-group">
            <label for="exampleInputName2" >姓名:</label>
            <input type="text" class="form-control" id="exampleInputName2" name="name" value="${map.name[0]}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2" >籍贯:</label>
            <input type="text" class="form-control" id="exampleInputEmail2" name="address" value="${map.address[0]}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2" >邮箱:</label>
            <input type="text" class="form-control" id="exampleInputEmail3" name="email" value="${map.email[0]}">
        </div>
        <button type="submit" class="btn btn-primary">查询</button>
    </form>
</div>
<div style="float: right;margin: 5px">
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/day08case/create.jsp">添加联系人</a>
    <a class="btn btn-primary" href="javascript:void (0);" id="delSelected">删除选中</a>
</div>
<form action="${pageContext.request.contextPath}/deleteCheckbox" method="post" id="form">
<table class="table table-hover">
    <tr>
        <th><input type="checkbox"></th>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>籍贯</td>
        <td>QQ</td>
        <td>邮箱</td>
        <td>操作</td>
    </tr>
    <%--使用jstl遍历集合--%>

   <c:forEach items="${pageBean.list}" var="user" varStatus="s">
       <tr>
           <td><input type="checkbox" name="uid" value="${user.id}"></td>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td>
                <a href="javascript:updateUser(${user.id})">
                    <input type="button" value="修改">
                </a>
                <a href="javascript:deleteUser(${user.id})">
                    <input type="button" value="删除">
                </a>

            </td>


       </tr>

   </c:forEach>

</table>
</form>
<div>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
                <c:if test="${pageBean.currentPage==1}">
                    <li class="page-item disabled">
                        <a class="page-link" href="${pageContext.request.contextPath}/findUserByServlet?currentPage=${pageBean.currentPage-1}&rows=5">上一页</a>
                    </li>
                    </c:if>
                <c:if test="${pageBean.currentPage!=1}">
                    <li class="page-item">
                        <a class="page-link" href="${pageContext.request.contextPath}/findUserByServlet?currentPage=${pageBean.currentPage-1}&rows=5">上一页</a>
                    </li>
                </c:if>

                    <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                        <c:if test="${pageBean.currentPage==i}">
                            <li  class="active page-item"><a href="${pageContext.request.contextPath}/findUserByServlet?currentPage=${i}&rows=5" class="page-link">${i}</a></li>
                        </c:if>
                        <c:if test="${pageBean.currentPage!=i}">
                            <li class="page-item"><a href="${pageContext.request.contextPath}/findUserByServlet?currentPage=${i}&rows=5" class="page-link">${i}</a></li>
                        </c:if>
                    </c:forEach>
                <c:if test="${pageBean.currentPage==pageBean.totalPage}">
                    <li class="page-item disabled"><a class="page-link" href="${pageContext.request.contextPath}/findUserByServlet?currentPage=${pageBean.currentPage+1}&rows=5">下一页</a></li>
                </c:if>
                 <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                     <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/findUserByServlet?currentPage=${pageBean.currentPage+1}&rows=5">下一页</a></li>
                </c:if>
                    <span>共${pageBean.totalCount}条记录，共${pageBean.totalPage}页</span>
        </ul>
    </nav>
</div>
</body>
</html>
