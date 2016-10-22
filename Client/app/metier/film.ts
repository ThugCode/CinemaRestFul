import { Categorie } from './categorie'
import { Realisateur } from './realisateur'

export class Film {
  noFilm: number;
  categorie: Categorie;
  realisateur: Realisateur;
  titre: string;
  duree: number;
  dateSortie: Date;
  budget: number;
  montantRecette: number;
}