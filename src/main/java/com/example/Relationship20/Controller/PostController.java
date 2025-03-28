package com.example.Relationship20.Controller;

import com.example.Relationship20.Model.PostModel;
import com.example.Relationship20.Service.ServiceImpl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post/v1")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("post")
    public ResponseEntity<String> post(@RequestBody PostModel postModel){
        String response = postService.createPostInDb(postModel);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
