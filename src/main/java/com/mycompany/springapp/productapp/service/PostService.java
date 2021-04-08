package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository pr;
    /*
    *Method Name: PostModel
    * Arguments:PostModel
    * Description:This method creates new posts of type PostModel in the table.
     */
    public PostModel createPosts(PostModel post)
    {
        PostModel newPost = pr.save(post);
        return newPost;
    }
}
