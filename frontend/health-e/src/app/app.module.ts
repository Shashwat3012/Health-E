import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MatFormFieldModule, MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatRadioModule } from '@angular/material/radio';
import { HomeComponent, PatientInfoDialog } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import {  MatTooltipModule } from '@angular/material/tooltip';
import { MatDialogModule } from '@angular/material/dialog';
import { DoctorDashboardComponent, DoctorRequestDialog } from './doctor-dashboard/doctor-dashboard.component';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: 'register', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  //{ path: 'second-component', component: SecondComponent },
  { path: 'doctor-dashboard', component: DoctorDashboardComponent}
];

@NgModule({
  declarations: [
    
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    HeaderComponent,
    PatientInfoDialog,
    DoctorDashboardComponent,
    DoctorRequestDialog
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    // MatSliderModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatCardModule,
    // MatSelectModule,
    MatRadioModule,
    MatToolbarModule,
    MatMenuModule,
    MatTooltipModule,
    MatDialogModule,
    HttpClientModule 
  ],
  providers: [
    { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { floatLabel: 'auto' } }, UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
