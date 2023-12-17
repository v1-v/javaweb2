
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="home.Question" %>
<%@ page import="home.ExamQuestion" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>删除题目</title>
</head>
<body>

<h2>删除题目</h2>
//删除可能出错的题目
<form action="/deleteQuestion">
    <%ExamQuestion examQuestion = new ExamQuestion();
        List<Question> questions = examQuestion.getQuestions();%>
    <label for="questionId">选择要删除的题目：</label>
    //把需要删除题目的id传给deleteQuestion，然后上传到数据库找到该id的题目并删除
    <select name="questionId" id="questionId" required>
        <%for (Question question : questions) { %>
        <option value="<%= question.getId() %>"><%= question.getQuestionText() %></option>
        <% } %>
    </select>
    <input type="submit" value="删除题目">
</form>

</body>
</html>