<%@page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
名字：${name}<br> <%--br是换行符--%>
年龄：${age}
<%
response.sendRedirect("users");
%><%--listUsers存储完所有数据之后再重新跳转到所有用户列表（users.jsp）里--%>
</body>
</html>