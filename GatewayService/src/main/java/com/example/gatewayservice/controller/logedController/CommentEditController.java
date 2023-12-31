package com.example.gatewayservice.controller.logedController;

import com.example.gatewayservice.dto.CommentDto.CommentDtoRequest;
import com.example.gatewayservice.dto.CommentDto.CommentDtoResponse;
import com.example.gatewayservice.exception.AlreadyExistException;
import com.example.gatewayservice.tools.RestClient;
import com.example.gatewayservice.utils.PortApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/comment")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class CommentEditController {

    private ObjectMapper om;

    public CommentEditController() {
        this.om = new ObjectMapper();
    }
    @PostMapping("/create")
    public ResponseEntity<CommentDtoResponse> createComment (@RequestBody CommentDtoRequest commentDtoRequest) throws JsonProcessingException, AlreadyExistException {
        RestClient<CommentDtoResponse> commentDtoResponseRestClient = new RestClient<>("http://localhost:"+ PortApi.portComm +"/api/comment/create");
        CommentDtoResponse commentDtoResponse = commentDtoResponseRestClient.postRequest(om.writeValueAsString(commentDtoRequest), CommentDtoResponse.class);
        if(commentDtoResponse.getIdComment() == null){
            throw new AlreadyExistException("Comment");
        }
        return new ResponseEntity<>(commentDtoResponse, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CommentDtoResponse> updateComment (@RequestBody CommentDtoRequest commentDtoRequest,@PathVariable int id) throws JsonProcessingException {
        RestClient<CommentDtoResponse> commentDtoResponseRestClient = new RestClient<>("http://localhost:"+ PortApi.portComm +"/api/comment/update/"+id);
        CommentDtoResponse commentDtoResponse = commentDtoResponseRestClient.postRequest(om.writeValueAsString(commentDtoRequest), CommentDtoResponse.class);
        return new ResponseEntity<>(commentDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment (@PathVariable int id) throws JsonProcessingException {
        RestClient<String> commentDtoResponseRestClient = new RestClient<>("http://localhost:"+ PortApi.portComm +"/api/comment/delete/"+id);
        String stringResponse = commentDtoResponseRestClient.getRequest( String.class);
        return new ResponseEntity<>(stringResponse, HttpStatus.OK);
    }

    @GetMapping("/usercomment/{iduser}")
    public ResponseEntity<List<CommentDtoResponse>> getAllCommentByIdUser (@PathVariable int iduser){
        RestClient<CommentDtoResponse[]> commentRestCLient = new RestClient<>("http://localhost:"+ PortApi.portComm +"/api/comment/usercomment/"+iduser);
        List<CommentDtoResponse> commentDtoResponses = Arrays.stream(commentRestCLient.getRequest(CommentDtoResponse[].class)).toList();
        return new ResponseEntity<>(commentDtoResponses, HttpStatus.OK);
    }
}
