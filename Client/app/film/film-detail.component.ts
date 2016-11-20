import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import * as toastr from 'toastr';

import { FilmService } from './film.service';
import { Film } from './film';

@Component({
    selector: 'film-detail',
    templateUrl: 'app/film/film-detail.component.html'
})
export class FilmDetailComponent implements OnInit {
    film: Film;

    constructor(
        private filmService: FilmService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.filmService.getFilm(+params['id']))
            .subscribe(film => this.film = film);
    }

    goBack(): void {
        this.location.back();
    }

    save() {
        this.filmService.updateFilm(this.film)
        .subscribe(film => { this.film = film; toastr.success('Modification réussie');});
    }
}