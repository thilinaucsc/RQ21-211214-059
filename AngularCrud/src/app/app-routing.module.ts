import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetAllInterestComponent } from './components/get-all-interest/get-all-interest.component';
import { GetCustomerInterestComponent } from './components/get-customer-interest/get-customer-interest.component';
import { GetLastInterestComponent } from './components/get-last-interest/get-last-interest.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full', component: DashboardComponent },
  { path: 'get-all', component: GetAllInterestComponent },
  { path: 'get-customer', component: GetCustomerInterestComponent },
  { path: 'get-last', component: GetLastInterestComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
