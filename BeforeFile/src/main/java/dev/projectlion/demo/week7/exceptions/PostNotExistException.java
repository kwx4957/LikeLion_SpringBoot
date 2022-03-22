package dev.projectlion.demo.week7.exceptions;

public class PostNotExistException extends BaseException{
    public PostNotExistException() {
        super("post does no exist");
    }
}
