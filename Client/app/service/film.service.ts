import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Film } from '../metier/film';

@Injectable()
export class FilmService {
    private _filmUrl = "http://localhost:8080/CinemaRestFulServeur/mediatheque/Film";

    constructor(private http: Http) { }

    getFilms(): Observable<Film[]> {
        return this.http.get(this._filmUrl).map(response => <Film[]> response.json());
    }
}
