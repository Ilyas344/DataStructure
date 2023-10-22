package org.example.Service;

import org.example.POJO.ItemRating;
import org.example.POJO.Student;

public class Mapper {
    public Student mapper(String[] strings, String[] item) {
        String family = strings[0];
        String name = strings[1];
        int age = Integer.parseInt(strings[2]);
        int group = Integer.parseInt(strings[3]);
        ItemRating[] itemRating = new ItemRating[6];
        for (int i = 0; i < itemRating.length; i++) {
            itemRating[i] = new ItemRating();
            itemRating[i].setItemId(item[i + 4]);
            itemRating[i].setRating(Integer.parseInt(strings[i + 4]));
        }
        return new Student(family, name, age, group, itemRating);
    }
}
