package com.example.applicovoiturage.repository;

import com.example.applicovoiturage.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepositoryMongo  extends MongoRepository<Comment,String> {

    Comment findCommentByIdCarRideAndIdUser(int idCarRide , int idUser);

    List<Comment> findCommentByIdUser(int idUser);
}
