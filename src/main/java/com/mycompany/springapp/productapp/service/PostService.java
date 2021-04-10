package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository pr;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);
    /*
    *Method Name: createPosts
    * Arguments:PostModel
    * Description:This method creates new posts of type PostModel in the table.
     */
    public PostModel createPosts(PostModel post)
    {
        PostModel newPost = pr.save(post);
        return newPost;
    }
    /*Method name:getPosts()
     *Arguments:None
     * Description:This method retrieves all posts created from the database
     */

    public Iterable<PostModel> getPosts()
    {
        Iterable<PostModel> postsList = pr.findAll();
        return postsList;
    }

    /*
    *Method name : updatePost()
    * Arguments: PostModel post
    * Description: This method updates the post
     */
    public PostModel updatePost(Long id,PostModel post)
    {
        PostModel post1 = null;
        Optional<PostModel> optPost = pr.findById(id);
        if(optPost.isPresent())
        {
            post1 = optPost.get();
            if(post.getTitle()!=null)
            {
                post1.setTitle(post.getTitle());
            }
            if(post.getDescription()!=null)
            {
                post1.setDescription(post.getDescription());
            }
            if(post.getPostedAt()!=null)
            {
                post1.setPostedAt(post.getPostedAt());
            }
            if(post.getTags()!=null)
            {
                post1.setTags(post.getTags());
            }
        }
        else
        {
            LOGGER.error("This post does not exist");
        }
        return post1;
    }
    /*Method name: deletePost
    * Arguments:PostModel post
    * Description
     */

    public PostModel deletePost(Long id)
    {
        Optional<PostModel> optPost = pr.findById(id);
        PostModel post2 = null;
        if(optPost.isPresent())
        {
            PostModel post1 = optPost.get();
            post2 = post1;
            pr.delete(post1);
        }
        else
        {
            LOGGER.error("This post does not exist.Delete some other post");
        }
        return post2;
    }
}
