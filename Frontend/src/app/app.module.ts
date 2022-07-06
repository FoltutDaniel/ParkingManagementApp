import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HeaderComponent } from './components/header/header.component';
import { SideMenuComponent } from './components/side-menu/side-menu.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { FaIconLibrary, FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
import { fab } from '@fortawesome/free-brands-svg-icons';
import { ParkViewComponent } from './components/park-view/park-view.component';
import { ParkingComponent } from './components/parking/parking.component';
import { MapComponent } from './components/map/map.component';
import { HomeViewComponent } from './components/home-view/home-view.component';
import { CarComponent } from './components/car/car.component';
import { SubscriptionViewComponent } from './components/subscription-view/subscription-view.component';
import { ManageAccountViewComponent } from './components/manage-account-view/manage-account-view.component';
import { SettingsViewComponent } from './components/settings-view/settings-view.component';
import { AddCarComponent } from './components/add-car/add-car.component';
import { RemoveCarComponent } from './components/remove-car/remove-car.component';
import { ParkingLogsViewComponent } from './components/parking-logs-view/parking-logs-view.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { ChangeEmailComponent } from './components/change-email/change-email.component';
import { ConfirmSubscriptionComponent } from './components/confirm-subscription/confirm-subscription.component';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { CancelSubscriptionComponent } from './components/cancel-subscription/cancel-subscription.component';
import { AddParkComponent } from './components/add-park/add-park.component';

const material = [
  MatSidenavModule,
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    SideMenuComponent,
    ParkViewComponent,
    ParkingComponent,
    MapComponent,
    HomeViewComponent,
    CarComponent,
    SubscriptionViewComponent,
    ManageAccountViewComponent,
    SettingsViewComponent,
    AddCarComponent,
    RemoveCarComponent,
    ParkingLogsViewComponent,
    ChangePasswordComponent,
    ChangeEmailComponent,
    ConfirmSubscriptionComponent,
    CancelSubscriptionComponent,
    AddParkComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    material,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FontAwesomeModule,
    
  ],
  exports: [
    material
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

 }
