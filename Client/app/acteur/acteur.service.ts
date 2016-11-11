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
        return this.getList(this.baseUrl);
    }
}