import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs/Observable';
import {Post} from "../models/post";

@Injectable()
export class UserService {

  private usersUrl: string;
  public post: Post;

    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
    this.post = new Post();
  }

  public findUser(id: number): Observable<User>{
    return  this.http.get<User>(this.usersUrl + "/" + id);

  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }

  public deleteUser(id: number): Observable<User>{
     return  this.http.delete<User>(this.usersUrl + "/" + id);

  }
}

