import { Component } from '@angular/core';
import { Location } from '@angular/common';

import { RealisateurService } from './realisateur.service';
import { Realisateur } from './realisateur';

import * as toastr from 'toastr';

@Component({
    selector: 'realisateur-form',
    templateUrl: 'app/realisateur/realisateur-form.component.html'
})
export class RealisateurFormComponent {
    realisateur: Realisateur = new Realisateur();

    constructor(
        private realisateurService: RealisateurService,
        private location: Location
    ) { }

    onSubmit(): void {
        this.realisateur.noRea = Math.floor(Math.random() * 1000) + Math.floor(Math.random() * 1000);
        this.realisateurService.addRealisateur(this.realisateur)
            .subscribe(realisateur => {
                toastr.success("Ajout du réalisateur " + realisateur.nomRea + " " + realisateur.prenRea + " réussie");
                this.location.back();
            });
    }

    goBack(): void {
        this.location.back();
    }
}