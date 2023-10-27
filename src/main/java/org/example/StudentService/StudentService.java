package org.example.StudentService;

import org.example.POJO.Student;
import org.example.Service.DataLoader;

import java.util.List;

public class StudentService {

    private final DataLoader dataLoader;

    public StudentService(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    public List<Student> getAllStudents() {
        return dataLoader.load();
    }
}
