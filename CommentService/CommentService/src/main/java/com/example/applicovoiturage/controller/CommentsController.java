package com.example.applicovoiturage.controller;


import com.example.applicovoiturage.dto.CommentsDtoRequest;
import com.example.applicovoiturage.dto.CommentsDtoResponse;
import com.example.applicovoiturage.exception.AlreadyExistException;
import com.example.applicovoiturage.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/create")
    public ResponseEntity<CommentsDtoResponse> createComment(@RequestBody CommentsDtoRequest commentsDtoRequest) throws AlreadyExistException {
        return new ResponseEntity<>(commentsService.createComment(commentsDtoRequest), HttpStatus.CREATED);
    }
    @PostMapping("/update/{id_comment}")
    public ResponseEntity<CommentsDtoResponse> updateComment(@PathVariable(value = "id_comment")String id_comment,
                                                            @RequestBody CommentsDtoRequest commentsDtoRequest){
        return new ResponseEntity<>(commentsService.updateComment(id_comment,commentsDtoRequest),HttpStatus.OK);

    }
    @GetMapping("/delete/{id_comment}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "id_comment")String id_comment){
       if(commentsService.deleteComment(id_comment)){
           return new ResponseEntity<>("Comment delete ",HttpStatus.OK);
       }
       return new ResponseEntity<>("Error durring deletion",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id_comment}")
    public ResponseEntity<CommentsDtoResponse> getCommentById(@PathVariable(value = "id_comment")String id_comment){
        return new ResponseEntity<>(commentsService.getCommentById(id_comment),HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<CommentsDtoResponse>> getAllPComment(){
        return new ResponseEntity<>(commentsService.getAllComment(), HttpStatus.OK);
    }

    @GetMapping("/usercomment/{iduser}")
    public ResponseEntity<List<CommentsDtoResponse>> getAllCommentByUserId (@PathVariable int iduser){
        return new ResponseEntity<>(commentsService.getCommentsByIdUser(iduser),HttpStatus.OK);
    }

    }
