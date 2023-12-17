
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>

<h2>登录</h2>

<form action="/login">
    用户名：<input type="text" name="username" required><br>
    密码：<input type="password" name="password" required><br>
    身份：
    <select name="role">
        <option value="student">学生</option>
        <option value="teacher">老师</option>
    </select><br>
    <input type="submit" value="登录">
    <p>还没有账号？<a href="register.jsp">注册</a></p>
</form>

</body>
</html>
