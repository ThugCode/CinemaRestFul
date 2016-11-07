import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FilmsComponent } from './film/films.component';
import { MainService } from './shared/main.service';
import { FilmService } from './film/film.service';

import { AppRoutingModule } from './app-routing.module';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    AccueilComponent,
    FilmsComponent
  ],
  providers: [
    MainService,
    FilmService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
