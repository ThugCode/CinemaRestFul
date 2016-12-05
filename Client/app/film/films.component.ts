import { Component, OnInit } from '@angular/core';

import { Film } from './film';
import { FilmService } from './film.service';

import * as toastr from 'toastr';

@Component({
    selector: 'films',
    templateUrl: 'app/film/films.component.html'
})
export class FilmsComponent implements OnInit {
    films: Film[];
    film: Film;

    constructor(private filmService: FilmService) { }

    getFilms(): void {
        this.filmService.getFilms()
            .subscribe(
            films => this.films = films
            );
    }

    ngOnInit(): void {
        this.getFilms();
    }

    selectedFilm(film: Film): void {
        this.film = film;
    }

    deleteFilm(): void {
        this.filmService.deleteFilm(this.film.noFilm)
            .subscribe(
            film => {
                toastr.success("Film " + film.titre + " supprimé");
                this.getFilms();
            });
    }
}