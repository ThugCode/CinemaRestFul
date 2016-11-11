import { Component, OnInit } from '@angular/core';

import { Categorie } from './categorie';
import { CategorieService } from './categorie.service';

@Component({
    selector: 'categories',
    templateUrl: 'app/categorie/categories.component.html'
})
export class CategoriesComponent implements OnInit {
    categories: Categorie[];

    constructor(private categorieService: CategorieService) { }

    getCategories() {
        this.categorieService.getCategories()
            .subscribe(categories => this.categories = categories);
    }

    ngOnInit() {
        this.getCategories();
     }
}