package com.mh.green2nd.custom.customMenu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.custom.Custom;
import com.mh.green2nd.menu.Menu;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "custommenu")
public class CustomMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custommenu_id", nullable = false)
    private Long customMenuId;

    @ManyToOne
    @JoinColumn(name = "custom_id")
    private Custom custom;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @JsonIgnore
    @Column(columnDefinition = "integer default 1")
    private int quantity;

    private String myname;

    @Max(2)
    @Min(0)
    private int size;

    @Max(2)
    @Min(0)
    private int ice;

    @Max(3)
    @Min(0)
    private int shot;

    @Max(3)
    @Min(0)
    private int cream;

}
