package com.example.gatewayservice.dto.CommentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDtoRequest {
    private int id_user;
    private int id_carRide;
    private  float note;
    private String comment;
    private String date;
}
