package home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false");

            String query = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, role);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // 用户验证成功
                        User user = new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setRole(resultSet.getString("role"));

                        // 在实际应用中，你可能会将用户信息存储在 session 中，以便后续使用
                        request.getSession().setAttribute("user", user);
                        request.getSession().setAttribute("username", username);

                        if ("teacher".equals(role)) {
                            response.sendRedirect("/teacher_dashboard.jsp");
                        } else if ("student".equals(role)) {
                            response.sendRedirect("/exam.jsp");
                        }
                    } else {
                        // 用户验证失败
                        response.sendRedirect("/denglu.jsp");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/denglu.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
