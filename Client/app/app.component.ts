import { Component, OnInit } from '@angular/core';

import * as toastr from 'toastr';

@Component({
  selector: 'my-app',
  templateUrl: 'app/shared/layout.html'
})

export class AppComponent implements OnInit {

  ngOnInit() {
    toastr.options.closeButton = false;
    toastr.options.positionClass = "toast-bottom-right";
  } 
}
