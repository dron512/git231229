package org.example;

// 나이 20살인것만.. 필터링 출력하고..
class Person {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

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
}
