package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamQuestion {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false";

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String sql = "SELECT * FROM exam_questions";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setId(resultSet.getInt("id"));
                    question.setQuestionText(resultSet.getString("question_text"));
                    question.setOptionA(resultSet.getString("option_a"));
                    question.setOptionB(resultSet.getString("option_b"));
                    question.setOptionC(resultSet.getString("option_c"));
                    question.setCorrectAnswer(resultSet.getString("correct_answer"));
                    questions.add(question);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
