import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
// map() function which maps http responses into our objects
import 'rxjs/Rx';

//Models
import { User } from '../models/user.model';

@Injectable()
export class UserService {

    constructor() {}

    public getUser(): Observable<User> {
        return;
    }

}