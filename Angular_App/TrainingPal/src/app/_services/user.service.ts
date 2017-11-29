import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { User } from '../_models/index';

/*
    Created with the help of: http://jasonwatmore.com/post/2016/09/29/angular-2-user-registration-and-login-example-tutorial
 */

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    create(user: User) {
      return this.http.post('http://trainingpal.me/t2zbsEefUB/User/CreateUser.php', JSON.stringify(user))
        .map((response: Response) => {
          // create successful if there's a 200 response
          let resp = response.json();

          // Check response ok
          if (resp.code == 200) {
            // Check the user was created
            if(resp.data != "User Created") {
              throw new Error(resp.data);
            }
          }
          else{
            throw new Error(resp.data);
          }
        });
    }

    update(user: User) {
      return this.http.post('http://trainingpal.me/t2zbsEefUB/User/UpdateUser.php', JSON.stringify(user))
        .map((response: Response) => {
          // update successful if there's a 200 response
          let resp = response.json();

          // Check response ok
          if (resp.code == 200) {
            // Check the user was created
            if(resp.data != "User Updated") {
              throw new Error(resp.data);
            }
          }
          else{
            throw new Error(resp.data);
          }
        });
    }

    setUser(Id: string) {
      return this.http.post('http://trainingpal.me/t2zbsEefUB/User/GetUser.php', JSON.stringify({"id" : Id}))
        .map((response: Response) => {
          // login successful if there's a 200 response
          let resp = response.json();

          console.log(resp);
          // Check user exists
          if (resp.code == 200) {
            localStorage.setItem('currentUserProfile', JSON.stringify(resp.data.users[0]));
          }
          else{
            throw new Error('User Not Found!');
          }
        });
    }
}
