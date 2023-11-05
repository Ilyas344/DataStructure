package org.example.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.DTO.StudentAverageScore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/*"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            var mapper = new ObjectMapper();

            String classId = req.getParameter("group_number");
            List<StudentAverageScore> averageScores = getAverageScores(classId);

        try (var output = resp.getWriter()) {
            resp.setContentType("application/json");
            output.write(mapper.writeValueAsString(averageScores));
            output.flush();
        }
        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Получаем параметры запроса
            String classId = req.getParameter("classId");
            String studentFio = req.getParameter("studentFio");
            String subjectId = req.getParameter("subjectId");
            int score = Integer.parseInt(req.getParameter("score"));

            // Обновляем оценку ученика
            updateStudentScore(classId, studentFio, subjectId, score);

            // Отправляем ответ
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    private List<StudentAverageScore> getAverageScores(String classId) {
        // TODO: Заменить на реальную реализацию
        return Arrays.asList(
                new StudentAverageScore("Иванов Иван Иванович", 4.5),
                new StudentAverageScore("Петров Петр Петрович", 5.0),
                new StudentAverageScore("Сидоров Сидор Сидорович", 3.5)
        );
    }

    private void updateStudentScore(String classId, String studentFio, String subjectId, int score) {
        // TODO: Заменить на реальную реализацию
        // ...
    }
}
