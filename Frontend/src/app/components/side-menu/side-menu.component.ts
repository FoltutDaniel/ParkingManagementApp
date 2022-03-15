import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css']
})
export class SideMenuComponent {

  username: string = 'John Doe';
  toggled: boolean = false;
  constructor() {}

  toggleSideNav(){
      this.toggled = !this.toggled;
      const sidebar = document.querySelector('.sidebar');
      const mainContent = document.querySelector('.main-content');

      sidebar?.classList.toggle('sidebar_small');
      mainContent?.classList.toggle('main-content_large');
   
  }


 
}
