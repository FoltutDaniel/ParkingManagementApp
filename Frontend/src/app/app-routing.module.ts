import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeViewComponent } from './components/home-view/home-view.component';

import { LoginComponent } from './components/login/login.component';
import { ManageAccountViewComponent } from './components/manage-account-view/manage-account-view.component';
import { ParkViewComponent } from './components/park-view/park-view.component';
import { RegisterComponent } from './components/register/register.component';
import { SettingsViewComponent } from './components/settings-view/settings-view.component';
import { SubscriptionViewComponent } from './components/subscription-view/subscription-view.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: '', component: HomeViewComponent, canActivate: [AuthGuard]},
  { path: 'home', component: HomeViewComponent, canActivate: [AuthGuard]},
  { path: 'parking-view', component: ParkViewComponent, canActivate: [AuthGuard]},
  { path: 'subscription-view', component: SubscriptionViewComponent, canActivate: [AuthGuard]},
  { path: 'manage-account-view', component: ManageAccountViewComponent, canActivate: [AuthGuard]},
  { path: 'settings-view', component: SettingsViewComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
