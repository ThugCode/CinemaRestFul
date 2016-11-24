import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ActeursComponent } from './acteur/acteurs.component';
import { CategoriesComponent } from './categorie/categories.component';
import { FilmsComponent } from './film/films.component';
import { FilmDetailComponent } from './film/film-detail.component';
import { FilmAddComponent } from './film/film-add.component';
import { FilmFormComponent } from './film/film-form.component';
import { PersonnagesComponent } from './personnage/personnages.component';
import { RealisateursComponent } from './realisateur/realisateurs.component';

import { MainService } from './shared/main.service';
import { ActeurService } from './acteur/acteur.service';
import { CategorieService } from './categorie/categorie.service';
import { FilmService } from './film/film.service';
import { PersonnageService } from './personnage/personnage.service';
import { RealisateurService } from './realisateur/realisateur.service';

import { AppRoutingModule } from './app-routing.module';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    FormsModule
  ],
  declarations: [
    AppComponent,
    AccueilComponent,
    ActeursComponent,
    CategoriesComponent,
    FilmsComponent,
    FilmDetailComponent,
    FilmAddComponent,
    FilmFormComponent,
    PersonnagesComponent,
    RealisateursComponent
  ],
  providers: [
    MainService,
    ActeurService,
    CategorieService,
    FilmService,
    PersonnageService,
    RealisateurService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
