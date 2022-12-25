import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContainerComponent} from "./component/container/container.component";
import {RadarComponent} from "./radar/radar.component";
import {ProprietaireComponent} from "./proprietaire/proprietaire.component";
import {VehiculeComponent} from "./vehicule/vehicule.component";
import {InfractionComponent} from "./infraction/infraction.component";

const routes: Routes = [
  { path: '', component: RadarComponent },
  { path: 'owner', component: ProprietaireComponent },
  { path: 'car', component: VehiculeComponent },
  { path: 'infraction', component: InfractionComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
