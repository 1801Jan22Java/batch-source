import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule }  from './app-routing.module';
import { MainComponent } from './components/main/main.component';
import { BlueWhalesComponent } from './components/blue-whales/blue-whales.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    BlueWhalesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
