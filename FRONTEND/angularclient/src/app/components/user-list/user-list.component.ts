import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users!: User[];

  constructor(private userService: UserService) {
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

  }
}

