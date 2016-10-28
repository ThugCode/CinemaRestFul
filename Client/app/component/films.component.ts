import { Component, OnInit } from '@angular/core';

import { Film } from '../metier/film';
import { FilmService } from '../service/film.service';

@Component({
    selector: 'films',
    templateUrl: 'app/views/films.component.html'
})
export class FilmsComponent implements OnInit {
    films: Film[];

    constructor(private filmService: FilmService) { }

    getFilms() {
        this.filmService.getFilms()
            .subscribe(films => this.films = films);
    }

    ngOnInit() {
        this.getFilms();
    }
}