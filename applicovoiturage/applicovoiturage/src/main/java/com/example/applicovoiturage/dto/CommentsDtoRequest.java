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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_carRide() {
        return id_carRide;
    }

    public void setId_carRide(int id_carRide) {
        this.id_carRide = id_carRide;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
