package dev.projectlion.demo.week2.basic;

public class BasicMain {
    public static void main(String[] args) {

        Person student = new Student("나다");
        Person lecturer = new Lecturer("선생");

        student.speak();
        lecturer.speak();
    }
}
