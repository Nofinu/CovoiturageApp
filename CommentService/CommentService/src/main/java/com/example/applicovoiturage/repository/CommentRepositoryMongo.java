package com.example.applicovoiturage.repository;

import com.example.applicovoiturage.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepositoryMongo  extends MongoRepository<Comment,String> {

    Comment findCommentByIdCarRideAndIdUser(int idCarRide , int idUser);
}
