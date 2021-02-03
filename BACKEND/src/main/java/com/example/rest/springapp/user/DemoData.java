package com.example.rest.springapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DemoData implements ApplicationRunner {

    @Autowired
    private final UserRepository repo;

    public DemoData(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] users = {"Adam", "Eve", "Jack", "Joe"};
        Integer counter = 1;
        //List<User> createdUsers = new ArrayList<>();
        for (String user:users) {
            User newUser = new User(counter, user, new Date());
            repo.save(newUser);
            counter++;
        }
    }

}