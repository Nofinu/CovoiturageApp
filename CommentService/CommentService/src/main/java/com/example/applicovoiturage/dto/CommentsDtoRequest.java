package com.example.applicovoiturage.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentsDtoRequest {
    private int idUser;
    private int idCarRide;
    private int idDriver;
    private float note;
    private String comment;
    private String date;

}
