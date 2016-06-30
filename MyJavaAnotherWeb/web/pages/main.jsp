<%--
  Created by IntelliJ IDEA.
  User: fangc
  Date: 2016/5/7
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%--在默认情况下该jsp是使用session的，为了在controller中利用session跳转，
所以我们不能在这个jsp页面里自动创建session，应设为false。
应该在jsp之前--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
Main Page
</body>
</html>
