package com.example.rest.springapp.user;

import com.example.rest.springapp.post.Post;

import javax.persistence.*;
import java.util.*;
//@Entity
//public class Library {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @NotNull
//    private String name;
//
//    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
//    private Set<Book> books = new HashSet<>();


@Entity
//@Table(name="user")
public class User {


    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

//    @Column(name="name")
    private String name;

//    @Column(name="birthDate")
    private Date birthDate;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name="user_id", referencedColumnName = "id")
    private List<Post> posts = new ArrayList<>();

//    user.getPosts().add(post)

    protected User() {
    }

    public User(String name, Date birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setPost(Post post) {
        this.getPosts().add(post);
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
