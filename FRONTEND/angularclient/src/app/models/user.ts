import {Post} from "./post";

export class User {
    id!: number;
    name!: string;
    birthDate!: Date;
    posts: any[] = [];

    addPost(post: Post){
      this.posts.push(post);
    }

}
