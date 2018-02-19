import { Component, OnInit } from '@angular/core';
import { BearService } from '../../services/bear.service';
import { Bear } from '../../models/bear.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {

  title = 'HTTP';
  documentaion = 'https://angular.io/guide/http';

  //injecting the service
  constructor(private bearService : BearService) { }

  public bear: Bear = new Bear(10, '');
  public header : String[] = ["default"];

  getBearInformation(): void {
    this.bearService.fetchBearInformation(this.bear.id)
    .subscribe(
      resp => {
        console.log(resp);
        //this.bear = (resp as Bear);
        this.header = resp.headers.keys()},
      error => console.log(`Error: ${ error }`)
    );
  }

  ngOnInit() {
    this.getBearInformation();
  }

}
