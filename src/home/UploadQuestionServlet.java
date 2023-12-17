package home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "uploadQuestion", urlPatterns = "/uploadQuestion")
public class UploadQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionText = request.getParameter("questionText");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String correctAnswer = request.getParameter("correctAnswer");

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false");

            String query = "INSERT INTO exam_questions (question_text, option_a, option_b, option_c, correct_answer) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, questionText);
                preparedStatement.setString(2, optionA);
                preparedStatement.setString(3, optionB);
                preparedStatement.setString(4, optionC);
                preparedStatement.setString(5, correctAnswer);

                preparedStatement.executeUpdate();
            }

            response.sendRedirect("teacher_dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("teacher_dashboard.jsp");
        }
    }
}