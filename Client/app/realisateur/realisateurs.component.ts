import { Component, OnInit } from '@angular/core';

import { Realisateur } from './realisateur';
import { RealisateurService } from './realisateur.service';

@Component({
    selector: 'realisateurs',
    templateUrl: 'app/realisateur/realisateurs.component.html'
})
export class RealisateursComponent implements OnInit {
    realisateurs: Realisateur[];

    constructor(private realisateurService: RealisateurService) { }

    getRealisateurs() {
        this.realisateurService.getRealisateurs()
        .subscribe(realisateurs => this.realisateurs = realisateurs);
    }

    ngOnInit() {
        this.getRealisateurs();
     }
}