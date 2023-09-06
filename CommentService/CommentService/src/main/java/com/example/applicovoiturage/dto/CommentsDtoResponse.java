package com.example.applicovoiturage.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentsDtoResponse {
    private int id_comment;
    private int id_user;
    private int id_carRide;
    private  float note;
    private String comment;
    private String date;


}
