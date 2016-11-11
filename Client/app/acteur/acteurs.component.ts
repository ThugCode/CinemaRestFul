import { Component, OnInit } from '@angular/core';

import { Acteur } from './acteur';
import { ActeurService } from './acteur.service';

@Component({
    selector: 'acteurs',
    templateUrl: 'app/acteur/acteurs.component.html'
})
export class ActeursComponent implements OnInit {
    acteurs: Acteur[];

    constructor(private acteurService: ActeurService) { }

    getActeurs() {
        this.acteurService.getActeurs()
            .subscribe(acteurs => this.acteurs = acteurs);
    }

    ngOnInit() {
        this.getActeurs();
    }
}