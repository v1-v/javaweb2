package home;
import home.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "submit", urlPatterns = "/submit")
public class SubmitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取问题列表
        ExamQuestion examQuestion = new ExamQuestion();
        List<Question> questions = examQuestion.getQuestions();

        // 计算得分
        int totalQuestions = questions.size();//题目数量
        int correctAnswers = 0;
        for (Question question : questions) {
            String answer = request.getParameter("answer"+ question.getId());

            if (answer!=null&&answer.equals(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }


        float score = ((float) correctAnswers / totalQuestions) * 100;

        // 获取用户名字（这里假设用户名字存储在会话中，实际中可能需要从登录信息中获取）
        String username = (String) request.getSession().getAttribute("username");
        // 保存得分到数据库
        saveScoreToDatabase(username,score);

        // 将得分设置为请求属性，以便在结果页面显示
        //request.setAttribute("score", score);
        response.sendRedirect("/denglu.jsp");

    }

    private void saveScoreToDatabase(String username,float score) {
        try {

            try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false")) {
                // 插入得分记录
                String query = "INSERT INTO user_scores (user_id, score) VALUES (?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setDouble(2, score);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理 POST 请求（如果需要）
    }
}