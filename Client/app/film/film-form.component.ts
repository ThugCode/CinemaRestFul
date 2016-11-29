import { Component, OnInit } from '@angular/core';

import { FilmService } from './film.service';
import { CategorieService } from '../categorie/categorie.service';
import { RealisateurService } from '../realisateur/realisateur.service';

import { Film } from './film';
import { Categorie } from '../categorie/categorie';
import { Realisateur } from '../realisateur/realisateur';

import * as toastr from 'toastr';

@Component({
    selector: 'film-form',
    templateUrl: 'app/film/film-form.component.html'
})
export class FilmFormComponent implements OnInit {
    film: Film = new Film();
    submitted: boolean = false;
    categories: Categorie[];
    realisateurs: Realisateur[];

    constructor(
        private filmService: FilmService,
        private categorieService: CategorieService,
        private realisateurService: RealisateurService
    ) { }

    ngOnInit() {
        this.categorieService.getCategories()
            .subscribe(categories => this.categories = categories);

        this.realisateurService.getRealisateurs()
            .subscribe(realisateurs => this.realisateurs = realisateurs);
    }

    onSubmit() {
        this.film.noFilm = Math.floor(Math.random() * 1000) + Math.floor(Math.random() * 1000);
        console.log(this.film);
        this.filmService.addFilm(this.film)
            .subscribe(film => toastr.success('Ajout du film ' + film.titre + ' réussie'));
    }
}