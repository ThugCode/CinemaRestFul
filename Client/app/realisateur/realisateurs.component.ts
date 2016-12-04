import { Component, OnInit } from '@angular/core';

import { Realisateur } from './realisateur';
import { RealisateurService } from './realisateur.service';

import * as toastr from 'toastr';

@Component({
    selector: 'realisateurs',
    templateUrl: 'app/realisateur/realisateurs.component.html'
})
export class RealisateursComponent implements OnInit {
    realisateurs: Realisateur[];
    realisateur: Realisateur;

    constructor(private realisateurService: RealisateurService) { }

    getRealisateurs() {
        this.realisateurService.getRealisateurs()
            .subscribe(realisateurs => this.realisateurs = realisateurs);
    }

    ngOnInit() {
        this.getRealisateurs();
    }

    selectedRealisateur(realisateur: Realisateur) {
        this.realisateur = realisateur;
    }

    deleteRealisateur() {
        this.realisateurService.deleteRealisateur(this.realisateur.noRea)
            .subscribe(
            realisateur => {
                toastr.success("Réalisateur " + realisateur.nomRea + " " + realisateur.prenRea + " supprimé");
                this.getRealisateurs();
            }
            );
    }
}