package org.example.StudentService;

import org.example.Command.AgeGroupCommand;
import org.example.Command.ClassGroupCommand;
import org.example.Command.Command;
import org.example.Command.FamilyGroupCommand;

public class CommandBuilder {

    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public Command build(String commandType) {
        switch (commandType) {
            case "age":
                return new AgeGroupCommand(studentService);
            case "family":
                return new FamilyGroupCommand(studentService);
            case "group":
                return new ClassGroupCommand(studentService);
            default:
                throw new IllegalArgumentException("Неизвестный тип команды: " + commandType);
        }
    }
}

