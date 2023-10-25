package org.example.Collection;

import org.example.POJO.Student;

public interface ClassroomDataGroups {
    void addStudent(Student student);
    Student[] getStudents(int classroom);
}
