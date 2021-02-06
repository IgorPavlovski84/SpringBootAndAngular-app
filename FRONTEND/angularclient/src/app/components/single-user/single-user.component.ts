import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {ActivatedRoute} from "@angular/router";



@Component({
  selector: 'app-single-user',
  templateUrl: './single-user.component.html',
  styleUrls: ['./single-user.component.css']
})
export class SingleUserComponent implements OnInit {

  user!: User;

  broj!: number;

  constructor(private userService: UserService,
              private route: ActivatedRoute
  ) {

    this.user = new User();
    this.broj = Number(this.route.snapshot.params.id);
    this.userService.findUser(this.broj).subscribe(data => {
      this.user = data;
      // console.log(this.user);
    });
  }

  ngOnInit() {
  }

}

