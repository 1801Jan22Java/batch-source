// Modules
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Components
import { MainComponent } from './components/main/main.component';
import { LoginComponent } from './components/login/login.component';
import { CandylistComponent } from './components/candylist/candylist.component';
import { RecipesubComponent } from './components/recipesub/recipesub.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';


export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {path : 'main',component: MainComponent},
  { path: 'login',  component: LoginComponent },
  {path: 'candylist', component:CandylistComponent},
  {path: 'recipesub', component:RecipesubComponent},
  { path: '**', redirectTo: '/login' }
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}