import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import * as toastr from 'toastr';

import { PersonnageService } from './personnage.service';
import { Personnage, PersonnageId } from './personnage';

@Component({
    selector: 'personnage-detail',
    templateUrl: 'app/personnage/personnage-detail.component.html'
})
export class PersonnageDetailComponent implements OnInit {
    personnage: Personnage;

    constructor(
        private personnageService: PersonnageService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.personnageService.getPersonnage(+params['idFilm'], +params['idAct']))
            .subscribe(personnage => this.personnage = personnage);
    }

    goBack(): void {
        this.location.back();
    }
    
    save(): void {
        this.personnageService.updatePersonnage(this.personnage)
        .subscribe(personnage => { 
            this.personnage = personnage;
            toastr.success("Modification réussie");
            });
    }
}