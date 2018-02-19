import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Cat } from '../models/cat.model';
import 'rxjs/Rx';

@Injectable()
export class CatService {


  constructor(private http: HttpClient) { }

  cats: Cat[] = [
    new Cat('Persian', 1), new Cat('Chitzhu',2), new Cat('Brown Tabby',3)
  ];


  getCats(id: number): Cat {
    return this.cats[id];
  } 

  /*constructor(private http: HttpClient) {}

    public fetchBearInformation(id: number): Observable<Cat> {
        return this.http
                .get(`https://pokeapi.co/api/v2/pokemon/${id}`)
                .catch(this.handleError);
    }

    public fetchFullResponse(){
        
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }*/

}
