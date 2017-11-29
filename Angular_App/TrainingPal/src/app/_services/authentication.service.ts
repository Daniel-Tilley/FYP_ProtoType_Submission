import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

/*
    Created with the help of: http://jasonwatmore.com/post/2016/09/29/angular-2-user-registration-and-login-example-tutorial
 */

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username: string, password: string) {

        return this.http.post('http://trainingpal.me/t2zbsEefUB/User/GetUser.php', JSON.stringify({ id: username}))
            .map((response: Response) => {
                // login successful if there's a 200 response
                let resp = response.json();

                // Check user exists
                if (resp.code == 200) {
                    // Check the password is right
                    if(resp.data.users[0].Password == password) {
                        // store user details in local storage to keep user logged in between page refreshes
                        localStorage.setItem('currentUserProfile', JSON.stringify(resp.data.users[0]));
                    }
                    else {
                        throw new Error('Password is not correct!');
                    }
                }
                else{
                    throw new Error('User Not Found!');
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUserProfile');
    }
}
