import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
   name:string;
   age: number;
   email:string;
   address:Address;
   hobbies: string[];
  constructor() { 
    console.log('Constructor ran');
  }

  ngOnInit() {
    this.name='John';
    this.age = 30;
    this.address={
      street:'191 South Park Street',
      city: 'Madison',
      state: 'WI'
    }
    this.hobbies = ['foreign language', 'code','music'];


 
    verify(this.name);
    console.log('ngOnInit ran');
  }
}
var verify = function(name:string){
  if (name != 'Bob Ross')
  {
   this.name="You are not welcome here";
  }
}


interface Address {
    street:string,
    city:string,
    state:string
  }
