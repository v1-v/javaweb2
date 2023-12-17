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
    //计算总分
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取问题列表
        ExamQuestion examQuestion = new ExamQuestion();
        List<Question> questions = examQuestion.getQuestions();

        // 计算得分
        int totalQuestions = questions.size();//题目数量
        int correctAnswers = 0;//题目正确数量
        for (Question question : questions) {
            String answer = request.getParameter("answer"+ question.getId());
            //答案不为空且答案与数据库中的正确答案一致则加一分
            if (answer!=null&&answer.equals(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }


        float score = ((float) correctAnswers / totalQuestions) * 100;

        String username = (String) request.getSession().getAttribute("username");
        // 保存分数到数据库
        saveScoreToDatabase(username,score);
        // 提交后回到登录界面
        response.sendRedirect("/denglu.jsp");

    }

    private void saveScoreToDatabase(String username,float score) {
        try {

            try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sa3;user=v2;password=123456;encrypt=false")) {
                // 插入到数据库找到该username的得分记录
                String query = "INSERT INTO user_scores (user_id, score) VALUES (?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setDouble(2, score);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();//输出错误信息
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理 POST 请求（如果需要）
    }
}