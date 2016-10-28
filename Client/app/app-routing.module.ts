import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccueilComponent }   from './component/accueil.component';
import { FilmsComponent } from './component/films.component';

const routes: Routes = [
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: 'accueil',  component: AccueilComponent },
  { path: 'films', component: FilmsComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}