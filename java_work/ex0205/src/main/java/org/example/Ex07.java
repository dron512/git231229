package org.example;


class User{
    enum Gender{
        MALE,FEMALE
    }
    private String name;
    private Gender gen;
    public User(String name, Gender gen) {
        this.name = name;
        this.gen = gen;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gen=" + gen +
                '}';
    }
}
public class Ex07 {
    public static void main(String[] args) {
        User 홍길동 = new User("홍길동", User.Gender.MALE);
        User 박미자 = new User("박미자", User.Gender.FEMALE);
//        User 김미자 = new User("박미자", User.Gender.ASDF);
        System.out.println(홍길동);
        System.out.println(박미자);
    }
}
