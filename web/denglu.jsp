<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <link href="bootstrap.min.css" rel="stylesheet">
  <link href="ysb.css" rel="stylesheet">
  <script src="bootstrap.min.js"></script>
</head>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand">考试系统</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">首页</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<!-- 登录页面 -->
<div class="login-container">
  <form action="/login" class="login-form">
    <h2 class="mb-4">登录</h2>
    <div class="mb-3">
      <label for="username" class="form-label">身份</label>
      <select class="form-control" name="role">
        <option value="student">学生</option>
        <option value="teacher">老师</option>
      </select><br>
    </div>

    <div class="mb-3">
      <label for="username" class="form-label">用户名</label>
      <input type="text" class="form-control" id="username" name="username"
             required placeholder="请输入用户名">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">密码</label>
      <input type="password" class="form-control" id="password" name="password"
             required minlength="1" placeholder="请输入密码">
    </div>
    <div class="d-flex justify-content-between align-items-center mt-3">
      <button type="submit" class="btn btn-primary">登录</button>
      <a href="zhuce.jsp" class="btn btn-success ms-auto">注册</a>
    </div>
  </form>
</div>
</body>
</html>
