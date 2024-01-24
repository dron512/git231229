package org.example;


import lombok.AllArgsConstructor;
import lombok.ToString;

public class CompFriend extends Friend{
    private String department;

    public CompFriend(String name, String department,
                      String phone) {
        super(name,phone);
        this.department = department;
    }

    @Override
    public String toString() {
        return "CompFriend{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
