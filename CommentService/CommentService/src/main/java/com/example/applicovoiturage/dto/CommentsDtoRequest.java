package com.example.applicovoiturage.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentsDtoRequest {
    private int id_user;
    private int id_carRide;
    private  float note;
    private String comment;
    private String date;

}
