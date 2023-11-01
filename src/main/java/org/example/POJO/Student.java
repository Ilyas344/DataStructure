package org.example.POJO;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Student {

    private String family;

    private String name;

    private int age;

    private int group;
    private int totalScore;
    private List<ItemRating> itemRatings;

    public Student(String family, String name, int age, int group, List<ItemRating> itemRatings) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.group = group;
        this.itemRatings = itemRatings;
        for (ItemRating itemRating : itemRatings) {
            this.totalScore = this.totalScore + itemRating.getRating();
        }
    }

    @Override
    public String toString() {
        return "Студент{" + family + " " + name + '\'' +
                ", " + age +
                " лет, группа " + group +
                ", общий балл " + totalScore +
                ", Рейтинг предметов " + itemRatings + "}";
    }
}
