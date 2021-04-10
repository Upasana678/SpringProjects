package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.TagModel;
import com.mycompany.springapp.productapp.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tr;

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(TagService.class);

    public TagModel createNewTags(TagModel tag)
    {
        TagModel newTag = tr.save(tag);
        return newTag;
    }

    public Iterable<TagModel> getAllTags()
    {
        Iterable<TagModel> tagList = tr.findAll();
        return tagList;
    }

    public TagModel updateTag(Long id,TagModel tag)
    {
        Optional<TagModel> optTag = tr.findById(id);
        TagModel tagUpdate = null;
        if(optTag.isPresent())
        {
            tagUpdate = optTag.get();
            if(tag.getName()!=null)
            {
                tagUpdate.setName(tag.getName());
            }
            if(tag.getPosts()!=null)
            {
                tagUpdate.setPosts(tag.getPosts());
            }
        }
        else
        {
            LOGGER.error("This post does not exist");
        }
        return tagUpdate;
    }

    public TagModel deleteTag(Long id)
    {
        Optional<TagModel> tagDeleted = tr.findById(id);
        TagModel tag = null;
        if(tagDeleted.isPresent())
        {
           tag = tagDeleted.get();
           tr.delete(tag);
        }
        else
        {
            LOGGER.error("This tag does not exist");
        }
        return tag;
    }
}
