package org.example.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class StudentAllExcellent {
    private String family;
    private String name;
    private int age;
    private double totalScore;
}
