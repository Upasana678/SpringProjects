package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    //Create an object of PostService class
    @Autowired
    private PostService ps;

    @PostMapping("/posts/createNewPost")
    public ResponseEntity<PostModel> createPosts(@RequestBody PostModel post)
    {
        PostModel newPost = ps.createPosts(post);
        ResponseEntity<PostModel> response = new ResponseEntity<>(newPost, HttpStatus.CREATED);
        return response;
    }
}
