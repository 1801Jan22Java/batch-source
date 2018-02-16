import { Injectable } from '@angular/core';

@Injectable()
export class ServiceService {

  constructor() { }

  cats = [
    'Persian', 'Chitzhu', 'Brown Tabby'
  ];

  returnCats() {
    return this.cats;
  }
}
