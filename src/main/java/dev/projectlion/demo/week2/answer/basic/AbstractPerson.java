package dev.projectlion.demo.week2.answer.basic;

import lombok.Getter;

@Getter
public abstract class AbstractPerson implements Person {
    private String name;
    private int age;

    public AbstractPerson() {
    }

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println(String.format("제이름은 %s", this.name));
    }
}
