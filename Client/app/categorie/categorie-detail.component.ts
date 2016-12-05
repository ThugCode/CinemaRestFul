import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import * as toastr from 'toastr';

import { Categorie } from './categorie';
import { CategorieService } from './categorie.service';

@Component({
    selector: 'categorie-detail',
    templateUrl: 'app/categorie/categorie-detail.component.html'
})
export class CategorieDetailComponent implements OnInit {
    categorie: Categorie;

    constructor(
        private categorieService: CategorieService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.categorieService.getCategorie(params['code']))
            .subscribe(categorie => this.categorie = categorie);
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.categorieService.updateCategorie(this.categorie)
            .subscribe(categorie => {
                this.categorie = categorie;
                toastr.success('Modification réussie');
                this.location.back();
            });
    }
}