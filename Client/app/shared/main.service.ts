import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import { Injectable } from '@angular/core';
import { Headers, RequestOptions, Http } from '@angular/http';

@Injectable()
export class MainService<T> {

    protected baseUrl = "http://localhost:8080/CinemaRestFulServeur/";
    private headers = new Headers({'Content-Type': 'application/json'});
    private options = new RequestOptions({ headers: this.headers });

    constructor(protected http: Http) { }

    protected getItem(url): Observable<T> {
        return this.http.get(url).map(response => <T> response.json());
    }

    protected addItem(url, body): Observable<T> {
        return this.http.post(url, body, this.options).map(response => <T> response.json());
    }

    protected updateItem(url, body): Observable<T> {
        return this.http.post(url, body, this.options).map(response => <T> response.json());
    }

    protected deleteItem(url, body): Observable<T> {
        return this.http.post(url, body, this.options).map(response => <T> response.json());
    }
}