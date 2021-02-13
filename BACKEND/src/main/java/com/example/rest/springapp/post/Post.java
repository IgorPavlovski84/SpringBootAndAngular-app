package com.example.rest.springapp.post;

import com.example.rest.springapp.user.User;

import javax.persistence.*;
//@Entity
//public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @NotNull
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "library_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Library library;

@Entity
//@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name="title")
    private String title;
//    @Column(name="body")
    private String body;


//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id")
//    private User user;

    protected Post() {
    }

    public Post(String title, String body) {
        super();
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int postId) {
        this.id = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

