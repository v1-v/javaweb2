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

@WebServlet(name = "deleteQuestion", urlPatterns = "/deleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {
//删除题目
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = request.getParameter("questionId");

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false");

            String query = "DELETE FROM exam_questions WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, questionId);
                preparedStatement.executeUpdate();
            }

            response.sendRedirect("teacher_dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("teacher_dashboard.jsp");
        }
    }
}