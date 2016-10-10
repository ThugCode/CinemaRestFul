/// <reference path="../typings/index.d.ts"/>

import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES, RouterConfig} from '@angular/router';
import {Hello} from './app/hello.component';

@Component({
  selector: 'root',
  template: `
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">Angular2 Workshop</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a routerLink="/" routerLinkActive="active">Hello</a></li>
            <li><a routerLink="/heroes" routerLinkActive="active">Heroes</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container"><router-outlet></router-outlet></div>
  `,
  directives: [ROUTER_DIRECTIVES]
})
export class Root {
}

export const routes: RouterConfig = [
  {
    path: '',
    component: Hello
  }
];
