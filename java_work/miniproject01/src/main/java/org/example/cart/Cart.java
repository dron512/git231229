package org.example.cart;

import lombok.Data;

// cart 테이블
@Data
public class Cart {
    private long cart_id;
    private String reg_time;
    private String update_time;
    private String created_by;
    private String modified_by;
    private long member_id;
}
