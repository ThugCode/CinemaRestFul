import { Film } from '../film/film';
import { Acteur } from '../acteur/acteur';

export class Personnage {
    id: PersonnageId;
    film: Film;
    acteur: Acteur;
    nomPers: string;
}

export class PersonnageId {
    noFilm: number;
    noAct: number;

    constructor(noFilm: number, noAct: number) {
        this.noFilm = noFilm;
        this.noAct = noAct;
    }
}