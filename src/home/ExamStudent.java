package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamStudent {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false";

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String sql = "SELECT * FROM user_scores";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setName(resultSet.getString("user_id"));
                    student.setScore(resultSet.getInt("score"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}