package dev.projectlion.demo.week2.basic;

public class Student extends AbstractPerson {

    public Student() {
    }

    public Student(String name) {
        super.name = name;
        super.position = "Student";
    }


}
