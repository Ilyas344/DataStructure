package org.example.Command;

import org.example.Criterion.AgeGroupCriterion;
import org.example.POJO.Student;
import org.example.StudentService.DataGroup;
import org.example.StudentService.StudentService;

import java.util.List;
import java.util.Map;

public class AgeGroupCommand implements Command {

    private final StudentService studentService;

    public AgeGroupCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Map<String, List<Student>> execute() {
        List<Student> students = studentService.getAllStudents();
        DataGroup<Student> byAge = new DataGroup<>(students, new AgeGroupCriterion());

        return byAge.group();
    }

}
