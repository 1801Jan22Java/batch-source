import { Component, OnInit } from '@angular/core';
import { CatService } from '../../service/service.service';
import { Cat } from '../../models/cat.model';

@Component({
  selector: 'app-cat',
  templateUrl: './cat.component.html',
  styleUrls: ['./cat.component.css']
})
export class CatComponent{

  title = 'Cat Adoption form';
  cats : Cat[];
  
  constructor(private catService: CatService) {

  }

  getCats(): void {
    this.cats = this.catService.getCats();
  }
}
