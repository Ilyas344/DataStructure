package org.example.Calculation;

import org.example.POJO.Student;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CalculatingByFamily {

    Map<String, List<Student>> students;

    public CalculatingByFamily(Map<String, List<Student>> students) {
        this.students = students;
    }

    public void byFamily() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию студента:");
        String family = scanner.nextLine();
        List<Student> ListStudents = students.get(String.valueOf(family.charAt(0)));
        for (Student student : ListStudents) {
            if (student.getFamily().equals(family)) {
                System.out.println(student);
            }
        }
    }
}
