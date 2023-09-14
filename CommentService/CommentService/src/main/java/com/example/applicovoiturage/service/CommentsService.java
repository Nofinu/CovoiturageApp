package com.example.applicovoiturage.service;

import com.example.applicovoiturage.dto.CommentsDtoRequest;
import com.example.applicovoiturage.dto.CommentsDtoResponse;
import com.example.applicovoiturage.exception.AlreadyExistException;

import java.util.Date;
import java.util.List;

public interface CommentsService {


    List<CommentsDtoResponse> getAllComment();


    CommentsDtoResponse createComment(CommentsDtoRequest commentsDtoRequest) throws AlreadyExistException;

    CommentsDtoResponse updateComment(String idComment,CommentsDtoRequest commentsDtoRequest);

    boolean deleteComment(String idComment);

    CommentsDtoResponse getCommentById(String idComment);

    CommentsDtoResponse getCommentByIdCarRideAndIdUser (int idCarRide, int idUser);
    List<CommentsDtoResponse> getCommentsByIdUser (int idUser);
}
