import { Component, OnInit } from '@angular/core';

import { Categorie } from './categorie';
import { CategorieService } from './categorie.service';

import * as toastr from 'toastr';

@Component({
    selector: 'categories',
    templateUrl: 'app/categorie/categories.component.html'
})
export class CategoriesComponent implements OnInit {
    categories: Categorie[];
    categorie: Categorie;

    constructor(private categorieService: CategorieService) { }

    getCategories() {
        this.categorieService.getCategories()
            .subscribe(
            categories => this.categories = categories
            );
    }

    ngOnInit() {
        this.getCategories();
    }

    selectedCategorie(categorie: Categorie) {
        this.categorie = categorie;
    }

    deleteCategorie() {
        this.categorieService.deleteCategorie(this.categorie.codeCat)
            .subscribe(
            categorie => {
                toastr.success("Categorie " + categorie.libelleCat + " supprimée");
                this.getCategories();
            }
            );
    }
}