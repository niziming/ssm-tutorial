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
    <br>
    <a href="/account/find">查询用户</a>
    <br>
    <a href="saveAccount">保存账户，get 请求</a>
    <br/>
    <form action="saveAccount" method="post">
        <input type="submit" value="保存账户，post 请求">
    </form>
    <a href="/removeAccount?accountName=aaa">删除</a>
    <a href="/removeAccount?accountName=aaa&money>100">100删除</a>
    <a href="/removeAccount?accountName=aaa&money>150">150删除</a>
    <a href="/findAccount?accountId=10&accountName=ziming">findAccount</a>
    <br>
    <!-- pojo 类型演示 -->
    <form action="account/saveAccount" method="post">
        账户名称：<input type="text" name="id" ><br/>
        账户名称：<input type="text" name="username" ><br/>
        账户名称：<input type="text" name="password" ><br/>
        账户金额：<input type="text" name="money" ><br/>
<%--        账户省份：<input type="text" name="address.provinceName" ><br/>--%>
<%--        账户城市：<input type="text" name="address.cityName" ><br/>--%>
        <input type="submit" value="保存">
    </form>

    <a href="/deleteAccount?date=2018-01-01">/deleteAccount</a>
    <br>
<%--    我们可以把上述对象，直接写在控制的方法参数中使用。--%>
<%--    部分示例代码：--%>
<%--    jsp 代码：--%>
    <!-- 原始 ServletAPI 作为控制器参数 -->
    <a href="/testServletAPI">测试访问 ServletAPI</a>

    <br>
<%--    jsp 中的代码：--%>
    <!-- requestParams 注解的使用 -->
    <a href="/useRequestParam?name=test">requestParam 注解</a>
    <br>
<%--    post 请求 jsp 代码：--%>
    <!-- request body 注解 -->
    <form action="/useRequestBody" method="post">
        用户名称：<input type="text" name="username" ><br/>
        用户密码：<input type="password" name="password" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>
<%--    get 请求 jsp 代码：--%>
    <a href="/useRequestBody?body=test">requestBody 注解 get 请求</a>
    <br>
    <!-- PathVariable 注解 -->
    <a href="/usePathVariable/100">pathVariable 注解</a>
    <!-- RequestHeader 注解 -->
    <a href="/useRequestHeader">获取请求消息头</a>
    <!-- CookieValue 注解 -->
    <a href="/useCookieValue">绑定 cookie 的值</a>
    <!-- ModelAttribute 注解的基本使用 -->
    <a href="/testModelAttribute?uname=test">测试 modelattribute</a>
</body>
</html>
