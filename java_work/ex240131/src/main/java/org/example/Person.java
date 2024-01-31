package org.example;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Destroyed "+ name);

    }
}
