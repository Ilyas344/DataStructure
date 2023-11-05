package org.example.POJO;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ItemRating {
    private int id;
    private String itemId;
    private int rating;


    @Override
    public String toString() {
        return
                " предмет = " + itemId +
                        ", оценка = " + rating;
    }
}
