import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCarComponent } from './components/add-car/add-car.component';
import { CancelSubscriptionComponent } from './components/cancel-subscription/cancel-subscription.component';
import { ChangeEmailComponent } from './components/change-email/change-email.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { ConfirmSubscriptionComponent } from './components/confirm-subscription/confirm-subscription.component';
import { HomeViewComponent } from './components/home-view/home-view.component';

import { LoginComponent } from './components/login/login.component';
import { ManageAccountViewComponent } from './components/manage-account-view/manage-account-view.component';
import { ParkViewComponent } from './components/park-view/park-view.component';
import { RegisterComponent } from './components/register/register.component';
import { RemoveCarComponent } from './components/remove-car/remove-car.component';
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
  { path: 'settings-view', component: SettingsViewComponent, canActivate: [AuthGuard]},
  { path: 'add-car', component: AddCarComponent, canActivate: [AuthGuard]},
  { path: 'remove-car', component: RemoveCarComponent, canActivate: [AuthGuard]},
  { path: 'change-email', component: ChangeEmailComponent, canActivate: [AuthGuard]},
  { path: 'change-password', component: ChangePasswordComponent, canActivate: [AuthGuard]},
  { path: 'confirm-subscription', component: ConfirmSubscriptionComponent, canActivate: [AuthGuard]},
  { path: 'cancel-subscription', component: CancelSubscriptionComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
