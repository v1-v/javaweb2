
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

<form action="/deleteQuestion">
    <%ExamQuestion examQuestion = new ExamQuestion();
        List<Question> questions = examQuestion.getQuestions();%>
    <label for="questionId">选择要删除的题目：</label>
    <select name="questionId" id="questionId" required>
        <%for (Question question : questions) { %>
        <option value="<%= question.getId() %>"><%= question.getQuestionText() %></option>
        <% } %>
    </select>
    <input type="submit" value="删除题目">
</form>

</body>
</html>