package com.example.rest.springapp.post;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//
//@Repository
//public interface PostRepository extends CrudRepository<Post, Integer> {}





@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
//    Page<Comment> findByPostId(Long postId, Pageable pageable);
    Optional<Post> findByIdAndUserId(Integer id, Integer postId);
}