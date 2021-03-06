package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.PostModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<PostModel,Long> {
    Optional<PostModel> findById(Long id);
}
