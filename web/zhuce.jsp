
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>注册</title>
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
<!-- 注册页面 -->
<div class="register-container">
  <form action="/register" class="register-form" id="registerForm">
    <h2 class="mb-4">注册</h2>

    <div class="mb-3">
      <label for="regUsername" class="form-label">身份</label>
      <select class="form-control" name="role">
        <option value="student">学生</option>
        <option value="teacher">老师</option>
      </select><br>
    </div>

    <div class="mb-3">
      <label for="regUsername" class="form-label">用户名</label>
      <input type="text" class="form-control" id="regUsername" name="username"
             required placeholder="请输入用户名">
    </div>
    <div class="mb-3">
      <label for="regPassword" class="form-label">密码</label>
      <input type="password" class="form-control" id="regPassword" name="password"
             required minlength="6" placeholder="请输入至少6位密码">
    </div>
    <div class="mb-3">
      <label for="confirmPassword" class="form-label">确认密码</label>
      <input type="password" class="form-control" id="confirmPassword" name="password"
             required minlength="6" placeholder="请确认密码">
    </div>
    <div id="passwordMatchMessage" class="text-danger"></div>
    <!-- 注册按钮和返回按钮 -->
    <div class="d-flex justify-content-between align-items-center mt-3">
      <button type="submit" class="btn btn-success">注册</button>
      <a href="denglu.jsp" class="btn btn-primary">返回</a>
    </div>
  </form>
</div>

<script>
  // 获取密码和确认密码输入框
  var passwordInput = document.getElementById('regPassword');
  var confirmPasswordInput = document.getElementById('confirmPassword');
  var passwordMatchMessage = document.getElementById('passwordMatchMessage');
  // 监听表单提交事件
  document.getElementById('registerForm').addEventListener('submit', function (event) {
    var password = passwordInput.value;
    var confirmPassword = confirmPasswordInput.value;
    // 检查密码和确认密码是否相同
    if (password !== confirmPassword) {
      alert('密码和确认密码不匹配！');
      event.preventDefault(); // 阻止表单提交
    }
  });
</script>
</body>
</html>