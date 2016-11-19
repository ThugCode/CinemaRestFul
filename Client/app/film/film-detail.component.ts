import { Component, Input, OnInit } from '@angular/core';

import { FilmService } from './film.service';
import { Film } from './film';

@Component({
    selector: 'film-detail',
    templateUrl: 'app/film/film-detail.component.html'
})
export class FilmDetailComponent implements OnInit {
    @Input() filmId: number;
    film: Film;

    constructor(private filmService: FilmService) { }

    getFilm() {
        this.filmService.getFilm(this.filmId)
            .subscribe(film => this.film = film);
    }

    ngOnInit() {
        this.getFilm();
    }
}