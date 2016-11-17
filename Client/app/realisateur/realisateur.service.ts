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
}