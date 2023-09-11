package com.example.gatewayservice.controller;

import com.example.gatewayservice.dto.CommentDto.CommentDtoResponse;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/comment")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CommentController {

    @GetMapping("")
    public ResponseEntity<List<CommentDtoResponse>> getAllComment (){
        RestClient<CommentDtoResponse[]> commentRestCLient = new RestClient<>("http://localhost:"+ PortApi.portComm +"/api/comment");
        List<CommentDtoResponse> commentDtoResponses = Arrays.stream(commentRestCLient.getRequest(CommentDtoResponse[].class)).toList();
        return new ResponseEntity<>(commentDtoResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentDtoResponse> getCommentById (@PathVariable String id){
        RestClient<CommentDtoResponse> commentRestCLient = new RestClient<>("http://localhost:"+ PortApi.portComm +"/api/comment/"+id);
        CommentDtoResponse commentDtoResponse = commentRestCLient.getRequest(CommentDtoResponse.class);
        return new ResponseEntity<>(commentDtoResponse, HttpStatus.OK);
    }
}
