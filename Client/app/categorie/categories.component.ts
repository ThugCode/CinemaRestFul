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

    getCategories(): void {
        this.categorieService.getCategories()
            .subscribe(
            categories => this.categories = categories
            );
    }

    ngOnInit(): void {
        this.getCategories();
    }

    selectedCategorie(categorie: Categorie): void {
        this.categorie = categorie;
    }

    deleteCategorie(): void {
        this.categorieService.deleteCategorie(this.categorie.codeCat)
            .subscribe(
            categorie => {
                toastr.success("Categorie " + categorie.libelleCat + " supprimée");
                this.getCategories();
            });
    }
}