package org.example.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AA {
    private String name;

    public AA(String name) {
        this.name = name;
    }
}
