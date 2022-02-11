package dev.projectlion.demo.week1;

import org.springframework.stereotype.Component;

@Component
public class TestImplementation implements TestInterface{
    @Override
    public void sayHello() {
        System.out.println("hello I am a new Spring Bean");
    }
}
