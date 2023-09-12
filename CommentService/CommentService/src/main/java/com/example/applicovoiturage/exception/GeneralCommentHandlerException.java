package com.example.applicovoiturage.exception;

import com.example.applicovoiturage.model.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralCommentHandlerException {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Comment> AlreadyExistExceptionHandler(AlreadyExistException ex){
        Comment comment = new Comment();
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
