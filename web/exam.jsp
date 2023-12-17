
<%@ page import="java.util.List" %>
<%@ page import="home.ExamQuestion" %>
<%@ page import="home.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>在线考试</title>
</head>
<body>
<form action="/submit">
    <%
        ExamQuestion examQuestion = new ExamQuestion();
        List<Question> questions = examQuestion.getQuestions();
        for (Question question : questions) {
    %>
    <p><%= question.getId() %></p>
    <p><%= question.getQuestionText() %></p>
    <label>
        <input type="radio" name="answer<%= question.getId() %>" value="A"> <%= question.getOptionA() %>
    </label><br>
    <label>
        <input type="radio" name="answer<%= question.getId() %>" value="B"> <%= question.getOptionB() %>
    </label><br>
    <label>
        <input type="radio" name="answer<%= question.getId() %>" value="C"> <%= question.getOptionC() %>
    </label><br>
    <hr>
    <%
        }
    %>

    <input type="submit" value="提交">
</form>

</body>
</html>