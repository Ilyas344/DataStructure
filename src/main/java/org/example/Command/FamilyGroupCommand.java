package org.example.Command;

import org.example.Criterion.FamilyGroupCriterion;
import org.example.POJO.Student;
import org.example.StudentService.DataGroup;
import org.example.StudentService.StudentService;

import java.util.List;
import java.util.Map;

public class FamilyGroupCommand implements Command {

    private final StudentService studentService;

    public FamilyGroupCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Map<String, List<Student>> execute() {
        List<Student> students = studentService.getAllStudents();
        DataGroup<Student> byLastName = new DataGroup<>(students, new FamilyGroupCriterion());
        return byLastName.group();
    }
}
