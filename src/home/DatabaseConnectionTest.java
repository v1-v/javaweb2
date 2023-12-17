package home;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        // 建立数据库连接
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false")) {
            System.out.println("Database connection successful!");

            // 调用获取题目的方法
            retrieveQuestions(connection);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }

    // 从数据库中检索题目的方法
    private static void retrieveQuestions(Connection connection) {
        try {
            String sql = "SELECT * FROM exam_questions";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String questionText = resultSet.getString("question_text");
                    String optionA = resultSet.getString("option_a");
                    String optionB = resultSet.getString("option_b");
                    String optionC = resultSet.getString("option_c");
                    String correctAnswer = resultSet.getString("correct_answer");

                    // 输出题目信息
                    System.out.println("Question: " + questionText);
                    System.out.println("Option A: " + optionA);
                    System.out.println("Option B: " + optionB);
                    System.out.println("Option C: " + optionC);
                    System.out.println("Correct Answer: " + correctAnswer);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String query = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {


                System.out.println("已注册用户信息:");

                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");

                    System.out.println("Username: " + username + ", Password: " + password + ", Role: " + role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
