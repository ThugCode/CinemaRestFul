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

    getPersonnages(): void {
        this.personnageService.getPersonnages()
            .subscribe(personnages => this.personnages = personnages);
    }

    ngOnInit(): void {
        this.getPersonnages();
    }

    selectedPersonnage(personnage: Personnage): void {
        this.personnage = personnage;
    }

    deletePersonnage(): void {
        this.personnageService.deletePersonnage(this.personnage.id)
            .subscribe(
            personnage => {
                toastr.success("Personnage " + personnage.nomPers + " supprimé");
                this.getPersonnages();
            });
    }
}