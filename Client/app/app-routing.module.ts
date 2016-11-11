import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccueilComponent } from './accueil/accueil.component';
import { ActeursComponent } from './acteur/acteurs.component';
import { CategoriesComponent } from './categorie/categories.component';
import { FilmsComponent } from './film/films.component';
import { PersonnagesComponent } from './personnage/personnages.component';
import { RealisateursComponent } from './realisateur/realisateurs.component';

const routes: Routes = [
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: 'accueil', component: AccueilComponent },
  { path: 'acteurs', component: ActeursComponent },
  { path: 'categories', component: CategoriesComponent },
  { path: 'films', component: FilmsComponent },
  { path: 'personnages', component: PersonnagesComponent },
  { path: 'realisateurs', component: RealisateursComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }