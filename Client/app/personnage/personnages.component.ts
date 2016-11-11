import { Component, OnInit } from '@angular/core';

import { Personnage } from './personnage';
import { PersonnageService } from './personnage.service';

@Component({
    selector: 'personnages',
    templateUrl: 'app/personnage/personnages.component.html'
})
export class PersonnagesComponent implements OnInit {
    personnages: Personnage[];

    constructor(private personnageService: PersonnageService) { }

    getPersonnages() {
        this.personnageService.getPersonnages()
        .subscribe(personnages => this.personnages = personnages);
    }

    ngOnInit() {
        this.getPersonnages();
     }
}