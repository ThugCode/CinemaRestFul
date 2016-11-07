import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AccueilComponent } from './component/accueil.component';
import { FilmsComponent } from './component/films.component';
import { MainService } from './service/main.service';
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
    MainService,
    FilmService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
