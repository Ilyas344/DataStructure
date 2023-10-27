package org.example.Command;

import org.example.Criterion.ClassGroupCriterion;
import org.example.POJO.Student;
import org.example.StudentService.DataGroup;
import org.example.StudentService.StudentService;

import java.util.List;
import java.util.Map;

public class ClassGroupCommand implements Command {

    private final StudentService studentService;

    public ClassGroupCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Map<String, List<Student>> execute() {
        List<Student> students = studentService.getAllStudents();
        DataGroup<Student> byClass = new DataGroup<>(students, new ClassGroupCriterion());
        return byClass.group();
    }
}
