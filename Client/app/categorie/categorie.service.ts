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

    getCategorie(code: string): Observable<Categorie> {
        var url = this.baseUrl + "/get/" + code;
        return this.getItem(url);
    }

    updateCategorie(categorie: Categorie): Observable<Categorie> {
        var url = this.baseUrl + "/update/";
        var body = JSON.stringify(categorie);

        return this.updateItem(url, body);
    }

    addCategorie(categorie: Categorie): Observable<Categorie> {
        var url = this.baseUrl + "/add/";
        var body = JSON.stringify(categorie);

        return this.addItem(url, body);
    }

    deleteCategorie(code: string): Observable<Categorie> {
        var url = this.baseUrl + "/delete/" + code;
        return this.deleteItem(url);
    }
}