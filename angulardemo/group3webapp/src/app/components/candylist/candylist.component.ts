import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-candylist',
  templateUrl: './candylist.component.html',
  styleUrls: ['./candylist.component.css']
})
export class CandylistComponent implements OnInit {
  candyList:Candy[];
  candy1:Candy;
  candy2:Candy;
  candy3:Candy;
  name:string;
  candies:string[];
  
  constructor() {
    
   }

  ngOnInit() {
    console.log("candy ngOnInit ran");
    this.candy1={name:'chocolate',type:'chocolate-based',
    ingredients:['cocoa','milk','sugar']};
    this.candy2={
      name:'candied beets',
      type:'vegetable-based',
      ingredients:['beets','butter','brown sugar']
    }
    this.candy3={
      name:'lollipops',
      type:'sugar-based',
      ingredients:['sugar','corn syrup (sugar)','flavor extract']
    
    }
      this.candyList=[this.candy1,this.candy2,this.candy3];
    }
    onClick(){
      if(this.candy1.name=="chocolate"){
      this.candy1.name="hershey";
      }
      else{
        this.candy1.name="chocolate";
      }
    }
  }  


interface Candy {
  name:string,
  type:string,
  ingredients:string[]
}
