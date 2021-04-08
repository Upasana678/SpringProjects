package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.TagModel;
import com.mycompany.springapp.productapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    private TagService ts;

    @PostMapping("/tags/newTag")
    public ResponseEntity<TagModel> createNewTags(@RequestBody TagModel tag)
    {
        TagModel newTag = ts.createNewTags(tag);
        ResponseEntity<TagModel> response = new ResponseEntity<>(newTag, HttpStatus.CREATED);
        return response;
    }
}
