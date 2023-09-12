package com.example.gatewayservice.dto.CommentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDtoResponse {
    private String idComment;
    private int idUser;
    private int idCarRide;
    private int idDriver;
    private  float note;
    private String comment;
    private LocalDate date;
}
