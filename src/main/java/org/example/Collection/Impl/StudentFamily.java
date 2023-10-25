package org.example.Collection.Impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.Collection.StudentNameDataGroup;
import org.example.POJO.Student;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class StudentFamily implements StudentNameDataGroup {
    private char firstLetterOfFamily;
    private String family;
    private Student[] students;

    public StudentFamily(char firstLetterOfFamily) {
        this.firstLetterOfFamily = firstLetterOfFamily;
        students = new Student[0];
    }

    public StudentFamily(String family) {
        this.firstLetterOfFamily = family.charAt(0);
        this.students = new Student[0];
    }

    public StudentFamily(Student[] students) {
        this.firstLetterOfFamily = students[0].getFamily().charAt(0);
        this.students = students;
    }

    @Override
    public void addStudent(Student student) {
        if (student.getFamily().charAt(0) == firstLetterOfFamily) {
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
            if (student.getFamily().charAt(0) == firstLetterOfFamily) {
                if ((student.getFamily()).equalsIgnoreCase(family)) {
                    Student[] newStudents = new Student[students.length + 1];
                    System.arraycopy(students, 0, newStudents, 0, students.length);
                    newStudents[students.length] = student;
                    students = newStudents;
                }
            }
        }
        return students;
    }

    @Override
    public String toString() {
        return firstLetterOfFamily +
                " ->  " + (Arrays.toString(students));
    }
}
