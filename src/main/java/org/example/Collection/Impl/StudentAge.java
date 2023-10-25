package org.example.Collection.Impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.Collection.StudentAgeDataGroups;
import org.example.POJO.Student;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class StudentAge implements StudentAgeDataGroups {
    private int age;
    private int ageFrom;
    private int ageTo;
    private Student[] students;

    public StudentAge(int age) {
        this.age = age;
        students = new Student[0];
    }

    public StudentAge(int ageFrom, int ageTo) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        students = new Student[0];
    }

    public StudentAge(Student[] students) {
        this.age = students[0].getAge();
        this.students = students;
    }

    @Override
    public void addStudent(Student student) {
        if (isAge(ageFrom,ageTo,student.getAge())) {
            Student[] newStudents = new Student[students.length + 1];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            newStudents[students.length] = student;
            students = newStudents;
        }
    }

    @Override
    public Student[] getStudents() {
        Student[] students = new Student[0];
        for (Student student : this.students) {
            if (isAge(ageFrom,ageTo,student.getAge())) {
                Student[] newStudents = new Student[students.length + 1];
                System.arraycopy(students, 0, newStudents, 0, students.length);
                newStudents[students.length] = student;
                students = newStudents;
            }
        }

        return students;
    }
    private boolean isAge(int ageFrom, int ageTo, int age) {
        return age >= ageFrom && age <= ageTo;
    }

    @Override
    public String toString() {
        return age +
                " ->" + Arrays.toString(students);
    }
}
