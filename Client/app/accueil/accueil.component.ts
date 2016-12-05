import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FilmService } from '../film/film.service';
import { Film } from '../film/film';

@Component({
    selector: 'accueil',
    templateUrl: 'app/accueil/accueil.component.html',
    styleUrls: ['app/accueil/accueil.component.scss']
})
export class AccueilComponent implements OnInit {
    films: Film[];
    filmSelected: Film;

    constructor(private filmService: FilmService, private router: Router) { }

    getFilms(): void {
        this.filmService.getFilms()
            .subscribe(films => this.films = films)
    }

    ngOnInit(): void {
        this.getFilms();
    }
}