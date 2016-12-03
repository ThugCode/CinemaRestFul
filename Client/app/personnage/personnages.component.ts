import { Component, OnInit } from '@angular/core';

import { Personnage } from './personnage';
import { PersonnageService } from './personnage.service';

import * as toastr from 'toastr';

@Component({
    selector: 'personnages',
    templateUrl: 'app/personnage/personnages.component.html'
})
export class PersonnagesComponent implements OnInit {
    personnages: Personnage[];
    personnage: Personnage;

    constructor(private personnageService: PersonnageService) { }

    getPersonnages() {
        this.personnageService.getPersonnages()
            .subscribe(personnages => this.personnages = personnages);
    }

    ngOnInit() {
        this.getPersonnages();
    }

    selectedPersonnage(personnage: Personnage) {
        this.personnage = personnage;
    }

    deletePersonnage() {
        this.personnageService.deletePersonnage(this.personnage.id)
            .subscribe(
            personnage => {
                toastr.success("Personnage " + personnage.nomPers + " supprimé");
                this.getPersonnages();
            }
            );
    }
}