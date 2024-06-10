package com.three.alcoholshoppingmall.project.user;

public enum Gender {
    MALE,FEMALE;

    public static Gender fromString(String gender) {
        for (Gender role : Gender.values()){
            if (role.toString().equalsIgnoreCase(gender)){
                return role;
            }
        }
        return null;
    }
}
