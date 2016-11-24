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

    getFilm(id: number): Observable<Film> {
        var url = this.baseUrl + "/get/" + id;
        return this.getItem(url);
    }

    updateFilm(film: Film): Observable<Film> {
        var url = this.baseUrl + "/update/";
        var body = JSON.stringify(film);

        return this.updateItem(url,body);
    }

    addFilm(film: Film): Observable<Film> {
        var url = this.baseUrl + "/add/";
        var body = JSON.stringify(film);

        return this.addItem(url,body);
    }
}
