package org.example;


import lombok.RequiredArgsConstructor;
import org.example.Collection.Impl.StudentAge;
import org.example.Collection.Impl.StudentClass;
import org.example.Collection.Impl.StudentFamily;
import org.example.Service.Calculation;
import org.example.Service.Parser;

import java.util.Scanner;

@RequiredArgsConstructor
public class Main {
    public static void main(String[] args) {
        StudentAge studentAge = new StudentAge(15,20);

        StudentClass studentClass = new StudentClass(1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию ученика");
        String surname = sc.nextLine();
        StudentFamily studentFamily = new StudentFamily(surname);
        Calculation calculation = new Calculation(studentAge, studentClass, studentFamily);
        Parser parser = new Parser(calculation);
        parser.loadFile();
        calculation.print();
    }


}