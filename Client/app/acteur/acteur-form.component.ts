import { Component } from '@angular/core';
import { Location } from '@angular/common';

import { ActeurService } from './acteur.service';

import { Acteur } from './acteur';

import * as toastr from 'toastr';

@Component({
    selector: 'acteur-form',
    templateUrl: 'app/acteur/acteur-form.component.html'
})
export class ActeurFormComponent {
    acteur: Acteur = new Acteur();

    constructor(
        private acteurService: ActeurService,
        private location: Location
    ) { }

    onSubmit(): void {
        this.acteur.noAct = Math.floor(Math.random() * 1000) + Math.floor(Math.random() * 1000);
        this.acteurService.addActeur(this.acteur)
            .subscribe(acteur => {
                toastr.success("Acteur " + acteur.nomAct + " " + acteur.prenAct + " ajouté");
                this.location.back();
            });
    }

    goBack(): void {
        this.location.back();
    }
}