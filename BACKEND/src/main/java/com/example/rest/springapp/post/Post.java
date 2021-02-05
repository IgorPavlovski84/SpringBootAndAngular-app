package com.example.rest.springapp.post;

import com.example.rest.springapp.user.User;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {


    @Id
    @GeneratedValue
    private int postId;
    @Column(name="title")
    private String title;
    @Column(name="body")
    private String body;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Post() {
    }

    public Post(int postId, String title, String body) {
        this.postId = postId;
        this.title = title;
        this.body = body;
        //this.userId = userId;
    }

    public int getId() {
        return postId;
    }

    public void setId(int postId) {
        this.postId = postId;
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

    public void setBody(String body) {
        this.body = body;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUser(int userId) {
//        this.userId = userId;
//    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + postId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                //", userId=" + userId +
                '}';
    }
}

