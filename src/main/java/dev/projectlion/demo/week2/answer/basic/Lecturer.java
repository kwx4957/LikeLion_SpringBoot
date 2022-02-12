package dev.projectlion.demo.week2.answer.basic;

public class Lecturer extends AbstractPerson {

    public Lecturer(String name,int age) {
        super(name,age);
    }

    @Override
    public void speak() {
        System.out.println(String.format("제 이름은 %s 선생이죠", getName()));
    }

}
