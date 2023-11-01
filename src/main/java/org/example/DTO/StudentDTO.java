package org.example.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.POJO.ItemRating;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String family;
    private String name;
    private int age;
    private int group;
    private int totalScore;
    private List<ItemRatingDTO> item;

    public StudentDTO(String family, String name, int age, int group, List<ItemRatingDTO> items) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.group = group;
        this.item = items;
        for (ItemRatingDTO itemRating : items) {
            this.totalScore = this.totalScore + itemRating.getRating();
        }
    }
    @Override
    public String toString() {
        return "\nСтудент{" + family + " " + name + '\'' +
                ", " + age +
                " лет, группа " + group +
                ", общий балл " + totalScore +
                ", Рейтинг предметов " + item + "}";
    }
}
