import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class MainService<T> {

    protected baseUrl = "http://localhost:8080/CinemaRestFulServeur/";

    constructor(private http: Http) { }

    getList(url): Observable<T[]> {
        return this.http.get(url).map(response => <T[]> response.json());
    }

    getItem(url): Observable<T> {
        return this.http.get(url).map(response => <T> response.json());
    }

    addItem(url, body): Observable<T> {
        return this.http.post(url, body).map(response => <T> response.json());
    }

    updateItem(url, body): Observable<T> {
        return this.http.post(url, body).map(response => <T> response.json());
    }

    deleteItem(url, body): Observable<T> {
        return this.http.post(url, body).map(response => <T> response.json());
    }
}