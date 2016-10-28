import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AccueilComponent } from './component/accueil.component';
import { FilmsComponent } from './component/films.component';
import { FilmService } from './service/film.service';

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
    FilmService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
