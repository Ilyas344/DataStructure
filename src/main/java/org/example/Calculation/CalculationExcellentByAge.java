package org.example.Calculation;

import org.example.POJO.Student;

import java.util.List;
import java.util.Map;

public class CalculationExcellentByAge {
    Map<String, List<Student>> ageGroup;
    private int age;

    public CalculationExcellentByAge(Map<String, List<Student>> ageGroup, int age) {
        this.ageGroup = ageGroup;
        this.age = age;
    }

    public void ExcellentByAge() {
        while (ageGroup.containsKey(String.valueOf(age))) {

            List<Student> students = ageGroup.get(String.valueOf(age));
            System.out.println("Отличники старше " + age + " лет:");
            for (Student student : students) {
                if (student.getTotalScore() > 29) {
                    System.out.println(student);

                }
            }
            age++;
        }
    }

}
