import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { CatComponent } from './components/cat/cat.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomepageComponent } from './components/homepage/homepage.component';

import { CatService } from './service/service.service';
import { UppercasePipe } from './uppercase.pipe';
import { FounderComponent } from './components/founder/founder.component';
import { LoginComponent } from './components/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    CatComponent,
    NavbarComponent,
    HomepageComponent,
    UppercasePipe,
    FounderComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CatService],
  bootstrap: [AppComponent]
})
export class AppModule { }
