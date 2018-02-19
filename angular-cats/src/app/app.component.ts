import { Component, OnInit } from '@angular/core';
import { CatService } from './service/service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app';
  image = './assets/images'

  constructor(private service:CatService) {

  }

  ngOnInit(){
    console.log(this.service.cats);
  }
}
