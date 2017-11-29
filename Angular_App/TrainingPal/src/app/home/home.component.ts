import { Component, OnInit } from '@angular/core';

import { User } from '../_models/index';

/*
    Created with the help of: http://jasonwatmore.com/post/2016/09/29/angular-2-user-registration-and-login-example-tutorial
 */

@Component({
    moduleId: module.id,
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    currentUser: User;

    constructor() {
        this.currentUser = JSON.parse(localStorage.getItem('currentUserProfile'));
    }

    ngOnInit() {
    }
}
