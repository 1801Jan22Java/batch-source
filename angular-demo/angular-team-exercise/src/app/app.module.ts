import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// Routing
import { AppRoutingModule }  from './app-routing.module';


import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { LoginComponent } from './components/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    AuthorsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
