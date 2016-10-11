import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Film } from './film';

@Injectable()
export class FilmService {
    private _filmUrl = "";

    constructor(private http: Http) {}

    getFilms(): Observable<Film[]> {
          return this.http.get(this._filmUrl)
          .map(response => <Film[]> response.json());
    }
}
