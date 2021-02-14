import {Component, Input, OnInit, ViewChild, ElementRef} from '@angular/core';
import { User } from "../../models/user";
import {UserService} from "../../services/user.service";
import {PostService} from "../../services/post.service";
import {ActivatedRoute} from "@angular/router";
import { Post } from "../../models/post";

import { UploadService } from  '../../upload.service';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-single-user',
  templateUrl: './single-user.component.html',
  styleUrls: ['./single-user.component.css']
})


export class SingleUserComponent implements OnInit {

  @ViewChild('userForm', {static: false}) userForm!: NgForm;
  user!: User;
  newPostFlag: boolean = false;
  showPostsFlag: boolean = false;
  buttonLabel: string = "Click here to create a new post";
  postModel!: Post;

  modalFlag: boolean =  false;
  post!: Post;


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

  onSubmit() {
    this.user.posts.push(this.postModel);
    this.userService.save(this.user)
      .subscribe();
  }

  showPost(id: any) {
    this.post = new Post();
    console.log("in the showPost function ...")
    this.modalFlag = true;
    this.postService.getPost(id).subscribe(data => {
      this.post = data;
    });
  }

  resetForm() {
    this.userForm.resetForm();
  }


}

