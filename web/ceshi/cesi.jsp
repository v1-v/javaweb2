<%@ page import="java.util.List" %>
<%@ page import="home.ExamQuestion" %>
<%@ page import="home.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test Database Output</title>
</head>
<body>

<%
    ExamQuestion examQuestion = new ExamQuestion();
    List<Question> questions = examQuestion.getQuestions();

    for (Question question : questions) {
%>
<p>ID: <%= question.getId() %></p>
<p>Question: <%= question.getQuestionText() %></p>
<p>Option A: <%= question.getOptionA() %></p>
<p>Option B: <%= question.getOptionB() %></p>
<p>Option C: <%= question.getOptionC() %></p>
<p>Correct Answer: <%= question.getCorrectAnswer() %></p>
<hr>
<%
    }
%>

</body>
</html>