package org.example.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.example.POJO.Student;

import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
public class Parser {
    private final Mapper mapper = new Mapper();
    private final Calculation calculation;

    public void loadFile() {
        Student student;
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/students.csv"));
            String[] nextLine;
            String[] item = new String[10];
            while ((nextLine = reader.readNext()) != null) {
                if (reader.getLinesRead() == 1) {
                    item = nextLine;
                    item = separator(item[0]);
                    continue;
                }
                nextLine = separator(nextLine[0]);
                student = mapper.mapper(nextLine, item);
                calculation.getStudent(student);

            }
            reader.close();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }


    private String[] separator(String string) {
        return string.split(";");
    }


}
