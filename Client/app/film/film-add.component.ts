import { Component } from '@angular/core';
import { Location } from '@angular/common';


@Component({
    selector: 'film-add',
    template: '<film-form></film-form>'
})
export class FilmAddComponent {

    constructor(
        private location: Location
    ) { }


    goBack() {
        this.location.back();
    }
}