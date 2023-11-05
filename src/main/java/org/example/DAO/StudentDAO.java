package org.example.DAO;

import org.example.DTO.StudentAllExcellent;
import org.example.DTO.StudentAverageScore;
import org.example.DTO.StudentAverageScoreByFamily;
import org.example.POJO.Student;

import java.util.List;

public interface StudentDAO {

    void addStudent (Student student);
    double getAverageRating (int group);
    List<StudentAllExcellent> getTopStudents (int age);
    List<StudentAverageScoreByFamily> getAverageScore (String family);
    List<StudentAverageScore> getAverageScores(int group);
    int updateStudentRating(String family, String name, int group, String item, int newRating);


    }
