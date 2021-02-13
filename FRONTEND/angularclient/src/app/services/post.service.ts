import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from '../models/post';
import { Observable } from 'rxjs/Observable';
import { User } from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postsUrl: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
    this.postsUrl = 'http://localhost:8080/posts';
  }

  public postPost(user: User) {
    return this.http.post<User>(this.postsUrl, user);
  }
}
// Post post = postRepository.getOne(postId);
// user.setPost(post);
//
// userRepository.save(user);
