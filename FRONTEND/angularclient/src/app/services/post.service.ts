import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from '../models/post';
import { Observable } from 'rxjs/Observable';

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

  public postPost(post: Post) {
    return this.http.post<Post>(this.postsUrl, post);
  }
}
