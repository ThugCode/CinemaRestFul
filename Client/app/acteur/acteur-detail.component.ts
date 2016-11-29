import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import * as toastr from 'toastr';

import { ActeurService } from './acteur.service';
import { Acteur } from './acteur';

@Component({
    selector: 'acteur-detail',
    templateUrl: 'app/acteur/acteur-detail.component.html'
})
export class ActeurDetailComponent implements OnInit {
    acteur: Acteur;

    constructor(
        private acteurService: ActeurService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.acteurService.getActeur(+params['id']))
            .subscribe(acteur => this.acteur = acteur);
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.acteurService.updateActeur(this.acteur)
            .subscribe(acteur => { this.acteur = acteur; toastr.success("Modification réussie"); });
    }
}