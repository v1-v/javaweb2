package home;

import home.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false");
        // 在实际应用中，进行用户注册和存储逻辑
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);

            preparedStatement.executeUpdate();
        }

        // 注册成功后，你可能希望将用户重定向到登录页面
        response.sendRedirect("/denglu.jsp");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("/zhuce.jsp");
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
