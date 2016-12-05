import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import * as toastr from 'toastr';

import { FilmService } from './film.service';
import { CategorieService } from '../categorie/categorie.service';
import { RealisateurService } from '../realisateur/realisateur.service';

import { Film } from './film';
import { Categorie } from '../categorie/categorie';
import { Realisateur } from '../realisateur/realisateur';

@Component({
    selector: 'film-detail',
    templateUrl: 'app/film/film-detail.component.html'
})
export class FilmDetailComponent implements OnInit {
    film: Film;
    categories: Categorie[];
    realisateurs: Realisateur[];

    constructor(
        private filmService: FilmService,
        private categorieService: CategorieService,
        private realisateurService: RealisateurService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.filmService.getFilm(+params['id']))
            .subscribe(film => this.film = film);

        this.categorieService.getCategories()
            .subscribe(categories => this.categories = categories);

        this.realisateurService.getRealisateurs()
            .subscribe(realisateurs => this.realisateurs = realisateurs);
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.film.realisateur = this.realisateurs.find(realisateur => realisateur.noRea == this.film.realisateur.noRea);
        this.film.categorie = this.categories.find(categorie => categorie.codeCat == this.film.categorie.codeCat);
        this.filmService.updateFilm(this.film)
            .subscribe(film => {
                this.film = film;
                toastr.success('Modification réussie');
                this.location.back();
            });
    }
}