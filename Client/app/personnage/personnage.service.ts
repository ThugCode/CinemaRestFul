import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Personnage } from './personnage';
import { MainService } from '../shared/main.service';

@Injectable()
export class PersonnageService extends MainService<Personnage> {

    constructor(http: Http) {
        super(http);
        this.baseUrl = this.baseUrl + "personnages";
    }

    getPersonnages(): Observable<Personnage[]> {
        return this.getList(this.baseUrl);
    }
}