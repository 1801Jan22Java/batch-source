import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html'
})
export class DatabindingComponent implements OnInit {

  title = 'Data Binding';
  image = 'assets/images/databinding.png';
  documentation = 'https://angular.io/guide/architecture#data-binding';

  //for interpolation
  interpolationNotation = '{{}}';
  interpolationText = 'this was bound by interpolation';

  //for property binding
  propertyBindingNotation = '[]';

  public objectStyle = {
    color:'red',
    border: '1px solid black',
    cursor: 'pointer',
    margin: '2px'
  };

  public changeStyles(): void {
    if (this.objectStyle.color === 'red') {
      this.objectStyle.color = 'blue';
      this.objectStyle.border = '4px groove purple';
    } 
    else if (this.objectStyle.color === 'blue') {
      this.objectStyle.color = 'green';
      this.objectStyle.border = '4px ridge yellow';
    }
    else {
      this.objectStyle.color = 'red';
      this.objectStyle.border = '4px solid black';
    }
  }

  //for event binding
  eventBindingNotation = '()';

  public counter: number = 0;

  public incrementCounter(): void {
    this.counter++;
  }

  //for two-way data binding
  twoWayBindingNotation = '[()]';
  public user = {
    email: '',
    password: ''
  };





}
