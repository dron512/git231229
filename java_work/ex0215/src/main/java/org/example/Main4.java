package org.example;

import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        // DB 에서.. 사람들...
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("김길동", 20);
        Person p3 = new Person("이길동", 30);
        Person p4 = new Person("박길동", 34);

        List<Person> list = Arrays.asList(p1, p2, p3, p4);

        list.stream()
                .filter(person -> person.getAge() == 20)
                .forEach(System.out::println);

        System.out.println();
        for (Person person : list) {
            if (person.getAge() == 20)
                System.out.println(person);
        }

    }
}
