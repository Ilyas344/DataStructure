package org.example.FileServuce;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.POJO.ItemRating;
import org.example.POJO.Student;

import java.io.FileReader;
import java.io.IOException;

public class Parser {

    public Student loadFile() {
        Student student = null;
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
                String[] data = separator(nextLine[0]);
                String family = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int group = Integer.parseInt(data[3]);
                ItemRating[] itemRating = new ItemRating[6];
                for (int i = 0; i < itemRating.length; i++) {
                    itemRating[i] = new ItemRating();
                    itemRating[i].setItemId(item[i + 4]);
                    itemRating[i].setRating(Integer.parseInt(data[i + 4]));
                }
               student = new Student(family, name, age, group, itemRating);
                System.out.println(student);

            }
            reader.close();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return student;
    }


    private String[] separator(String string) {
        return string.split(";");
    }


}
