package org.example.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.POJO.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataLoader implements DataLoader {


    private final Mapper mapper = new Mapper();

    public FileDataLoader() {
    }

    @Override
    public List<Student> load() {
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/students.csv"))) {
            String[] nextLine;
            String[] item = new String[10];
            while ((nextLine = reader.readNext()) != null) {
                if (reader.getLinesRead() == 1) {
                    item = nextLine;
                    item = separator(item[0]);
                    continue;
                }
                nextLine = separator(nextLine[0]);
                students.add(mapper.mapper(nextLine, item));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    private String[] separator(String string) {
        return string.split(";");
    }
}