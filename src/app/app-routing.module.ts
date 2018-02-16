import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//components
import { HomeComponent } from './components/home/home.component';
import { Page1Component } from './components/page1/page1.component';
import { Page2Component } from './components/page2/page2.component';
import { Page3Component } from './components/page3/page3.component';
import { NavbarComponent } from './components/navbar/navbar.component';
export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home',  component: HomeComponent },
  { path: 'page1',  component: Page1Component },
  { path: 'page2',  component: Page2Component},
  { path: 'page3', component: Page3Component },
  { path: 'navbar', component: NavbarComponent},
  { path: '**', redirectTo: '/main' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }




