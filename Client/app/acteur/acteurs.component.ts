import { Component, OnInit } from '@angular/core';

import { Acteur } from './acteur';
import { ActeurService } from './acteur.service';

import * as toastr from 'toastr';

@Component({
    selector: 'acteurs',
    templateUrl: 'app/acteur/acteurs.component.html'
})
export class ActeursComponent implements OnInit {
    acteurs: Acteur[];
    acteur: Acteur;

    constructor(private acteurService: ActeurService) { }

    getActeurs() {
        this.acteurService.getActeurs()
            .subscribe(acteurs => this.acteurs = acteurs);
    }

    ngOnInit() {
        this.getActeurs();
    }

    selectedActeur(acteur: Acteur) {
        this.acteur = acteur;
    }

    deleteActeur() {
                this.acteurService.deleteActeur(this.acteur.noAct)
            .subscribe(
            acteur => {
                toastr.success("Acteur " + acteur.nomAct +" "+ acteur.prenAct + " supprimé");
                this.getActeurs();
            }
            );
    }
}