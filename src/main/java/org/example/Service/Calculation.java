package org.example.Service;

import org.example.Collection.StudentAge;
import org.example.Collection.StudentClass;
import org.example.Collection.StudentFamily;
import org.example.POJO.ItemRating;
import org.example.POJO.Student;

import java.util.Arrays;
import java.util.Scanner;


public class Calculation {
    private final StudentAge studentAge;
    private final StudentClass studentClass;
    private final StudentFamily studentFamily;

    public Calculation(StudentAge studentAge, StudentClass studentClass, StudentFamily studentFamily) {
        this.studentAge = studentAge;
        this.studentClass = studentClass;
        this.studentFamily = studentFamily;
    }


    public void getStudent(Student student) {
        studentAge.addStudent(student);
        studentClass.addStudent(student);
        studentFamily.addStudent(student);

    }

    public void print() {
        System.out.println("Вычисление средней оценки в старших классах (10 и 11)");
        printAverage(10);
        printAverage(11);
        System.out.println("Поиск всех отличников, старше 14 лет");
        for (int i = 15; i < 20; i++) {
            printBest(i);
        }
        System.out.println("Поиск ученика по фамили (фамилия ученика задается через консоль)");
        printStudent();
    }

    //1) Вычисление средней оценки в старших классах (10 и 11)
    private void printAverage(int group) {
        Student[] students = studentClass.getStudents(group);
        double average = 0;
        for (Student student : students) {
            ItemRating[] itemRatings = student.getItemRatings();
            for (ItemRating itemRating : itemRatings) {
                average += itemRating.getRating();
            }
        }
        average /= students.length;
        System.out.println(group + " -> " + average);
    }

    //2) Поиск всех отличников, старше 14 лет
    public void printBest(int age) {
        Student[] students = studentAge.getStudents(age);
        for (Student student : students) {
            if (student.getTotalScore() > 29) {
                System.out.println(student);

            }
        }
    }

    //3) Поиск ученика по фамили (фамилия ученика задается через консоль)
    public void printStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию ученика");
        String surname = sc.nextLine();
        Student[] students = studentFamily.getStudents(surname);
        System.out.println(Arrays.toString(students) + "\n");

    }
}
