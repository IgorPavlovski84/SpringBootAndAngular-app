package com.example.rest.springapp.post;

import com.example.rest.springapp.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll()
                .forEach(posts::add);
        return posts;
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Optional<Post> getPost(Integer id) {
        return postRepository.findById(id);
    }

    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }

}