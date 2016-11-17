import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Categorie } from './categorie';
import { MainService } from '../shared/main.service';

@Injectable()
export class CategorieService extends MainService<Categorie> {

    constructor(http: Http) {
        super(http);
        this.baseUrl = this.baseUrl + "categories";
    }

    getCategories(): Observable<Categorie[]> {
        return this.http.get(this.baseUrl).map(response => <Categorie[]> response.json().categorie);
    }
}