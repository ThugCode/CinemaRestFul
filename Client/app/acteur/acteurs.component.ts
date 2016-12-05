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

    getActeurs(): void {
        this.acteurService.getActeurs()
            .subscribe(acteurs => this.acteurs = acteurs);
    }

    ngOnInit(): void {
        this.getActeurs();
    }

    selectedActeur(acteur: Acteur): void {
        this.acteur = acteur;
    }

    deleteActeur(): void {
        this.acteurService.deleteActeur(this.acteur.noAct)
            .subscribe(
            acteur => {
                toastr.success("Acteur " + acteur.nomAct + " " + acteur.prenAct + " supprimé");
                this.getActeurs();
            });
    }
}