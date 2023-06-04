import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css']
})
export class SideMenuComponent implements OnInit{

  username: string = 'Annonymous User';
  toggled: boolean = false;
  constructor(private auth: AuthService) {}

  ngOnInit(){
    this.username = sessionStorage.getItem('username')!;
  }

  toggleSideNav(){
      this.toggled = !this.toggled;
      const sidebar = document.querySelector('.sidebar');
      const mainContent = document.querySelector('.main-content');

      sidebar?.classList.toggle('sidebar_small');
      mainContent?.classList.toggle('main-content_large');
   
  }

  logout(){
    this.auth.logOut();
  }


 
}
