//package com.example.rest.springapp.post;
//
//import com.example.rest.springapp.user.User;
//import com.example.rest.springapp.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class PostDemoData implements ApplicationRunner {
//
//    @Autowired
//    private final PostRepository repo;
//
//    public PostDemoData (PostRepository repo) {
//        this.repo = repo;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        String[] postsTitles = {"Post title 1", "Post title 2", "Post title 3", "Post title 4"};
//        String[] postsBodies = {"Post body 1", "Post body 2", "Post body 3", "Post body 4"};
//        for (int i = 0; i<4; i++) {
//            Post newPost = new Post(i+1, postsTitles[i], postsBodies[i], new User(i, "user"+ Integer.toString(i+1), new Date()));
//            repo.save(newPost);
//        }
//    }
//
//}