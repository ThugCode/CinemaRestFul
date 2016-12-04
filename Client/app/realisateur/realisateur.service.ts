import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Realisateur } from './realisateur';
import { MainService } from '../shared/main.service';

@Injectable()
export class RealisateurService extends MainService<Realisateur> {

    constructor(http: Http) {
        super(http);
        this.baseUrl = this.baseUrl + "realisateurs";
    }

    getRealisateurs(): Observable<Realisateur[]> {
        return this.http.get(this.baseUrl).map(response => <Realisateur[]> response.json().realisateur);
    }

    getRealisateur(id: number): Observable<Realisateur> {
        var url = this.baseUrl + "/get/" + id;
        return this.getItem(url);
    }

    updateRealisateur(realisateur: Realisateur): Observable<Realisateur> {
        var url = this.baseUrl + "/update/";
        var body = JSON.stringify(realisateur);

        return this.updateItem(url, body);
    }

    addRealisateur(realisateur: Realisateur): Observable<Realisateur> {
        var url = this.baseUrl + "/add/";
        var body = JSON.stringify(realisateur);

        return this.addItem(url, body);
    }

    deleteRealisateur(id: number): Observable<Realisateur> {
        var url = this.baseUrl + "/delete/" + id;
        return this.deleteItem(url);
    }
}