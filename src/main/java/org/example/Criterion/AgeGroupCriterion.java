package org.example.Criterion;

import org.example.POJO.Student;

public class AgeGroupCriterion implements GroupCriterion<Student> {

    @Override
    public String apply(Student student) {
        return String.valueOf(student.getAge());
    }
}