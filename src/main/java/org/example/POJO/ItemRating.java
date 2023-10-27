package org.example.POJO;


import lombok.Data;


@Data
public class ItemRating {
    private String itemId;
    private int rating;


    @Override
    public String toString() {
        return
                " предмет = " + itemId +
                        ", оценка = " + rating;
    }
}
