import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  title = 'Home';

  constructor(private router: Router){

  }
  home(){
    this.router.navigate(['']);
  }
  adopt(){
    this.router.navigate(['app-cat']);
  }
  founder(){
    this.router.navigate(['app-founder']);
  }
  logout(){
    this.router.navigate(['app-login']);
  }
}
