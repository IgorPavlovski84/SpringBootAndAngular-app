import {Component, OnDestroy, OnInit} from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit, OnDestroy {

  users!: User[];

  private sub: any;

  constructor(private userService: UserService,
              private activatedRoute: ActivatedRoute) {
  }


    onDelete(id: number) {
 //     this.users = this.users.filter(u => u !== user);
      console.log('something...');
      this.userService.deleteUser(id).subscribe(data => {
      console.log("deleted User");
        this.ngOnInit();
      });
    }


    ngOnInit() {
      this.userService.findAll().subscribe(data => {
        this.users = data;
     });

      // this.sub = this.activatedRoute.paramMap.subscribe(params => {
      //   // @ts-ignore
      //   this.comUserId = params['id'];
      // });
    }

  ngOnDestroy() {
    this.sub = this.activatedRoute.paramMap.subscribe(params => {
      // @ts-ignore
      this.comUserId = params['id'];
    });
    this.sub.unsubscribe();
  }
}

