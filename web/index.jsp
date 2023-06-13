<%--
  Created by IntelliJ IDEA.
  User: 14537
  Date: 2023/5/19
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

<%--  form表单里有两个重要的属性
        action: 表单提交的地址
        method: 表单提交的方式
 --%>
  <form action="login.action" method="post">
    用户名:<input type="text" name="userName"/><br/>
    密码:<input type="password" name="password"/><br/>
    <input type="submit" value="提交"/>
  </form>
  <a href="saveUserDetail.html">填写用户详细信息</a>
  </body>
</html>
