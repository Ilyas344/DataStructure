package org.example.Service;

import org.example.POJO.ItemRating;
import org.example.POJO.Student;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public Student mapper(String[] strings, String[] item) {
        String family = strings[0];
        String name = strings[1];
        int age = Integer.parseInt(strings[2]);
        int group = Integer.parseInt(strings[3]);
        List<ItemRating> list = new ArrayList<>();
        ItemRatingDTO[] itemRating = new ItemRatingDTO[6];
        List<ItemRatingDTO> list2 = new ArrayList<>();
        for (int i = 0; i < itemRating.length; i++) {
          //  itemRating[i] = new ItemRating();
            itemRating[i] = new ItemRatingDTO();
            itemRating[i].setItemId(item[i + 4]);
            itemRating[i].setRating(Integer.parseInt(strings[i + 4]));
            list2.add(itemRating[i]);
        }

        return new Student(family, name, age, group, list);
    }
}
