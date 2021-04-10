package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.TagModel;
import com.mycompany.springapp.productapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tags/AllTags")
    public ResponseEntity<Iterable<TagModel>> getAllTags()
    {
        Iterable<TagModel> tagList = ts.getAllTags();
        ResponseEntity<Iterable<TagModel>> response = new ResponseEntity<>(tagList,HttpStatus.OK);
        return response;
    }

    @PutMapping(path = "/tags/updateTag/{id}")
    public ResponseEntity<TagModel> updateTag(@PathVariable("id") Long id,@RequestBody TagModel tag)
    {
        TagModel tag1 = ts.updateTag(id,tag);
        ResponseEntity<TagModel> response = new ResponseEntity<>(tag1,HttpStatus.OK);
        return response;
    }

    @DeleteMapping(path = "tags/deleteTag/{id}")
    public ResponseEntity<TagModel> deleteTag(@PathVariable("id") Long id)
    {
        TagModel tag1 = ts.deleteTag(id);
        ResponseEntity<TagModel> response = new ResponseEntity<>(tag1,HttpStatus.NO_CONTENT);
        return response;
    }
}
