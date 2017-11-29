import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, UserService } from '../_services/index';

/*
    Created with the help of: http://jasonwatmore.com/post/2016/09/29/angular-2-user-registration-and-login-example-tutorial
 */

@Component({
    moduleId: module.id,
    templateUrl: 'update_user.component.html'
})

export class Update_UserComponent {
    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    update() {
        this.loading = true;
        let currentUser = JSON.parse(localStorage.getItem('currentUserProfile'));
        this.model.id = currentUser.Id;

        console.log(currentUser.Id);

        this.userService.update(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Update successful', true);
                    this.userService.setUser(currentUser.Id).subscribe(
                      data => {

                      },
                      error => {

                      }
                    );
                    this.router.navigate(['/']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
