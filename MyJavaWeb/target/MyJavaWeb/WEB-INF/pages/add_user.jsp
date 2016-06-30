<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
</head>
<body>
<%--1、使用SpringMVC显示URL参数：（同时这是纯粹的html表单，编写HTML表单提交给SpringMVC程序去处理：）--%>
<%--<form action="result" method="post"> &lt;%&ndash;method的方式与3、表单提交的参数的 方式相对应都是“post”(UserController51行)，
相对于get方式，可以传输很大的数据(因为传输数据不用放在地址栏)，而get能够对资源进行统一定位&ndash;%&gt;
    名字： <input type="text" name="name"><br>
    年龄： <input type="number" name="age"><br>
    <input type="submit"> //提交按钮
</form>--%><%--表单的关键字--%>
<%--2、使用SpringMVC提供的表单标签生成HTML，优点在于生成表单之前，能够从数据库查询所需数据填充后再生成--%>
<form:form action="result" method="get" modelAttribute="user"><%--提交的目标程序是UserController中result（方法action）
modelAttribute为了我们从ModelMap中取值来填充表单，所取的属性命名为"user"，取值方式@UserController41-45行，
45行中"user"与此处的对应；method的方式与UserController51行对应--%>
    名字：<form:input path="name"/><br>
    年龄：<form:input path="age"/><br>
    <input type="submit">  <%--提交表达方法--%>
</form:form>
</body>
</html>