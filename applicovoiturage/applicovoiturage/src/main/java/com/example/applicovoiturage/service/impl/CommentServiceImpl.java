package com.example.applicovoiturage.service.impl;

import com.example.applicovoiturage.dto.CommentsDtoRequest;
import com.example.applicovoiturage.dto.CommentsDtoResponse;
import com.example.applicovoiturage.entity.Comment;
import com.example.applicovoiturage.exception.NotFoundException;
import com.example.applicovoiturage.repository.CommentsRepository;
import com.example.applicovoiturage.service.CommentsService;
import com.example.applicovoiturage.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private Mapper mapper;


    @Override
    public List<CommentsDtoResponse> getAllComment() {
        List<Comment> comments = (List<Comment>) commentsRepository.findAll();
        List<CommentsDtoResponse> commentsDtoResponses = new ArrayList<>();
        for (Comment c: comments) {
            CommentsDtoResponse commentsDtoResponse = mapper.mapToDto(c);
            commentsDtoResponses.add(commentsDtoResponse);
        }
        return commentsDtoResponses;
    }

    @Override
    public CommentsDtoResponse getCommentById(int idComment) {
      Optional<Comment> comments = commentsRepository.findById(idComment);
      if(comments.isPresent()){
          return mapper.mapToDto(comments.get());
      }
        throw new NotFoundException();
    }




    @Override
    public CommentsDtoResponse createComment(CommentsDtoRequest commentsDtoRequest) {
      Comment comment = mapper.mapToEntity(commentsDtoRequest);
      Comment newComment = commentsRepository.save(comment);
      return mapper.mapToDto(newComment);
    }

    @Override
    public CommentsDtoResponse updateComment(int idComment, CommentsDtoRequest commentsDtoRequest) {
      Comment comment = getCommentByIdEntity(idComment);
      comment.setComment(commentsDtoRequest.getComment());
      comment.setDate(commentsDtoRequest.getDate());
      comment.setNote(commentsDtoRequest.getNote());
      comment.setId_carRide(commentsDtoRequest.getId_carRide());
      Comment updateComment = commentsRepository.save(comment);
       return mapper.mapToDto(updateComment);
      }

    private Comment getCommentByIdEntity(int idComment) {
        Optional<Comment> comments = commentsRepository.findById(idComment);
        if(comments.isPresent()){
            return comments.get();
        }
        throw new NotFoundException();
    }

    @Override
    public boolean deleteComment(int idComment) {
        try{
            Comment comment = getCommentByIdEntity(idComment);
            commentsRepository.delete(comment);
            return true;
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }


}
