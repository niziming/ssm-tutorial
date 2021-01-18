<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>入门程序</h3>
    <%--
        <a href="hello">入门程序</a>
    --%>
    <a href="${pageContext.request.contextPath}/hello">RequestMapping注解hello接口</a>
    <br>
    <a href="${pageContext.request.contextPath}/user/hello">RequestMapping/user/hello注解</a>
    <br>
    <h2>${pageContext.request.contextPath}</h2>
</form>
</body>
</html>
