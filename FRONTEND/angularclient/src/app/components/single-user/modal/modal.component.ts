import { Component, OnInit, Input } from '@angular/core';
import {Post} from "../../../models/post";
import {UserService} from "../../../services/user.service";
import {ActivatedRoute} from "@angular/router";
import {UploadService} from "../../../upload.service";
import {PostService} from "../../../services/post.service";

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  @Input() modalFlag: any;
  @Input() userInChild: any;
  @Input() postInChild: any;

  post!: Post;

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private uploadService: UploadService,
              private postService: PostService
  ) {
    this.postInChild = new Post();
    // this.postInChild.title = ' ';
    // this.postInChild.body = ' ';
  }

  ngOnInit(): void {
  }

  // getPost(id: number) {
  //   this.postService.getPost(id).subscribe(data => {
  //     this.post = data;
  //   });
  //
  // }

}
