import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {NgModule} from "@angular/core";
import { RadarComponent } from './radar/radar.component';

import { VehiculeComponent } from './vehicule/vehicule.component';
import { InfractionComponent } from './infraction/infraction.component';

@NgModule({
  declarations: [
    RadarComponent,
    VehiculeComponent,
    InfractionComponent
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: []
})
export class AppModule { }
