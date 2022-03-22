package dev.projectlion.demo.week7;

import dev.projectlion.demo.week7.exceptions.BaseException;
import dev.projectlion.demo.week7.exceptions.ErrorResponseDto;
import dev.projectlion.demo.week7.exceptions.PostNotInBoard;
import dev.projectlion.demo.week7.exceptions.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable int id){
        switch (id){
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoard();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
//
//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponseDto handlerBaseException(
//            BaseException exception){
//        return new ErrorResponseDto(exception.getMessage());
//    }

}
