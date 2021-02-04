package com.example.rest.springapp.post;

import com.example.rest.springapp.post.PostService;
import com.example.rest.springapp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostControler {

    @Autowired
    private PostService service;


    @GetMapping("/posts/0")
    public Post getPost() {
        return new Post(0, "Title", "Body of the post" , 1);
    }


    @GetMapping("/posts")
    public List<Post> getPosts() {
        return (List<Post>) service.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> retrievePost(@PathVariable Integer id){
        Optional<Post> post = service.getPost(id);
        return post;
    }

    @RequestMapping(method= RequestMethod.POST, value="/posts")
    public void addPost(@RequestBody Post post) {
        service.addPost(post);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/posts/{id}")
    public Post deletePost(@PathVariable Integer id){
        service.deletePost(id);
        return new Post();
      }
}
