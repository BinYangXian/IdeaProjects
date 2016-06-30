<%@ page import="com.springapp.mvc.db.entities.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<ol><%--序列表--%>
    <%for (UsersEntity e : (List<UsersEntity>) request.getAttribute("users")) {%> <%--循环生成列表--%>
    <li>名字：<%out.print(e.getName());%> ，年龄：<%out.print(e.getAge());%></li>
    <%}%>
</ol>
<a href="adduser">添加用户</a><%--href：url地址链接，也可以是超链接--%>
</body>
</html>