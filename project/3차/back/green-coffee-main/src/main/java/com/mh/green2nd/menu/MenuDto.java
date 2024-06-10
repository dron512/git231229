package com.mh.green2nd.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {

    private String category;

    private String name;

    private String menu_ename;

    private String menu_explain;

    private String menu_imgurl;
    private String menu_bannerimgurl;

    private double menu_price;

}
