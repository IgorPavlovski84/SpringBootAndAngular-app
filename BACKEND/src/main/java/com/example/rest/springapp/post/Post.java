package com.example.rest.springapp.post;

import com.example.rest.springapp.user.User;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {


    @Id
    @GeneratedValue
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="body")
    private String body;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private User user;

    protected Post() {
    }

    public Post(int postId, String title, String body) {
        this.id = postId;
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

