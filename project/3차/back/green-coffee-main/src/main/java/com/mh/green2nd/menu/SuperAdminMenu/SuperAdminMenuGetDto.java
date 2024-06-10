package com.mh.green2nd.menu.SuperAdminMenu;

import lombok.Data;

@Data
public class SuperAdminMenuGetDto {

            private Long id;
            private String name;
            private String ename;
            private int price;
            private String explain;
            private boolean status;
            private String menu_imgurl;
            private String category;
            private boolean recommend;
            private boolean visible;
}
