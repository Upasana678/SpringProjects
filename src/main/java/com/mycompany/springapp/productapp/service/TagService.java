package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.TagModel;
import com.mycompany.springapp.productapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository tr;

    public TagModel createNewTags(TagModel tag)
    {
        TagModel newTag = tr.save(tag);
        return newTag;
    }
}
