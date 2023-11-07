package org.example.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.DAO.StudentDAO;
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
    private final StudentDAO studentDAO;

    public StudentServlet(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var mapper = new ObjectMapper();
        int group = Integer.parseInt(req.getParameter("group_number"));
        List<StudentAverageScore> averageScores = studentDAO.getAverageScores(group);
        try (var output = resp.getWriter()) {
            resp.setContentType("application/json");
            output.write(mapper.writeValueAsString(averageScores));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int group = req.getIntHeader("group");
        String family = req.getParameter("family");
        String name = req.getParameter("name");
        String item = req.getParameter("item");
        int score = req.getIntHeader("score");

        studentDAO.updateStudentRating(family, name, group, item, score);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
