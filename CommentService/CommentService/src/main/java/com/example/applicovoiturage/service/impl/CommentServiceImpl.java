package com.example.applicovoiturage.service.impl;

import com.example.applicovoiturage.dto.CommentsDtoRequest;
import com.example.applicovoiturage.dto.CommentsDtoResponse;
import com.example.applicovoiturage.exception.AlreadyExistException;
import com.example.applicovoiturage.model.Comment;
import com.example.applicovoiturage.exception.NotFoundException;
import com.example.applicovoiturage.repository.CommentRepositoryMongo;
import com.example.applicovoiturage.service.CommentsService;
import com.example.applicovoiturage.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CommentServiceImpl implements CommentsService {


    @Autowired
    private CommentRepositoryMongo commentRepositoryMongo;

    @Autowired
    private Mapper mapper;


    @Override
    public CommentsDtoResponse createComment(CommentsDtoRequest commentsDtoRequest) throws AlreadyExistException {
        if(getCommentByIdCarRideAndIdUser(commentsDtoRequest.getIdCarRide(),commentsDtoRequest.getIdUser()) == null){
            Comment comment = mapper.mapToEntity(commentsDtoRequest);
            comment.setDate(LocalDate.parse(commentsDtoRequest.getDate()));
            Comment newComment = commentRepositoryMongo.save(comment);
            return mapper.mapToDto(newComment);
        }
        throw new AlreadyExistException();
    }

    @Override
    public CommentsDtoResponse updateComment(String idComment, CommentsDtoRequest commentsDtoRequest) {
        Comment comment = getCommentByIdEntity(idComment);
        comment.setComment(commentsDtoRequest.getComment());
        comment.setDate(LocalDate.parse(commentsDtoRequest.getDate()));
        comment.setNote(commentsDtoRequest.getNote());
        Comment updateComment = commentRepositoryMongo.save(comment);
        return mapper.mapToDto(updateComment);
    }

    @Override
    public boolean deleteComment(String idComment) {
        try{
            Comment comment = getCommentByIdEntity(idComment);
            commentRepositoryMongo.delete(comment);
            return true;
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }

    @Override
    public List<CommentsDtoResponse> getAllComment() {
        List<Comment> comments = (List<Comment>) commentRepositoryMongo.findAll();
        List<CommentsDtoResponse> commentsDtoResponses = new ArrayList<>();
        for (Comment c: comments) {
            CommentsDtoResponse commentsDtoResponse = mapper.mapToDto(c);
            commentsDtoResponses.add(commentsDtoResponse);
        }
        return commentsDtoResponses;
    }

    @Override
    public CommentsDtoResponse getCommentById(String idComment) {
      Optional<Comment> comments = commentRepositoryMongo.findById(idComment);
      if(comments.isPresent()){
          return mapper.mapToDto(comments.get());
      }
        throw new NotFoundException();
    }

    @Override
    public CommentsDtoResponse getCommentByIdCarRideAndIdUser(int idCarRide, int idUser) {
        Comment commentFind = commentRepositoryMongo.findCommentByIdCarRideAndIdUser(idCarRide,idUser);
        if(commentFind != null){
            return mapper.mapToDto(commentFind);
        }
        return null;
    }

    @Override
    public List<CommentsDtoResponse> getCommentsByIdUser(int idUser) {
        List<CommentsDtoResponse> commentsDtoResponses = new ArrayList<>();
        commentRepositoryMongo.findCommentByIdUser(idUser).forEach(c ->{
            commentsDtoResponses.add(new CommentsDtoResponse(c.getIdComment(),c.getIdUser(),c.getIdCarRide(),c.getIdDriver(),c.getNote(),c.getComment(),c.getDate()));
        });
        return commentsDtoResponses;
    }

    private Comment getCommentByIdEntity(String idComment) {
        Optional<Comment> comments = commentRepositoryMongo.findById(idComment);
        if(comments.isPresent()){
            return comments.get();
        }
        throw new NotFoundException();
    }




}
