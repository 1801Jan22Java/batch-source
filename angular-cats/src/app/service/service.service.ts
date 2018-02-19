import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Cat } from '../models/cat.model';

@Injectable()
export class CatService {


  constructor(private http: HttpClient) { }

  cats = [
    new Cat('Persian', 1), new Cat('Chitzhu',2), new Cat('Brown Tabby',3)
  ];


  getCats() {
    return this.cats;
  } 

}
