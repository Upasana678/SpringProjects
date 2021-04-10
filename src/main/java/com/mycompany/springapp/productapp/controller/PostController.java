package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/posts/getPosts")
    public ResponseEntity<Iterable<PostModel>> getPosts()
    {
        Iterable<PostModel> listOfPosts = ps.getPosts();
        ResponseEntity<Iterable<PostModel>> response = new ResponseEntity<>(listOfPosts,HttpStatus.OK);
        return response;
    }

    @PutMapping("/posts/updatePost/{id}")
    public ResponseEntity<PostModel> updatePosts(@PathVariable("id") Long id,@RequestBody PostModel post)
    {
        PostModel post1 = ps.updatePost(id,post);
        ResponseEntity<PostModel> response = new ResponseEntity<>(post1,HttpStatus.OK);
        return response;
    }

    @DeleteMapping(path = "posts/deletePost/{id}")
    public ResponseEntity<PostModel> deletePost(@PathVariable("id") Long id)
    {
        PostModel post1 = ps.deletePost(id);
        ResponseEntity<PostModel> response = new ResponseEntity<>(post1,HttpStatus.NO_CONTENT);
        return response;
    }


}
