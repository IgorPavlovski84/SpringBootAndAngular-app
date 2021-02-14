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
  post!: Observable<Post>;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
    this.postsUrl = 'http://localhost:8080/posts';
  }

  public postPost(user: User) {
    return this.http.post<User>(this.postsUrl, user);
  }

  public getPost(id: number) {
    this.post = this.http.get<Post>(this.postsUrl + "/" + id)
    console.log(this.post);
    return this.post;
  }
}
// Post post = postRepository.getOne(postId);
// user.setPost(post);
//
// userRepository.save(user);
