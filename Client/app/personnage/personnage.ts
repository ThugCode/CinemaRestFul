import { Film } from '../film/film';
import { Acteur } from '../acteur/acteur';

export class Personnage {
    noFilm: number;
    noAct: number;
    film: Film;
    acteur: Acteur;
    nomPers: string;
}