import { Component, OnInit } from '@angular/core';
import { CatService } from '../../service/service.service';
import { Cat } from '../../models/cat.model';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})

export class HomepageComponent{
  title = 'Cat Adoption form';
  cats : Cat;
  catArray : Cat[];
  service: CatService;
  constructor (private catService: CatService){
  this.service = catService;
}



  getCats(id: number): void {
    this.catArray = this.catService.cats;
    this.cats = this.service.getCats(id);
  }

  
  ngOnInit() {
    this.getCats(0);
  }
}
