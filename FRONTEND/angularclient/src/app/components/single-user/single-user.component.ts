import {Component, Input, OnInit, ViewChild, ElementRef} from '@angular/core';
import { User } from "../../models/user";
import {UserService} from "../../services/user.service";
import {PostService} from "../../services/post.service";
import {ActivatedRoute} from "@angular/router";
import { Post } from "../../models/post";

import { HttpEventType, HttpErrorResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { UploadService } from  '../../upload.service';

@Component({
  selector: 'app-single-user',
  templateUrl: './single-user.component.html',
  styleUrls: ['./single-user.component.css']
})


export class SingleUserComponent implements OnInit {

  @ViewChild("fileUpload", {static: false}) fileUpload: ElementRef | undefined;
  files  = [];
  user!: User;
  newPostFlag: boolean = false;
  showPostsFlag: boolean = false;
  buttonLabel: string = "Click here to create a new post";
  posts = [
    {"id": 1,
    "title": "Post Title 1",
    "body": "Post Body 1",
    "user_id": 1},
    {"id": 2,
    "title": "Post Title 2",
    "body": "Post Body 2",
    "user_id": 1},
    {"id": 3,
    "title": "Post Title 3",
    "body": "Post Body 3",
    "user_id": 2}
  ]
  postModel!: Post;



  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private uploadService: UploadService,
              private postService: PostService
  ) {
    this.user = new User();
    let broj = Number(this.route.snapshot.params.id);
    this.userService.findUser(broj).subscribe(data => {
      this.user = data;
    });
    this.postModel = new Post();
    this.postModel.title = '';
    this.postModel.body = '';
    this.postModel.user_id = 1;
  }

  ngOnInit() {
  }

  newPost() {
    if (this.buttonLabel == "Click here to create a new post") {
      this.buttonLabel = "Click here to hide add new post form";
    } else {
      this.buttonLabel = "Click here to create a new post";
    }
    this.newPostFlag = !this.newPostFlag;
  }

  showPosts() {
    this.showPostsFlag = !this.showPostsFlag;
  }

  uploadFile(file: any) {
    const formData = new FormData();
    formData.append('file', file.data);
    file.inProgress = true;
    // @ts-ignore
    this.uploadService.upload(formData).pipe(
      map(event => {
        switch (event.type) {
          case HttpEventType.UploadProgress:
            file.progress = Math.round(event.loaded * 100 / event.total!);
            return null;
          case HttpEventType.Response:
            return event;
        }
        return null;
      }),
      catchError((error: HttpErrorResponse) => {
        file.inProgress = false;
        return of(`${file.data.name} upload failed.`);
      })).subscribe((event: any) => {
      if (typeof (event) === 'object') {
        console.log(event.body);
      }
    });
  }

  private uploadFiles() {
    // @ts-ignore
    this.fileUpload.nativeElement.value = '';
    this.files.forEach(file => {
      this.uploadFile(file);
    });
  }

  onSubmit() {
    this.postService.postPost(this.postModel)
      .subscribe(
        data => console.log('Success!', data),
        error => console.log('Error!', error)
      );
    console.log('PostModel data is: ');
    console.log(this.postModel);
  }


}

