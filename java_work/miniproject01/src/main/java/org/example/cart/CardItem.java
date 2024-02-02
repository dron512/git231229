package org.example.cart;

import lombok.Data;

@Data
public class CardItem {
    private long cart_item_id;
    private String reg_time;
    private String update_time;
    private String created_by;
    private String modified_by;
    private int count;
    private long cart_id;
    private long item_id;
}
