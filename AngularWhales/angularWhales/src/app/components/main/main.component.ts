import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  title = 'Welcome to Angular Whales';

  constructor() { console.log("WHALESSSSSSS")}

  ngOnInit() {
    console.log("2Whales")
  }

}
