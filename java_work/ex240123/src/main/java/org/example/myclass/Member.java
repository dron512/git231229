package org.example.myclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Member {

    private String name;
    private int age;


//    @Override
//    public String toString() {
//        return "Member{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
