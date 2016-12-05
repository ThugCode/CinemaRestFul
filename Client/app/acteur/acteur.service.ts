import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Acteur } from './acteur';
import { MainService } from '../shared/main.service';

@Injectable()
export class ActeurService extends MainService<Acteur> {

    constructor(http: Http) {
        super(http);
        this.baseUrl = this.baseUrl + "acteurs";
    }

    getActeurs(): Observable<Acteur[]> {
        return this.http.get(this.baseUrl).map(response => <Acteur[]>response.json().acteur);
    }

    getActeur(id: number): Observable<Acteur> {
        var url = this.baseUrl + "/get/" + id;
        return this.getItem(url);
    }

    updateActeur(acteur: Acteur): Observable<Acteur> {
        var url = this.baseUrl + "/update/";
        var body = JSON.stringify(acteur);

        return this.updateItem(url, body);
    }

    addActeur(acteur: Acteur): Observable<Acteur> {
        var url = this.baseUrl + "/add/";
        var body = JSON.stringify(acteur);

        return this.addItem(url, body);
    }

    deleteActeur(id: number): Observable<Acteur> {
        var url = this.baseUrl + "/delete/" + id;
        return this.deleteItem(url);
    }
}