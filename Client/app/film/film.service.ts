import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Film } from './film';
import { MainService } from '../shared/main.service';

@Injectable()
export class FilmService extends MainService<Film> {

    constructor(http: Http) {
        super(http);
        this.baseUrl = this.baseUrl + "films";
    }
    
    getFilms(): Observable<Film[]> {
        return this.http.get(this.baseUrl).map(response => <Film[]> response.json().film);
    }
}
