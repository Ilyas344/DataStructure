package org.example.Command;

import org.example.POJO.Student;

import java.util.List;
import java.util.Map;

public interface Command {

    Map<String, List<Student>> execute();
}