import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { Categorie } from '../categorie/categorie';
import { CategorieService } from '../categorie/categorie.service';

import * as toastr from 'toastr';

@Component({
    selector: 'categorie-form',
    templateUrl: 'app/categorie/categorie-form.component.html'
})
export class CategorieFormComponent implements OnInit {
    categorie: Categorie = new Categorie();
    categories: Categorie[];

    constructor(
        private categorieService: CategorieService,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.categorieService.getCategories()
            .subscribe(categories => this.categories = categories);
    }

    onSubmit(): void {
        if (this.categories.find(cat => cat.codeCat == this.categorie.codeCat) != null) {
            toastr.error("Code catégorie déjà existant !");
        } else {
            this.categorieService.addCategorie(this.categorie)
                .subscribe(categorie => {
                    toastr.success("Ajout de la categorie " + categorie.libelleCat + " réussie");
                    this.location.back();
                });
        }
    }

    goBack(): void {
        this.location.back();
    }
}