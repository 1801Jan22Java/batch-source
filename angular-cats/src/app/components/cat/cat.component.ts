import { Component, OnInit } from '@angular/core';
import { CatService } from '../../service/service.service';
import { Cat } from '../../models/cat.model';
import { UppercasePipe } from '../../uppercase.pipe';

@Component({
  selector: 'app-cat',
  templateUrl: './cat.component.html',
  styleUrls: ['./cat.component.css']
})
export class CatComponent{

  title = 'Cat Adoption form';
  cats : Cat;
  catArray : Cat[];
  
  constructor(private catService: CatService) {

  }

  getCats(id: number): Cat {
    this.catArray = this.catService.cats;
    return this.catService.getCats(id);
  }

  ngOnInit() {
    this.cats = this.getCats(0);
  }
}
