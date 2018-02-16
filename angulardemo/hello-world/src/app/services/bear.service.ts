import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
// map() function which maps http responses into our objects
import 'rxjs/Rx';

//Models
import { Bear } from '../models/bear.model';

@Injectable()
export class BearService {

    //Injecting the http object
    constructor(private http: HttpClient) {}

    public fetchBearInformation(id: number): Observable<Bear> {
        return this.http
                .get(`https://pokeapi.co/api/v2/pokemon/${id}`)
                .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}