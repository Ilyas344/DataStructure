package org.example.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class StudentAverageScoreByFamily {
    private String family;
    private String name;
    private int group;
    private double averageScore;
}
