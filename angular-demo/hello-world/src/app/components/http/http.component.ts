import { Component, OnInit } from '@angular/core';
// import { Response } from '@angular/http';
import  { BearService } from '../../services/bear.service';
import { Bear } from '../../models/bear.model'; 


@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
})
export class HttpComponent implements OnInit {

	title = 'HTTP';
	documentation = 'https://angular.io/guide/http';

	// injecting the service
	constructor(private bearService: BearService) {}

	public bear: Bear = new Bear(0, '');

	getBearInformation(): void {
		this.bearService.fetchBearInformation(this.bear.id)
		.subscribe(
			bear => this.bear = bear,
			error => console.log(`Error: ${error}`)
		);
		// .subscribe(response => this.bear = response.text());

	}

  ngOnInit() {
  }

}
