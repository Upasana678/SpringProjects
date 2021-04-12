package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.PostModel;
import com.mycompany.springapp.productapp.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PostTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    public void test_create_post()
    {
        PostModel post1 = new PostModel();
        post1.setId(1L);
        post1.setTitle("Bedsheets");
        post1.setDescription("Different Types of bedsheets");

        Mockito.when(postRepository.save(post1)).thenReturn(post1);

        PostModel post2 = postService.createPosts(post1);
        Assertions.assertNotNull(post2.getId(),"Test failed because new post should have an ID");
    }

    @Test
    public void test_getPosts_zero_size()
    {
        List<PostModel> noOfPosts = (List<PostModel>)postService.getPosts();
        Assertions.assertEquals(noOfPosts.size(),0);
    }

    @Test
    public void test_getPosts_non_zero_size()
    {
        PostModel post1 = new PostModel();
        post1.setId(1L);
        post1.setTitle("Furniture");
        post1.setDescription("Different Types of Furniture");

        List<PostModel> list = new ArrayList<>();
        Mockito.when(postRepository.findAll()).thenReturn(list);
        Assertions.assertEquals(list.size(),1);
    }

    @Test
    public void test_update_Post()
    {
        PostModel post1 = new PostModel();
        post1.setId(1L);
        post1.setTitle("Laptops");
        post1.setDescription("Different types of Laptops");
        Date date1 = new Date("12-1-19");
        post1.setPostedAt(date1);

        PostModel post2 = new PostModel();
        post2.setId(1L);
        post2.setTitle("Laptops");
        post2.setDescription("Different types of Laptops");
        Date date2 = new Date("19-7-20");
        post2.setPostedAt(date2);

        List<PostModel> noOfPosts = new ArrayList<>();
        noOfPosts.add(post2);

        Mockito.when(postRepository.findById(post1.getId())).thenReturn(Optional.of(post1));
        Mockito.when(postRepository.save(post2)).thenReturn(post2);

        PostModel post3 = postService.updatePost(post1.getId(),post2);
        Assertions.assertNotEquals(post3.getPostedAt(),post1.getPostedAt(),"This test failed because you have not updated the date");
    }






}
