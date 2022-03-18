package dev.projectlion.demo.week2.answer.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicMissionMain {
    public static void main(String[] args) {

        Person student = new Student("나다",27);
        Person lecturer = new Lecturer("선생",28);

        student.speak();
        lecturer.speak();

        System.out.println("\n선생과 학생 in List\n");
        List<Person> everyone = new ArrayList<>();
        everyone.add(student);
        everyone.add(lecturer);

        for (Person person : everyone){
            person.speak();
        }

    }
}
