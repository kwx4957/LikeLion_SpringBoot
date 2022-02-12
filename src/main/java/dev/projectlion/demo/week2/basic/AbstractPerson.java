package dev.projectlion.demo.week2.basic;

public abstract class AbstractPerson implements Person {
    String name;
    int age;
    String position;

    @Override
    public void speak() {
        System.out.println("내 이름은 "+ name +" "+ position + "이죠");
    }


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

}
