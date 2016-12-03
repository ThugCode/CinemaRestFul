import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Personnage, PersonnageId } from './personnage';
import { MainService } from '../shared/main.service';

@Injectable()
export class PersonnageService extends MainService<Personnage> {

    constructor(http: Http) {
        super(http);
        this.baseUrl = this.baseUrl + "personnages";
    }

    getPersonnages(): Observable<Personnage[]> {
        return this.http.get(this.baseUrl).map(response => <Personnage[]> response.json().personnage);
    }

    getPersonnage(idFilm: number, idAct: number): Observable<Personnage> {
        var url = this.baseUrl + "/get/" + idFilm + "/" + idAct;
        return this.getItem(url);
    }

    updatePersonnage(personnage: Personnage): Observable<Personnage> {
        var url = this.baseUrl + "/update/";
        var body = JSON.stringify(personnage);

        return this.updateItem(url, body);
    }

    addPersonnage(personnage: Personnage): Observable<Personnage> {
        var url = this.baseUrl + "/add/";
        var body = JSON.stringify(personnage);

        return this.addItem(url, body);
    }

    deletePersonnage(id: PersonnageId): Observable<Personnage> {
        var url = this.baseUrl + "/delete/" + id.noFilm + "/" + id.noAct;
        return this.deleteItem(url);
    }
}