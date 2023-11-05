package org.example.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class StudentAverageScore {
    private String family;
    private String name;
    private double averageScore;
}
