import {Component, Input, OnInit, ViewChild, ElementRef} from '@angular/core';
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {ActivatedRoute} from "@angular/router";

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

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private uploadService: UploadService
  ) {
    this.user = new User();
    let broj = Number(this.route.snapshot.params.id);
    this.userService.findUser(broj).subscribe(data => {
      this.user = data;
    });
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
            break;
          case HttpEventType.Response:
            return event;
        }
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

  onClick() {
    // @ts-ignore
    const fileUpload = this.fileUpload.nativeElement;

    fileUpload.onchange = () => {
      for (let index = 0; index < fileUpload.files.length; index++)
      {
        const file = fileUpload.files[index];
        // @ts-ignore
        this.files.push({ data: file, inProgress: false, progress: 0});
      }
      this.uploadFiles();
    };
    fileUpload.click();
  }

}

