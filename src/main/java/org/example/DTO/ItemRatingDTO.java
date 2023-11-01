package org.example.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemRatingDTO {
    private int id;
    private String itemId;
    private int rating;

    public ItemRatingDTO(int id, String itemId, int rating) {
        this.id = id;

        this.itemId = itemId;
        this.rating = rating;
    }
}