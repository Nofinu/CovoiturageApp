package com.example.applicovoiturage.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentsDtoResponse {
    private String id_comment;
    private int id_user;
    private int id_carRide;
    private  float note;
    private String comment;
    private LocalDate date;


}
