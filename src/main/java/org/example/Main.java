package org.example;


import lombok.RequiredArgsConstructor;
import org.example.Collection.Impl.StudentAge;
import org.example.Collection.Impl.StudentClass;
import org.example.Collection.Impl.StudentFamily;
import org.example.Service.Calculation;
import org.example.Service.Parser;

@RequiredArgsConstructor
public class Main {
    public static void main(String[] args) {
        StudentAge studentAge = new StudentAge(15,20);

        StudentClass studentClass = new StudentClass(1);
        StudentFamily studentFamily = new StudentFamily('Ш');
        Calculation calculation = new Calculation(studentAge, studentClass, studentFamily);
        Parser parser = new Parser(calculation);
        parser.loadFile();
        calculation.print();
    }


}