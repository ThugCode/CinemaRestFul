import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import * as toastr from 'toastr';

import { RealisateurService } from './realisateur.service';
import { Realisateur } from './realisateur';

@Component({
    selector: 'realisateur-detail',
    templateUrl: 'app/realisateur/realisateur-detail.component.html'
})
export class RealisateurDetailComponent implements OnInit {
    realisateur: Realisateur;

    constructor(
        private realisateurService: RealisateurService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.realisateurService.getRealisateur(+params['id']))
            .subscribe(realisateur => this.realisateur = realisateur);
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.realisateurService.updateRealisateur(this.realisateur)
            .subscribe(realisateur => { this.realisateur = realisateur; toastr.success('Modification réussie'); });
    }
}