
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>上传题目</title>
</head>
<body>

<h2>上传题目</h2>

<form action="uploadQuestion">
    问题：<input type="text" name="questionText" required><br>
    选项A：<input type="text" name="optionA" required><br>
    选项B：<input type="text" name="optionB" required><br>
    选项C：<input type="text" name="optionC" required><br>
    正确答案：<input type="text" name="correctAnswer" required><br>
    <input type="submit" value="上传题目">
</form>

</body>
</html>