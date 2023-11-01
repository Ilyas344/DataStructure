package org.example.DAO;

import org.example.DTO.StudentDTO;
import org.example.POJO.ItemRating;
import org.example.POJO.Student;

import java.util.List;

public interface StudentDAO {

    void addStudent (StudentDTO student);
    double getAverageRating (int group);
    List<StudentDTO> getTopStudents (int age);
    List<StudentDTO> getAverageScore (String family);


}
