package dev.projectlion.demo.week7.handler;

import dev.projectlion.demo.week7.exceptions.BaseException;
import dev.projectlion.demo.week7.exceptions.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class PostCtrollerAdvice {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handlerException(BaseException exception){
        return new ErrorResponseDto(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handlerValidException(
            MethodArgumentNotValidException exception){
        return new ErrorResponseDto(exception.getMessage());
    }

}
