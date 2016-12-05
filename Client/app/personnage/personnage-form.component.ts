import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { PersonnageService } from './personnage.service';
import { FilmService } from '../film/film.service';
import { ActeurService } from '../acteur/acteur.service';

import { Personnage, PersonnageId } from './personnage';
import { Film } from '../film/film';
import { Acteur } from '../acteur/acteur';

import * as toastr from 'toastr';

@Component({
    selector: 'personnage-form',
    templateUrl: 'app/personnage/personnage-form.component.html'
})
export class PersonnageFormComponent implements OnInit {
    personnage: Personnage = new Personnage();
    films: Film[];
    acteurs: Acteur[];

    constructor(
        private personnageService: PersonnageService,
        private filmService: FilmService,
        private acteurService: ActeurService,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.filmService.getFilms()
            .subscribe(films => this.films = films);

        this.acteurService.getActeurs()
            .subscribe(acteurs => this.acteurs = acteurs);
    }

    onSubmit(): void {
        this.personnage.id = new PersonnageId(this.personnage.film.noFilm, this.personnage.acteur.noAct);
        this.personnageService.addPersonnage(this.personnage)
            .subscribe(personnage => {
                toastr.success("Ajout du personnage " + personnage.nomPers + " réussie");
                this.location.back();
            });
    }

    goBack(): void {
        this.location.back();
    }
}