package org.example.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentAllExcellent {
    private String family;
    private String name;
    private int age;
    private double totalScore;
}
