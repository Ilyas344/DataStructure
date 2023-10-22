package org.example.Collection;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.POJO.Student;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class StudentClass {
    private int group;
    private Student[] students;

    public StudentClass(int group) {
        this.group = group;
        students = new Student[0];
    }

    public StudentClass() {
    }

    public StudentClass(Student[] students) {
        this.group = students[0].getGroup();
        this.students = students;
    }

    public void addStudent(Student student) {
        if (student.getItemRatings().length != 0) {
            Student[] newStudents = new Student[students.length + 1];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            newStudents[students.length] = student;
            students = newStudents;
        }
    }

    public Student[] getStudents(int group) {
        Student[] students = new Student[0];
        for (Student student : this.students) {
            if (student.getGroup() == group) {
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
        return group +
                " ->  " + (Arrays.toString(students));
    }
}
