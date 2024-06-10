package com.mh.green2nd.menu.AdminMenu;

import lombok.Data;

@Data
public class AdminMenuGetDto {

        private Long id;
        private String name;
        private int price;
        private String explain;
        private boolean status;
        private String menu_imgurl;
        private String category;
}
