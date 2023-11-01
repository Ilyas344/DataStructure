package org.example;


import org.example.Calculation.CalculatingAverageScore;
import org.example.Calculation.CalculatingByFamily;
import org.example.Calculation.CalculationExcellentByAge;
import org.example.Command.Command;
import org.example.Service.FileDataLoader;
import org.example.StudentService.CommandBuilder;
import org.example.StudentService.StudentService;


public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(new FileDataLoader());
        CommandBuilder commandBuilder = new CommandBuilder(studentService);
        Command command1 = commandBuilder.build("age");
        command1.execute();
        Command command2 = commandBuilder.build("family");
        command2.execute();
        Command command3 = commandBuilder.build("group");
        command3.execute();
        CalculatingAverageScore calculating1 =
                new CalculatingAverageScore(command3.execute(), 10);
        CalculatingAverageScore calculating2 =
                new CalculatingAverageScore(command3.execute(), 11);
        CalculatingByFamily calculatingByFamily =
                new CalculatingByFamily(command2.execute());
        CalculationExcellentByAge calculationExcellentByAge =
                new CalculationExcellentByAge(command1.execute(), 14);
        System.out.println("Вычисление средней оценки в старших классах (10 и 11)");
        calculating1.averageScore();
      //  calculating2.averageScore();
        System.out.println("Поиск ученика по фамилии (фамилия ученика задается через консоль)");
      //  calculatingByFamily.byFamily();
        System.out.println("Поиск всех отличников, старше 14 лет");
     //   calculationExcellentByAge.ExcellentByAge();
    }


}