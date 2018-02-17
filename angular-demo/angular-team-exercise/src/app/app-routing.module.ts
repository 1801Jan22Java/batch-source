// Modules
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Components
import { AppComponent } from './app.component';
// import { GenreComponent } from './components/genre/genre.component';
// import { ActorComponent } from './components/actor/actor.component';
// import { MovieComponent } from './components/movie/movie.component';


export const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main',  component: AppComponent },
  // { path: 'genre',  component: GenreComponent },
  // { path: 'actor',  component: ActorComponent },
  // { path: 'movie',  component: MovieComponent },
  { path: '**', redirectTo: '/main' }
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}