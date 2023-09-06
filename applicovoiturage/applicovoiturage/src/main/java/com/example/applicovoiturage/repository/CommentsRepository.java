package com.example.applicovoiturage.repository;


import com.example.applicovoiturage.entity.Comment;

import org.springframework.data.repository.CrudRepository;



public interface CommentsRepository extends CrudRepository<Comment,Integer> {

}
