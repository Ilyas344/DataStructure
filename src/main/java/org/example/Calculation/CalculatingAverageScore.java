package org.example.Calculation;

import org.example.POJO.Student;

import java.util.List;
import java.util.Map;

public class CalculatingAverageScore {

    Map<String, List<Student>> studentsMap;
    private final int group;

    public CalculatingAverageScore(Map<String, List<Student>> studentsMap, int group) {
        this.studentsMap = studentsMap;
        this.group = group;
    }

    public void averageScore() {
        List<Student> students = studentsMap.get(String.valueOf(group));
        int count = 0;
        double sum = 0;
        for (Student student : students) {
            if (student.getGroup() == group) {
                count++;
                sum += student.getTotalScore();
            }
        }
        System.out.println(group + " -> " + sum / count);
    }
}

