package org.example;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
class Person implements Comparable<Person> {
    public String name;
    public int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
//    @Override
//    public int compareTo(Object o) {
//        return this.age - ((Person)o).age;
//    }
//    @Override
//    public int compare(Object o1, Object o2) {
//        return o1.age - o2.age;
//    }
}
class Comp implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o2.age - o1.age;
    }
}
public class Main4 {
    public static void main(String[] args) {
        Set<Person> ts = new TreeSet<>(new Comp());
        ts.add(new Person("홍길동",100));
        ts.add(new Person("김길동",20));
        ts.add(new Person("이길동",30));
        System.out.println(ts);
    }
}
