import { Component } from '@angular/core';
import {FilmService} from './service/film.service';
import {Film} from './metier/film';

@Component({
  selector: 'my-app',
  template: `<h1>My First Angular App</h1>
      <ul>
      <li *ngFor="let film of films">
        <span class="badge">{{film.noFilm}}</span> {{film.titre}}
      </li>
    </ul>`
})
export class AppComponent {
  films: Film[];

  constructor(private filmService: FilmService) {
    this.filmService.getFilms().subscribe(films => this.films = films);
  }
 }
