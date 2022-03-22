package dev.projectlion.demo.week7.exceptions;

public abstract class BaseException extends RuntimeException{
    public BaseException(String message) {
        super(message);
    }
}
