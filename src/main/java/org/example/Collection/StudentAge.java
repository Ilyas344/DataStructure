package org.example.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.POJO.Student;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class StudentAge {
    private int age;
    private Student[] students;

    public StudentAge(int age) {
        this.age = age;
        students = new Student[0];
    }

    public StudentAge() {
    }

    public StudentAge(Student[] students) {
        this.age = students[0].getAge();
        this.students = students;
    }

    public void addStudent(Student student) {
        if (student.getAge() == age) {
            Student[] newStudents = new Student[students.length + 1];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            newStudents[students.length] = student;
            students = newStudents;
        }
    }

    public Student[] getStudents(int age) {
        Student[] students = new Student[0];
        for (Student student : this.students) {
            if (student.getAge() == age) {
                Student[] newStudents = new Student[students.length + 1];
                System.arraycopy(students, 0, newStudents, 0, students.length);
                newStudents[students.length] = student;
                students = newStudents;
            }
        }

        return students;
    }

    @Override
    public String toString() {
        return age +
                " ->" + Arrays.toString(students);
    }
}
