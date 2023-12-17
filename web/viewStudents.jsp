
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="home.Student" %>
<%@ page import="home.ExamStudent" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生列表</title>
</head>
<body>

<h2>学生列表</h2>

<table border="1">
    <tr>
        <th>学生姓名</th>
        <th>分数</th>
    </tr>
    <%
        ExamStudent examStudent = new ExamStudent();
        List<Student> students = examStudent.getStudents();
        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getName() %></td>
        <td><%= student.getScore() %></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
