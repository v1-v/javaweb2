
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>注册页面</title>
</head>
<body>

<h2>注册</h2>

<form action="/register">
  用户名：<input type="text" name="username" required><br>
  密码：<input type="password" name="password" required><br>
  身份：
  <select name="role">
    <option value="student">学生</option>
    <option value="teacher">老师</option>
  </select><br>
  <input type="submit" value="注册">
</form>

</body>
</html>
