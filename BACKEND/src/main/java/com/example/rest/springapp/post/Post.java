package com.example.rest.springapp.post;

import com.example.rest.springapp.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
//    private Integer userId;
    private Set<Integer> userId;

    protected Post() {
    }

    public Post(Integer id, String title, String body, Set<Integer> userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Integer> getUserId() {
        return userId;
    }

    public void setUserId(Set<Integer> userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                '}';
    }
}

