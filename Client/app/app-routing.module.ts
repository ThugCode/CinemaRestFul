import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccueilComponent } from './accueil/accueil.component';
import { ActeursComponent } from './acteur/acteurs.component';
import { ActeurDetailComponent } from './acteur/acteur-detail.component';
import { ActeurAddComponent } from './acteur/acteur-add.component';
import { CategoriesComponent } from './categorie/categories.component';
import { FilmsComponent } from './film/films.component';
import { FilmDetailComponent } from './film/film-detail.component';
import { FilmAddComponent } from './film/film-add.component';
import { PersonnagesComponent } from './personnage/personnages.component';
import { RealisateursComponent } from './realisateur/realisateurs.component';

const routes: Routes = [
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: 'accueil', component: AccueilComponent },
  { path: 'acteurs', component: ActeursComponent },
  { path: 'acteurs/detail/:id', component: ActeurDetailComponent },
  { path: 'acteurs/add', component: ActeurAddComponent },
  { path: 'categories', component: CategoriesComponent },
  { path: 'films', component: FilmsComponent },
  { path: 'films/detail/:id', component: FilmDetailComponent },
  { path: 'films/add', component: FilmAddComponent},
  { path: 'personnages', component: PersonnagesComponent },
  { path: 'realisateurs', component: RealisateursComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }