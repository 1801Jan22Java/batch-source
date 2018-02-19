
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CatComponent } from './components/cat/cat.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { FounderComponent } from './components/founder/founder.component';
import { LoginComponent } from './components/login/login.component';

import { CatService } from './service/service.service';


export const routes: Routes = [
    { path: '', redirectTo: '/homepage', pathMatch: 'full'},
    { path: 'app-cat', component: CatComponent },
    { path: 'navbar', component: NavbarComponent },
    { path: 'homepage', component: HomepageComponent },
    { path: 'app-founder', component: FounderComponent },
    { path: 'app-login', component: LoginComponent },
    { path: '**', redirectTo: '/homepage'}
]

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule{}