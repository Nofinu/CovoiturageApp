package com.example.applicovoiturage.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("comment")
public class Comment {

    @Id
    private String id_comment;
    private int id_user;
    private int id_carRide;
    private float note;
    private String comment;
    private LocalDate date;

}
