package com.example.rest.springapp.user;

import com.example.rest.springapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserControler {

    @Autowired
    private UserDaoService service;


    @GetMapping("/")
    public User retrieveNoneUsers() {
        return new User(0, "Default", new Date());
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) service.getAllUsers();
    }

//    @GetMapping("/users/{id}")
//    public Optional<User> retrieveUser(@PathVariable Integer id){
//        Optional<User> user = service.getUser(id);
//        return user;
//    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void addTopic(@RequestBody User user) {
        service.addUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable Integer id){
       service.deleteUser(id);
        return new User();
    }
}
