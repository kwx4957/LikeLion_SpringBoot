package dev.projectlion.demo.week3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SamplePayload {
    private String name;
    private int age;
    private String Occupation;

    public SamplePayload() {
    }

    public SamplePayload(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        Occupation = occupation;
    }

    @Override
    public String toString() {
        return "SamplePayload{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Occupation='" + Occupation + '\'' +
                '}';
    }

}
