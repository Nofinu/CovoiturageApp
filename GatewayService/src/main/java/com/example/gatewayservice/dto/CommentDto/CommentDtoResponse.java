package com.example.gatewayservice.dto.CommentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDtoResponse {
    private int id_comment;
    private int id_user;
    private int id_carRide;
    private  float note;
    private String comment;
    private LocalDate date;
}
